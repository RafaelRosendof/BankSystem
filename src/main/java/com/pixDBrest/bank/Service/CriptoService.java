package com.pixDBrest.bank.Service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.security.spec.*;
import java.math.BigDecimal;
import java.security.*;
import javax.crypto.Cipher;
import javax.crypto.*;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pixDBrest.bank.DAO.ClienteDao;
import com.pixDBrest.bank.Entity.Cliente;

@Service
public class CriptoService {
    
    /*
     * Create a cripto key for a client(public and private key)
     * 2^256 
     * store in the database
     * Criptography the private key
     * Criptography the public key
     * Create a method to upload the key to the client  
     * Then aplly the logic for the transaction{
     *      - get the public key from the reciver
     *      - get the private key from the payer
     *      - criptography the value
     *      - criptography the payer key
     *      - criptography the reciver key
     *      - register the transaction
     * } 
     *   
     */

    //generate the cripto key

    @Autowired
    private final ClienteDao clienteDao;

    public CriptoService(ClienteDao clienteDao){
        this.clienteDao = clienteDao;
    }

    // Generate a key pair for a client (public and private key)
    public KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.genKeyPair();
    }

    // Encrypt a message using a public key
    public String encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = encryptCipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    // Decrypt a message using a private key
    public String decrypt(String cipherText, PrivateKey privateKey) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(cipherText);
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(decryptCipher.doFinal(bytes));
    }

    // Store keys in the database
    @Transactional
    public void storeKeysInDatabase(String account, PublicKey publicKey, PrivateKey privateKey) {
        String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        clienteDao.updateKey(account, publicKeyString, privateKeyString);
    }

    // Retrieve and convert keys from database
    public PublicKey getPublicKeyFromString(String key) throws Exception {
        byte[] byteKey = Base64.getDecoder().decode(key);
        X509EncodedKeySpec X509publicKey = new X509EncodedKeySpec(byteKey);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(X509publicKey);
    }

    public PrivateKey getPrivateKeyFromString(String key) throws Exception {
        byte[] byteKey = Base64.getDecoder().decode(key);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(byteKey);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }



    // Example method to handle a transaction
    public void handleTransaction( String account ,String account2, String amount) throws Exception {
        
        Cliente payer = clienteDao.findByAccount(account);
        Cliente receiver = clienteDao.findByAccount(account2);

        if(payer == null || receiver == null){
            throw new Exception("Account not found");
        }



        PublicKey receiverPublicKey = getPublicKeyFromString(receiver.getCriptoKey());
        PrivateKey payerPrivateKey = getPrivateKeyFromString(payer.getPrivateKey());

        // Encrypt the amount
        String encryptedAmount = encrypt(amount, receiverPublicKey);

        BigDecimal ammoutnValue = new BigDecimal(amount);
        BigDecimal payerBalance = payer.getBalance().subtract(ammoutnValue);
        BigDecimal receiverBalance = receiver.getBalance().add(ammoutnValue);

        clienteDao.updateBalance(account, payerBalance);
        clienteDao.updateBalance(account2, receiverBalance);

        //todo: register the transaction
    }

}

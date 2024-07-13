package com.pixDBrest.bank.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixDBrest.bank.DAO.ClienteDao;
import com.pixDBrest.bank.Entity.Cliente;

@Service
public class ClienteService {
    //todo, implementar os métodos disponíveis para cliente 
    private final ClienteDao clienteDao;

    @Autowired
    public ClienteService(ClienteDao clienteDao){
        this.clienteDao = clienteDao;
    }

    public BigDecimal searchBalance(String account){
        return clienteDao.searchBalance(account);
    }

    public void updateKey(String account , String publicKey , String privateKey){
        clienteDao.updateKey(account, publicKey, privateKey);
    }

    public String myStatus(String account){
        return clienteDao.myStatus(account);
    }

    //todo: postumamente criar métodos a mais 
}
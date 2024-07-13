package com.pixDBrest.bank.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.pixDBrest.bank.DAO.ClienteDao;
import com.pixDBrest.bank.DAO.TransactionDAO;

import jakarta.transaction.Transactional;
import com.pixDBrest.bank.Entity.Cliente;
import com.pixDBrest.bank.Entity.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionalService{

    private final ClienteDao clienteDao;
    private final TransactionDAO transactionDAO;

    @Autowired
    public TransactionalService(ClienteDao clienteDao, TransactionDAO transactionDAO){
        this.clienteDao = clienteDao;
        this.transactionDAO = transactionDAO;
    }

    //method for transaction
    
    @Transactional
    public void transaction(String account1 , String account2 , BigDecimal value){
        Cliente t1 = clienteDao.findByAccount(account1);
        Cliente t2 = clienteDao.findByAccount(account2);

        if(t1.getBalance().compareTo(value) < 0){
            throw new IllegalStateException("Not enough balance");
        }

        t1.setBalance(t1.getBalance().subtract(value));
        t2.setBalance(t2.getBalance().add(value));

        clienteDao.updateBalance(account1, value); //in case that give shit, use clienteDao.updateCliente(t1)
        clienteDao.updateBalance(account2, value);

        //Register transaction
        Transaction transaction = new Transaction(t1 , t2 , value , LocalDateTime.now());
        transactionDAO.registerTransaction(transaction);
    }



    //cripto transaction handler in a separated file 

    
}
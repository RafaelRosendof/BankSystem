package com.pixDBrest.bank.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pixDBrest.bank.Entity.Transaction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class TransactionDAO{


    @PersistenceContext
    private final EntityManager entityManager;
    
    @Autowired
    public TransactionDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    public void registerTransaction(Transaction transaction){
        entityManager.persist(transaction);
    }

    @Transactional
    public void registerTransactionCript(Transaction transaction){
        entityManager.persist(transaction);
    }
}
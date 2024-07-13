package com.pixDBrest.bank.DAO;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

//import java.sql.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import com.pixDBrest.bank.Entity.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDao{
    
     @PersistenceContext
     private EntityManager entityManager;

     public ClienteDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
     }

     @Override
     @Transactional
     public void updateCliente(Cliente cliente){
        entityManager.merge(cliente);
     }

     @Override
     public Cliente findById(Integer id){
        return entityManager.find(Cliente.class, id);
     }

     @Override
     @Transactional
     public void saveCliente(Cliente cliente){
        entityManager.persist(cliente);
     }

     @Override
     @Transactional
     public void deleteCliente(Integer id){
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.remove(cliente);
     }

     @Override
     public BigDecimal searchBalance(String account){
   // acho que foi, preciso verificar isso, todo!!!
        String jpql = "SELECT c.balance FROM Cliente c WHERE c.account = :account";
        TypedQuery<BigDecimal> query = entityManager.createQuery(jpql, BigDecimal.class);
        query.setParameter("numeroConta", account);
        return query.getSingleResult();

     }


    @Override
    public Cliente findByAccount(String account){
        return entityManager.find(Cliente.class, account);
    }

    @Override
    public String myStatus(String account){
        TypedQuery<Cliente> aQuery = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.account = :account" , Cliente.class);
        aQuery.setParameter("account", account);

        Cliente cliente;

        try{
            cliente = aQuery.getSingleResult();
        }catch(Exception e){
            return null;
        }

        return cliente.toString();
    }
/* 
    @Override
    public void updateBalance(String account, BigDecimal value){
        Cliente cliente = entityManager.find(Cliente.class, account);
        cliente.setBalance(value);
        entityManager.merge(cliente);
    }
*/
    @Transactional
    @Override
    public void updateBalance(String account , BigDecimal value){
        entityManager.createQuery("UPDATE Cliente c SET c.balance = :value WHERE c.account = :account")
        .setParameter("value",value)
        .setParameter( "account", "account")
        .executeUpdate();
    }

    @Override
    @Transactional
    public void updateKey(String account, String publicKey, String privateKey) {
        entityManager.createQuery("UPDATE Cliente c SET c.criptoKey = :publicKey, c.privateKey = :privateKey WHERE c.account = :account")
                     .setParameter("publicKey", publicKey)
                     .setParameter("privateKey", privateKey)
                     .setParameter("account", account)
                     .executeUpdate();
    }


}

//i think i'm done now 
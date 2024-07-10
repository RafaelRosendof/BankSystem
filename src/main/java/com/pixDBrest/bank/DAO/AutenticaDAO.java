package com.pixDBrest.bank.DAO;

import org.springframework.stereotype.Repository;

import com.pixDBrest.bank.Entity.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AutenticaDAO {

    //Cliente findCliente(String login , String password);
    //Funcionario findEmployee(String login , String password);
    //Funcionario findManager(String login , String password);

    @PersistenceContext
    EntityManager entityManager;

    public AutenticaDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Transactional
    public Cliente findCliente(String login , String password){
        TypedQuery<Cliente> aQuery = entityManager.createQuery("SELECT f from Cliente f WHERE f.login = :login AND f.password = :password" , Cliente.class );
        aQuery.setParameter("login", login);
        aQuery.setParameter("password", password);

        return aQuery.getResultStream().findFirst().orElse(null);
    }

    @Transactional
    public Funcionario findEmployee(String login , String password){
        TypedQuery<Funcionario> aQuery = entityManager.createQuery("SELECT f from Funcionario WHERE f.login = :login AND f.password = :password" , Funcionario.class);
        aQuery.setParameter("login", login);
        aQuery.setParameter("password", password);

        return aQuery.getResultStream().findFirst().orElse(null);
    }

    @Transactional
    public Funcionario findManager(String login , String password){
        TypedQuery<Funcionario> aQuery = entityManager.createQuery("SELECT f from Funcionario WHERE f.login = :login AND f.password = :password" , Funcionario.class);
        aQuery.setParameter("login", login);
        aQuery.setParameter("password", password);

        return aQuery.getResultStream().findFirst().orElse(null);
    }

}

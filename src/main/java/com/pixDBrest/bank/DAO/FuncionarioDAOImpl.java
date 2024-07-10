package com.pixDBrest.bank.DAO;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import com.pixDBrest.bank.Entity.Funcionario;

@Repository
public class FuncionarioDAOImpl implements FuncionarioDAO{
    /*
     Funcionario findById(int id);
    void updateEmployee(int id);  done
    void saveEmployee(int id); done 
    void deleteEmployee(int id); done
    Funcionario searchEmployee(int id);
    Funcionario searchByStatus(int id);
     */

     @PersistenceContext
     private EntityManager entityManager;

     @Autowired
     public FuncionarioDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
     }

     @Override
     @Transactional
     public void saveEmployee(Funcionario funcionario){
        entityManager.persist(funcionario);
     }

     @Override
     @Transactional
     public void updateEmployee(Funcionario funcionario){
        entityManager.merge(funcionario);
     }

     @Override
     @Transactional
     public void deleteEmployee(Integer id){
        Funcionario funcionario = entityManager.find(Funcionario.class, id);
        entityManager.remove(funcionario);
     }

     @Override
     public Funcionario findById(Integer id){
        return entityManager.find(Funcionario.class , id);
     }

     @Override
     public Funcionario searchEmployee(Integer id){
        return entityManager.find(Funcionario.class , id);
     }

     @Override
     public Funcionario searchByStatus(String status){
        return entityManager.find(Funcionario.class, status);
     }

     //Todo, in case that have more methods just put here and in the interface 
     

}
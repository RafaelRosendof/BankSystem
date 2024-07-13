package com.pixDBrest.bank.Service;

import com.pixDBrest.bank.DAO.FuncionarioDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixDBrest.bank.DAO.AutenticaDAO;
import com.pixDBrest.bank.DAO.ClienteDao;
import com.pixDBrest.bank.Entity.Funcionario;
import com.pixDBrest.bank.Entity.Cliente;

@Service
public class AutenticaService{


    private final AutenticaDAO autenticaDAO;

    @Autowired
    public AutenticaService(AutenticaDAO autenticaDAO){
        this.autenticaDAO = autenticaDAO;
    }

    public Cliente findCliente(String login , String password){
        return autenticaDAO.findCliente(login, password);
    }

    public Funcionario findEmployee(String login , String password){
        return autenticaDAO.findEmployee(login, password);
    }

    public Funcionario findManager(String login , String password){
        return autenticaDAO.findManager(login, password);
    }
}



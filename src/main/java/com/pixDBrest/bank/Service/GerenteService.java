package com.pixDBrest.bank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixDBrest.bank.DAO.FuncionarioDAO;
import com.pixDBrest.bank.Entity.Funcionario;

@Service
public class GerenteService{

    private final FuncionarioDAO funcionarioDAO;

    @Autowired
    public GerenteService(FuncionarioDAO funcionarioDAO){
        this.funcionarioDAO = funcionarioDAO;
    }

    public Funcionario findById(Integer id){
        return funcionarioDAO.findById(id);
    }

    public void updateEmployee(Funcionario funcionario){
        funcionarioDAO.updateEmployee(funcionario);
    }

    public void saveEmployee(Funcionario funcionario){
        funcionarioDAO.saveEmployee(funcionario);
    }

    public void deleteEmployee(Integer id){
        funcionarioDAO.deleteEmployee(id);
    }

    public Funcionario searchEmployee(Integer id){
        return funcionarioDAO.searchEmployee(id);
    }

    public Funcionario searchByStatus(String status){
        return funcionarioDAO.searchByStatus(status);
    }

}
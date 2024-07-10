package com.pixDBrest.bank.DAO;

import com.pixDBrest.bank.Entity.Funcionario;

public interface FuncionarioDAO{

    Funcionario findById(Integer id);
    void updateEmployee(Funcionario funcionario);
    void saveEmployee(Funcionario funcionario);
    void deleteEmployee(Integer id);
    Funcionario searchEmployee(Integer id);
    Funcionario searchByStatus(String status);

}
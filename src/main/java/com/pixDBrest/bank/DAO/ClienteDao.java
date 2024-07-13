package com.pixDBrest.bank.DAO;

import java.math.BigDecimal;

import com.pixDBrest.bank.Entity.Cliente;


public interface ClienteDao {

    //methods 
    void updateCliente(Cliente cliente);
    Cliente findById(Integer id);
    void saveCliente(Cliente cliente);
    void deleteCliente(Integer id);
    BigDecimal searchBalance(String account);

    void updateKey(String account , String publicKey , String privateKey);
    Cliente findByAccount(String account);
    String myStatus(String account);

    void updateBalance(String account , BigDecimal value);
}
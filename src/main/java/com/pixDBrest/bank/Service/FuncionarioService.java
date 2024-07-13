package com.pixDBrest.bank.Service;

import com.pixDBrest.bank.DAO.ClienteDao;
import com.pixDBrest.bank.Entity.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService{
    private final ClienteDao clienteDao;

    @Autowired
    public FuncionarioService(ClienteDao clienteDao){
        this.clienteDao = clienteDao;
    }

    public void updateCliente(Cliente cliente){
        clienteDao.updateCliente(cliente);
    }

    public Cliente findById(Integer id){
        return clienteDao.findById(id);
    }

    public void saveCliente(Cliente cliente){
        clienteDao.saveCliente(cliente);
    }

    public void deleteCliente(Integer id){
        clienteDao.deleteCliente(id);
    }

    public Cliente findByAccount(String account){
        return clienteDao.findByAccount(account);
    }

    public void updateKey(String account , String publicKey , String privateKey){
        clienteDao.updateKey(account, publicKey, privateKey);
    }
 
}
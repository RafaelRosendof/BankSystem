package com.pixDBrest.bank.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

/*
 * id
 * client reciver
 * cliente payer
 * value
 * recivekey 
 * payerkey
 */

@Entity
@Table(name = "Transaction")

public class Transaction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "payerID")
    private Cliente payerCliente;

    @ManyToOne
    @JoinColumn(name = "reciverID")
    private Cliente reciveCliente;

    @Column(name = "reciveAccount")
    private String reciveAccount;

    @Column(name = "payerAccount")
    private String payerAccount;

    //todo chaves cripto e outros métodos 

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "reciveKey")
    private String reciveKey;

    @Column(name = "payerKey")
    private String payerKey;

    @Column(name = "criptValue" , precision = 19 , scale =  8 , nullable = false)
    private BigDecimal criptoValue;

    private LocalDateTime data;

    public Transaction(){}

    public Transaction( String reciveKey , String payerKey , BigDecimal criptoValue){
        this.reciveKey = reciveKey;
        this.payerKey = payerKey;
        this.criptoValue = criptoValue;
    }

    public Transaction(Cliente payCliente , Cliente reciveCliente , BigDecimal value , LocalDateTime data){
        this.payerCliente = payCliente;
        this.reciveCliente = reciveCliente;
        this.value = value;
        this.data = data;
    }


    public void setPayClient(Cliente payCliente){
        this.payerCliente = payCliente;
    }
    public Cliente getPayCliente(){
        return payerCliente;
    }

    public void setCriptoValue(BigDecimal criptoValue){
        this.criptoValue = criptoValue;
    }
    public BigDecimal getCriptoValue(){
        return criptoValue;
    }

    public void setReciveCliente(Cliente reciveCliente){
        this.reciveCliente = reciveCliente;
    }
    public Cliente getReciveCliente(){
        return reciveCliente;
    }

    public void setData(LocalDateTime data){
        this.data = data;
    }
    public LocalDateTime getData(){
        return data;
    }

    public void setReciveAccount(String reciveAccount){
        this.reciveAccount =reciveAccount;
    }
    public String getReciveAccount(String reciveAccount){
        return reciveAccount;
    }

    public void setPayerAccount(String payerAccount){
        this.payerAccount = payerAccount;
    }
    public String getPayerAccount(){
        return payerAccount;
    }

    public void setValue(BigDecimal value){
        this.value = value;
    }
    public BigDecimal getValue(){
        return value;
    }

    public void setReciveKey(String reciveKey){
        this.reciveKey = reciveKey;
    }
    public String getReciveKey(){
        return reciveKey;
    }

    public void setPayerKey(String payerKey){
        this.payerKey = payerKey;
    } 
    public String getPayerKey(){
        return payerKey;
    }

/*  leave like this way, maybe one day
    @Override
    public Stirng toString(){
        return 
    }

*/
}

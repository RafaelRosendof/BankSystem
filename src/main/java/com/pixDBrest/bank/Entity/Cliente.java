/*
 * classe filha de entity 
 * have the aditional of account ammount of money, maybe something more
 * Maybe i gonna give some cripto options maybe create a cripto key
 */

 package com.pixDBrest.bank.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Client")

public class Cliente extends User{

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "account")
    private String account;

    @Column(name = "criptoKey")
    private String criptoKey;

    @Column(name = "securityKey")
    private String securityKey;

    @Column(name = "bitcoin" , precision = 19 , scale = 8 , nullable = false )
    private BigDecimal bitcoin;

    @Column(name = "etherum" , precision = 19 , scale = 8 , nullable = false )
    private BigDecimal etherum;

    public Cliente(){}

    public Cliente(String name , String surname , String login , String password , String email, BigDecimal balance , String account , String criptoKey , String securityKey , BigDecimal bitcoin , BigDecimal etherum ){
        super(name, surname, login, password, email);
        this.balance = balance;
        this.account = account;
        this.criptoKey = criptoKey;
        this.securityKey = securityKey;
        this.bitcoin = bitcoin;
        this.etherum = etherum;
    }

    //gets and sets

    public void setBalance(BigDecimal balance){
        this.balance = balance;
    }
    public BigDecimal getBalance(){
        return balance;
    }

    public void setAccount(String account){
        this.account = account;
    }
    public String getAccount(){
        return account;
    }

    public void setCriptoKey(String criptoKey){
        this.criptoKey = criptoKey;
    }
    public String getCriptoKey(){
        return criptoKey;
    }

    public void setSecurityKey(String securityKey){
        this.securityKey = securityKey;
    }
    public String getSecurityKey(){
        return securityKey;
    }

    public void setBitcoin(BigDecimal bitcoin){
        this.bitcoin = bitcoin;
    }
    public BigDecimal getBitcoin(){
        return bitcoin;
    }

    public void setEtherum(BigDecimal etherum){
        this.etherum = etherum;
    }
    public BigDecimal getEtherum(){
        return etherum;
    }

    //to String 
    @Override
    public String toString(){
        return "CLIENT{ " + 
        "BALANCE = " + balance + 
        ", ACCOUNT = " + account + '\''+
        "CRIPTOKEY = " + criptoKey + '\'' + 
        "SECURITYKEY = " + securityKey + '\'' + 
        "BITCOIN = " + bitcoin + '\'' + 
        "ETHERUM = " + etherum + '\'' +
        
        '}' + super.toString();
    }

}
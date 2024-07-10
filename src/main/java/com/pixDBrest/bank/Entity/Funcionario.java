package com.pixDBrest.bank.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/*
 *Son's of entity class, gonna have more parameters  
 like if it's a regular or a manager 
 */
@Entity
@Table(name = "Employee")

public class Funcionario extends User{


    @Column(name = "TypeOfUser")
    private String typeOfUser;

    public Funcionario(){}

    public Funcionario(String name , String surname , String login , String password , String email , String typeOfUser){
        super(name, surname, login, password, email);
        this.typeOfUser = typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser){
        this.typeOfUser = typeOfUser;
    }

    public String getTypeOfUser(){
        return typeOfUser;
    }

    @Override
    public String toString(){
        return "USER{ " + 
        "TypeOfUser = " + typeOfUser + 
    '}' + super.toString();
    }
    
}
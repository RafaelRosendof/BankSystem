/*
 * @Entity padrão 
 * vai cobrir gerente funcionário e cliente
 * nome sobrenome login senha 
 */

package com.pixDBrest.bank.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "login")
    private String login;

    @Column(name = "password") //todo put restrictions in the type of the password
    private String password;

    @Column(name = "email") //todo: put some restrictions in the type of the email 
    private String email;

    public User(){}

    public User(String name , String surname , String login , String password , String email){
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    //gets and sets

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getSurname(){
        return surname;
    }

    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return login;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

   public int getId(){
    return id;
   }

   public void setId(int id){
    this.id = id;
   } 


   @Override
   public String toString(){
    return "USER{ " + 
    "id = " + id + 
    ", NAME = " + name + '\''+
    ", SURNAME = " + surname + '\'' +
    "LOGIN = " + login + '\'' + 
    "PASSWORD = " + password + '\'' + 
    "EMAIL = " + email  + '\'' + 
    '}';
   }

 }
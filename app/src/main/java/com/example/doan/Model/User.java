package com.example.doan.Model;

public class User {

    private  String email ;
    private  String password ;
    private String name ;
    private String repeat_password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name,String email, String password,  String repeat_password) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.repeat_password = repeat_password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getRepeat_password() {
        return repeat_password;
    }
}

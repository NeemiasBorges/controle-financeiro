package com.fatec.controle_financeiro.entities;

public class Usuario {
    private String name;
    private int age;

    // Construtor padrão
    public Usuario() {
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

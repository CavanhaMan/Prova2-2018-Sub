package com.man.cavanha.androidcrud;

import java.io.Serializable;

public class Aluno implements Serializable {

    private int id;
    private String nome;
    private String nota;

    public Aluno(int id, String nome, String nota){
        this.id = id;
        this.nome = nome;
        this.nota = nota;
    }

    public int getId(){ return this.id; }
    public String getNome(){ return this.nome; }
    public String getNota(){ return this.nota; }

    @Override
    public boolean equals(Object o){
        return this.id == ((Aluno)o).id;
    }

    @Override
    public int hashCode(){
        return this.id;
    }
}
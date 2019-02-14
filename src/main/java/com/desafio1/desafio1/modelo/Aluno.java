package com.desafio1.desafio1.modelo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Aluno {
    private String nome;
    private String matricula;
    private String telefone;
    private String email;
    private String uffmail;
    private Boolean status;

    public Aluno(String nome, String matricula, String telefone, String email, String uffmail, Boolean status) {
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.email = email;
        this.uffmail = uffmail;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUffmail() {
        return uffmail;
    }

    public void setUffmail(String uffmail) {
        this.uffmail = uffmail;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<String> getListNome(){
        return Arrays.asList(nome.split(" "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(nome, aluno.nome) &&
                Objects.equals(matricula, aluno.matricula) &&
                Objects.equals(telefone, aluno.telefone) &&
                Objects.equals(email, aluno.email) &&
                Objects.equals(uffmail, aluno.uffmail) &&
                Objects.equals(status, aluno.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, matricula, telefone, email, uffmail, status);
    }
}

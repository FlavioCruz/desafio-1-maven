package com.desafio1.Desafio1.Classes;

import com.desafio1.Desafio1.Exceptions.GenerationException;

import java.util.List;

public interface GeracaoDeEmail {
    public List<String> escolhaDeEmail(String matricula) throws GenerationException;
    public void finalizaCadastroEmail(Aluno aluno, String email) throws GenerationException;
}

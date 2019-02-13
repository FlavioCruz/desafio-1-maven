package com.desafio1.desafio1.servico;

import com.desafio1.desafio1.modelo.Aluno;
import com.desafio1.desafio1.exception.GenerationException;

import java.util.List;

public interface GeracaoDeEmail {
    public List<String> escolhaDeEmail(String matricula) throws GenerationException;
    public void finalizaCadastroEmail(Aluno aluno, String email) throws GenerationException;


    List<String> gerarEmails(List<String> nome);
}

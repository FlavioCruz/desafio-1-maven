package com.desafio1.Desafio1.Exceptions;

/**
 * Classe que é lançada quando existe algum problema na recuperação de aluno, por erros previstos.
 */
public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message){
        super(message);
    }
}

package com.desafio1.desafio1.exception;

/**
 * Classe que é lançada quando existe algum problema na geração de email, por erros previstos.
 */
public class GenerationException extends Exception {
    public GenerationException(String message){
        super(message);
    }
}

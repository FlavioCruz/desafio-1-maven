package com.desafio1.desafio1.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AlunoTests {
    @Test
    public void valida_nome_token(){
        Aluno aluno = new Aluno("Aluno Teste",
                                "123456",
                                "987654321",
                                null,
                                null,
                                true);

        Assertions.assertArrayEquals(Arrays.asList("Aluno", "Teste").toArray(), aluno.getListNome().toArray());
    }
}

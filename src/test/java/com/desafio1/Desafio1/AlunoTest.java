package com.desafio1.Desafio1;

import com.desafio1.Desafio1.Classes.Aluno;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class AlunoTest {
    @Test
    public void valida_nome_token(){
        Aluno aluno = new Aluno("Aluno Teste",
                                "123456",
                                "987654321",
                                null,
                                null,
                                true);

        Assert.assertArrayEquals(Arrays.asList("Aluno", "Teste").toArray(), aluno.getListNome().toArray());
    }
}

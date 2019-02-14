package com.desafio1.desafio1.servico;

import com.desafio1.desafio1.exception.GenerationException;
import com.desafio1.desafio1.modelo.Aluno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class GeracaoDeEmailTests {
    @Autowired
    private GeracaoDeEmail gerador;
    @Autowired
    ServicosDeCSV csv;

    private static final String MATRICULA = "105794";
    private static final String NOME = "Luiza Fernandes Ferreira";
    private static final Aluno ALUNO =
            new Aluno(NOME, MATRICULA, "99999-9950", "email@gmail.com",
                    "uffmail@id.uff.br", true);

    private static final List<String> EMAILS = Arrays.asList(
            "luiza_fernandes@id.uff.br",
            "luizaff@id.uff.br",
            "luizaferreira@id.uff.br",
            "lferreira@id.uff.br",
            "lfernandesferreira@id.uff.br");

    private void readFile(){
        try {
            csv.readCSVFile("./alunos.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifica_regra_de_criacao(){
        readFile();
        Assertions.assertArrayEquals(EMAILS.toArray(),
                gerador.gerarEmails(Arrays.asList("Luiza", "Fernandes", "Ferreira")).toArray());
    }

    @Test
    public void verifica_escolha_de_email_correta() throws GenerationException {
        readFile();
        Assertions.assertArrayEquals(EMAILS.toArray(), gerador.escolhaDeEmail(MATRICULA).toArray());
    }

    @Test
    public void verifica_escolha_de_email_generation_exception(){
        readFile();
        Assertions.assertThrows(GenerationException.class, () -> {
            gerador.escolhaDeEmail("matrícula inválida");
        });
    }

    @Test
    public void verifica_finalizacao_email_exception_aluno_nulo(){
        readFile();
        Assertions.assertThrows(GenerationException.class, () -> {
            gerador.finalizaCadastroEmail(null, ALUNO.getEmail());
        });
    }

    @Test
    public void verifica_finalizacao_email_exception_email_cadastrado(){
        readFile();
        Assertions.assertThrows(GenerationException.class, () -> {
            gerador.finalizaCadastroEmail(ALUNO, ALUNO.getUffmail());
        });
    }
}
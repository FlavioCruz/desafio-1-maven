package com.desafio1.desafio1.servico;

import com.desafio1.desafio1.modelo.Aluno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ServiçosDeCSVTests {
    @Autowired
    ServicosDeCSV servicosDeCSV;

    private static final String MATRICULA = "105794";
    private static final String UFFMAIL = "uffmail@id.uff.br";

    private static final Aluno ALUNO =
            new Aluno("Luiza Fernandes Ferreira", MATRICULA, "99999-9950", "email@gmail.com",
                    UFFMAIL, true);


    @Test
    public void verifica_leitura_arquivo_caminho_correto() throws IOException {
        ServicosDeAluno mock = mock(ServicosDeAluno.class);
        servicosDeCSV.setRepositorioMock(mock);
        servicosDeCSV.readCSVFile("./alunos.csv");
        servicosDeCSV.desfazMock();
        verify(mock, times(1)).salvar(ALUNO);
    }

    @Test
    public void verifica_leitura_arquivo_caminho_errado(){
        assertThrows(FileNotFoundException.class, () -> {
           servicosDeCSV.readCSVFile("caminho errado");
        });
    }
}

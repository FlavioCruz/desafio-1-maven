package com.desafio1.desafio1.servico;

import com.desafio1.desafio1.dado.AlunoDados;
import com.desafio1.desafio1.exception.StudentNotFoundException;
import com.desafio1.desafio1.modelo.Aluno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@SpringBootTest
public class ServicosDeAlunoTests {

    @Autowired
    ServicosDeAluno servicosDeAluno;

    @Autowired
    ServicosDeCSV csv;

    private static final AlunoDados repositorioDeAlunoDados = mock(AlunoDados.class);

    private static final String MATRICULA = "105794";
    private static final String UFFMAIL = "uffmail@id.uff.br";

    private static final Aluno ALUNO =
            new Aluno("Luiza Fernandes Ferreira", MATRICULA, "99999-9950", "email@gmail.com",
                    UFFMAIL, true);

    private void readFile(){
        try {
            csv.readCSVFile("./alunos.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifica_obter_todos_os_alunos(){
        readFile();
        servicosDeAluno.setRepositorioMock(repositorioDeAlunoDados);
        servicosDeAluno.obterTodos();
        servicosDeAluno.desfazMock();
        verify(repositorioDeAlunoDados, times(1)).obterTodos();
    }

    @Test
    public void verifica_obter_correto_aluno_por_matricula() throws StudentNotFoundException {
        readFile();
        assertEquals(ALUNO, servicosDeAluno.obterAlunoPorMatricula(MATRICULA));
    }

    @Test
    public void verifica_obter_errado_aluno_por_matricula(){
        readFile();
        assertThrows(StudentNotFoundException.class, () ->{
            servicosDeAluno.obterAlunoPorMatricula("");
        });
    }

    @Test
    public void verifica_salvar_aluno(){
        readFile();
        servicosDeAluno.setRepositorioMock(repositorioDeAlunoDados);
        servicosDeAluno.salvar(ALUNO);
        servicosDeAluno.desfazMock();
        verify(repositorioDeAlunoDados, times(1)).salvar(ALUNO);
    }

    @Test
    public void verifica_atualizar_aluno(){
        readFile();
        servicosDeAluno.setRepositorioMock(repositorioDeAlunoDados);
        servicosDeAluno.atualizar(ALUNO);
        servicosDeAluno.desfazMock();
        verify(repositorioDeAlunoDados, times(1)).atualizar(ALUNO);
    }

    @Test
    public void verifica_obter_correto_aluno_por_email() throws StudentNotFoundException {
        readFile();
        assertEquals(ALUNO, servicosDeAluno.obterAlunoPorEmail(UFFMAIL));
    }

    @Test
    public void verifica_obter_errado_aluno_por_email(){
        readFile();
        assertThrows(StudentNotFoundException.class, () ->{
            servicosDeAluno.obterAlunoPorEmail("email incorreto");
        });
    }
}

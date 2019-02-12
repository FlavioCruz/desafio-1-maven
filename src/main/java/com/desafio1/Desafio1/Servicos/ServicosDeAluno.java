package com.desafio1.Desafio1.Servicos;

import com.desafio1.Desafio1.Classes.Aluno;
import com.desafio1.Desafio1.Dados.AlunoDados;
import com.desafio1.Desafio1.Exceptions.StudentNotFoundException;

import java.util.List;

//camada de serviços que fazem a conexão entre dados e aplicação
public interface ServicosDeAluno {
    public List<Aluno> obterTodos();

    /**
     * obtenho a entidade dado o parâmetro
     * @param matricula {@link String}
     * @return {@link Aluno}
     */
    public Aluno obterAlunoPorMatricula(String matricula) throws StudentNotFoundException;

    /**
     * salvo a entidade
     * @param aluno {@link Aluno}
     */
    public void salvar(Aluno aluno);

    public void atualizar(Aluno aluno);

    public Aluno obterAlunoPorEmail(String email) throws StudentNotFoundException;
}

package com.desafio1.Desafio1.Servicos.Impl;


import com.desafio1.Desafio1.Classes.Aluno;
import com.desafio1.Desafio1.Dados.AlunoDados;
import com.desafio1.Desafio1.Exceptions.StudentNotFoundException;
import com.desafio1.Desafio1.Servicos.ServicosDeAluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicosDeAlunoImpl implements ServicosDeAluno {

    private AlunoDados repositorioDeAlunoDados;

    public ServicosDeAlunoImpl(){
    }

    public List<Aluno> obterTodos(){
        return repositorioDeAlunoDados.obterTodos();
    }

    /**
     * obtenho a entidade dado o parâmetro
     * @param matricula {@link String}
     * @return {@link Aluno}
     */
    public Aluno obterAlunoPorMatricula(String matricula) throws StudentNotFoundException {
        List<Aluno> alunos = repositorioDeAlunoDados.obterTodos();
        for(Aluno a : alunos){
            if(a.getMatricula().equalsIgnoreCase(matricula)){
                return a;
            }
        }
        throw new StudentNotFoundException("Matrícula inexistente!");
    }

    /**
     * salvo a entidade
     * @param aluno {@link Aluno}
     */
    public void salvar(Aluno aluno){
        repositorioDeAlunoDados.salvar(aluno);
    }

    public void atualizar(Aluno aluno){
        repositorioDeAlunoDados.atualizar(aluno);
    }

    public Aluno obterAlunoPorEmail(String email) throws StudentNotFoundException {
        if(email == null){
            throw new NullPointerException();
        }
        List<Aluno> alunos = repositorioDeAlunoDados.obterTodos();
        for(Aluno a : alunos){
            if(a.getEmail().equalsIgnoreCase(email)){
                return a;
            }
        }
        return null;
    }
}

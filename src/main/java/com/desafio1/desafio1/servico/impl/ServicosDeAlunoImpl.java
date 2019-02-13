package com.desafio1.desafio1.servico.impl;


import com.desafio1.desafio1.modelo.Aluno;
import com.desafio1.desafio1.dado.AlunoDados;
import com.desafio1.desafio1.exception.StudentNotFoundException;
import com.desafio1.desafio1.servico.ServicosDeAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicosDeAlunoImpl implements ServicosDeAluno{

    @Autowired
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
        List<Aluno> alunos = obterTodos();
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
        List<Aluno> alunos = obterTodos();
        for(Aluno a : alunos){
            if(a.getEmail().equalsIgnoreCase(email)){
                return a;
            }
        }
        return null;
    }
}

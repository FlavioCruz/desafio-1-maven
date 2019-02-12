package com.desafio1.Desafio1.Dados;

import com.desafio1.Desafio1.Classes.Aluno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoDados{

    // variável que simula um bd e vai servir de banco de dados
    private List<Aluno> alunos;

    public List<Aluno> obterTodos(){
        return alunos;
    }

    public void salvar(Aluno entidade){
        if(alunos == null){
            alunos = new ArrayList<>();
        }
        alunos.add(entidade);
    }

    public void atualizar(Aluno entidade){
        for(int i = 0; i < alunos.size(); i++){
            if (alunos.get(i).getMatricula().equalsIgnoreCase(entidade.getMatricula())){
                alunos.get(i).setEmail(entidade.getEmail());
            }
        }
    }
}

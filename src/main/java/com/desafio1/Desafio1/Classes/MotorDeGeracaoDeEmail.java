package com.desafio1.Desafio1.Classes;

import com.desafio1.Desafio1.Exceptions.GenerationException;
import com.desafio1.Desafio1.Exceptions.StudentNotFoundException;
import com.desafio1.Desafio1.Servicos.ServicosDeAluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorDeGeracaoDeEmail implements GeracaoDeEmail {

    private final String MAIL = "@id.uff.br";

    public MotorDeGeracaoDeEmail(){}

    /**
     * Gera uma lista de emails baseada no nome completo do Aluno
     * @param nome {@link String}
     * @return {@link List<String>}
     */
    private List<String> gerarEmails(List<String> nome){
        List<String> emails = new ArrayList<String>();
        emails.add(nome.get(0).toLowerCase() + "_" + nome.get(1).toLowerCase() + MAIL);

        emails.add(nome.get(0).toLowerCase() + "" + nome.get(1).substring(0, 1).toLowerCase() +
                "" + nome.get(2).substring(0, 1).toLowerCase() + MAIL);

        emails.add(nome.get(0).toLowerCase() + "" + nome.get(2).toLowerCase() + MAIL);

        emails.add(nome.get(0).substring(0, 1).toLowerCase() +
                "" + nome.get(2).toLowerCase() + MAIL);

        emails.add(nome.get(0).substring(0, 1).toLowerCase() +
                "" + nome.get(1).toLowerCase() + "" + nome.get(2).toLowerCase() + MAIL);
        return emails;
    }

    /**
     * Retorno a lista de emails criados após verificar se o aluno está ativo
     * @param matricula {@link String}
     * @return {@link Aluno}
     * @throws GenerationException
     */
    public List<String> escolhaDeEmail(String matricula) throws GenerationException {
        // scanner para receber inputs do teclado
        Scanner teclado = new Scanner(System.in);
        // recupero a entidade aluno pela matricula
        Aluno aluno = null;
        try {
            aluno = ServicosDeAluno.getInstance().obterAlunoPorMatricula(matricula);

            // se o aluno não estiver ativo, retorno um erro
            if(!aluno.getStatus()){
                throw new GenerationException("Aluno não está com a matrícula ativa");
            }
            // gero a lista de emails do aluno
            return gerarEmails(aluno.getListNome());



        } catch (Exception e) {
            throw new GenerationException(e.getMessage());
        }
    }

    /**
     * Finaliza o cadastro do aluno e atualiza na lista de alunos
     * @param aluno {@link Aluno}
     * @param email {@link String}
     * @throws GenerationException
     */
    public void finalizaCadastroEmail(Aluno aluno, String email) throws GenerationException {
        try {
            if(aluno.equals(ServicosDeAluno.getInstance().obterAlunoPorEmail(email))){
                throw new GenerationException("Email já cadastrado");
            }
        } catch (StudentNotFoundException e) {
            throw new GenerationException("Aluno não encontrado");
        }
        aluno.setUffmail(email);
        ServicosDeAluno.getInstance().atualizar(aluno);
    }
}

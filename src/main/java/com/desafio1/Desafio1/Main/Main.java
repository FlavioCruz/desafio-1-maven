/**
 * @author Flavio Cruz
 */

package com.desafio1.Desafio1.Main;

import com.desafio1.Desafio1.Classes.Aluno;
import com.desafio1.Desafio1.Classes.GeracaoDeEmail;
import com.desafio1.Desafio1.Classes.MotorDeGeracaoDeEmail;
import com.desafio1.Desafio1.Exceptions.GenerationException;
import com.desafio1.Desafio1.Exceptions.StudentNotFoundException;
import com.desafio1.Desafio1.Servicos.ServicosDeAluno;
import com.desafio1.Desafio1.Utils.Utils;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Exception exception = null;
        
        // inicializo a lista de alunos
        String caminho = "./alunos.csv";
        Utils.getInstance().Initialize(caminho);

        // scanner para ler inputs do teclado
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite sua matrícula: ");
        String matricula = teclado.next();
        // recupero o aluno pela matrícula e gero o email caso a matrícula seja válida
        try{
            GeracaoDeEmail gerador = new MotorDeGeracaoDeEmail();
            Aluno aluno = ServicosDeAluno.getInstance().obterAlunoPorMatricula(matricula);
            List<String> emails = gerador.escolhaDeEmail(matricula);
            System.out.println(aluno.getNome().split(" ")[0] + ", por favor escolha uma das opções abaixo para o seu UFFMail");
            for (int i = 0; i < emails.size(); i++){
                System.out.println((i + 1) + " - " + emails.get(i));
            }
            int escolhido = teclado.nextInt() - 1;
            if(escolhido <= 0 ||escolhido >= emails.size()){
                throw new GenerationException("Opção escolhida não é válida!");
            }
            teclado.close();
            gerador.finalizaCadastroEmail(aluno, emails.get(escolhido));

            System.out.println("A criação de seu e-mail (" + aluno.getUffmail() +") será feita nos próximos minutos.\n" +
                    "Um SMS foi enviado para " + aluno.getTelefone() +" com a sua senha de acesso.");
        } catch (GenerationException | StudentNotFoundException e) {
            tratandoException(e);
        }
    }

    private static void tratandoException(Exception e){
        System.err.println(e.getMessage());
        System.out.println();
        main(null);
    }
}

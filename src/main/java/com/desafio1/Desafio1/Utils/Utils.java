package com.desafio1.Desafio1.Utils;

import com.desafio1.Desafio1.Classes.Aluno;
import com.desafio1.Desafio1.Servicos.ServicosDeAluno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// essa classe funciona na aplicação como um inicializador de contexto
public class Utils {
    private static Utils _utils;
    private ServicosDeAluno servicosDeAluno;

    private Utils(){}

    /**
     * instância Singleton
     * @return {@link Utils}
     */
    public static Utils getInstance(){
        if(_utils == null){
            _utils = new Utils();
        }
        return _utils;
    }

    /**
     * Leio os dados do arquivo e "persisto" na camada de dados de aluno
     * @param caminho {@link String}
     */
    private void readCSVFile(String caminho){
        BufferedReader br = null;
        String linha = "";

        try {
            br = new BufferedReader(new FileReader(caminho));
            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                Boolean status = dados[5].equalsIgnoreCase("Ativo");
                ServicosDeAluno.getInstance().salvar(new Aluno(dados[0], dados[1], dados[2], dados[3], dados[4], status));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Inicializo a camada de dados da aplicação
     * O caminho está relativo.
     */
    public void Initialize(String path){
        readCSVFile(path);
    }
}

package com.desafio1.desafio1.servico.impl;

import com.desafio1.desafio1.modelo.Aluno;
import com.desafio1.desafio1.servico.ServicosDeAluno;
import com.desafio1.desafio1.servico.ServicosDeCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class ServicosDeCSVImpl implements ServicosDeCSV {
    @Autowired
    private ServicosDeAluno servicosDeAluno;


    /**
     * Leio os dados do arquivo e "persisto" na camada de dados de aluno
     * @param caminho {@link String}
     */
    public void readCSVFile(String caminho){
        BufferedReader br = null;
        String linha = "";

        try {
            br = new BufferedReader(new FileReader(caminho));
            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                Boolean status = dados[5].equalsIgnoreCase("Ativo");
                servicosDeAluno.salvar(new Aluno(dados[0], dados[1], dados[2], dados[3], dados[4], status));
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
}

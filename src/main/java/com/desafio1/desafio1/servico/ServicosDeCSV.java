package com.desafio1.desafio1.servico;

public interface ServicosDeCSV {

    /**
     * Leio os dados do arquivo e "persisto" na camada de dados de aluno
     * @param caminho {@link String}
     */
    void readCSVFile(String caminho);
}

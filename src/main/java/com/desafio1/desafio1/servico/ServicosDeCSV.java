package com.desafio1.desafio1.servico;

import java.io.IOException;

public interface ServicosDeCSV {

    void setRepositorioMock(ServicosDeAluno mock);
    void desfazMock();

    /**
     * Leio os dados do arquivo e "persisto" na camada de dados de aluno
     * @param caminho {@link String}
     */
    void readCSVFile(String caminho) throws IOException;
}

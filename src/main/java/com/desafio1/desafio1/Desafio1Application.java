package com.desafio1.desafio1;

import com.desafio1.desafio1.dado.AlunoDados;
import com.desafio1.desafio1.servico.Main;
import com.desafio1.desafio1.servico.ServicosDeAluno;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {AlunoDados.class, ServicosDeAluno.class, Main.class})
public class Desafio1Application {


	public static void main(String[] args) {
		try(ConfigurableApplicationContext context = SpringApplication.run(Desafio1Application.class, args)){
			Main mainClass = context.getBean(Main.class);
			mainClass.main(null);
		}


	}

}


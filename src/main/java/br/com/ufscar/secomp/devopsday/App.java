package br.com.ufscar.secomp.devopsday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan (basePackages = { "br.com.ufscar.secomp.devopsday.model" })
@EnableJpaRepositories (basePackages = { "br.com.ufscar.secomp.devopsday.repositories" })
@ComponentScan (basePackages = { "br.com.ufscar.secomp.devopsday.controllers" })
public class App {
    public static void main( String[] args ) {
    	SpringApplication.run(App.class, args);
    }
}

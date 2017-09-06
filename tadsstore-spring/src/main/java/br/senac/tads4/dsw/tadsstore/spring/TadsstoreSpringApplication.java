package br.senac.tads4.dsw.tadsstore.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//@SpringBootApplication(exclude={org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration.class} )
@SpringBootApplication
public class TadsstoreSpringApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(TadsstoreSpringApplication.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(TadsstoreSpringApplication.class, args);
  }
}

package com.mokslai.internetisskaiciuotuvas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// SpringBootApplication anotacija yra lygi @Cofiguration , @EnableAutoConfiguration ir @ComponentScan.
// Si anotacija nurodoma klaseje turincioje pagrindini main metoda.
@SpringBootApplication
public class InternetisSkaiciuotuvasApplication {

	public static void main(String[] args) {
		// Programos kontorle deleguojama statiniam klases metodui run
		// nurodant aplikacijos sakniny komponenta ( root ).
		// Spring karkasas paleis aplikacija tai yra startuos TomCat serveri.
		SpringApplication.run(InternetisSkaiciuotuvasApplication.class, args);
	}

}

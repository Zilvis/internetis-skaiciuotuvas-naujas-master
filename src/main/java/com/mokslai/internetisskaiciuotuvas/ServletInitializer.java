package com.mokslai.internetisskaiciuotuvas;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// Servlet yra java programa veikianti web serveryje.
// Servlet paleidziamas kai vartotojas paspaudzia nuoroda,
// pateikia forma ar atlieka kito tipo veiksmus internetineje svetaineje.
// Kiekviena klijento uzklausa ( request ) praeina per servlet kuri ji perduoda kontrolerio request mapping atribute.
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InternetisSkaiciuotuvasApplication.class);
	}

}

package com.mokslai.internetisskaiciuotuvas;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Web kontroleris leidzia viduje naudoti @RequestMapping.
// @RestController anotacija nurodo , jog pvz: String tipo rezultatas turetu buti ispauzdinamas klijentui toks koks yra.
@RestController

// Zymi konfiguracijos komponenta viduje leidzia kurti bean per metodus su @Bean anotacija.
// Si klases lygio anotacija nurodo spring karkasui "Atspeti" konfiguracija.
// Rementis priklausomybemis ( Jar bibliotekomis ) kurias programuotojas ytraukia i projekta ( pom.xml )
// Siuo atveju ji veikia kartu su main metodu.
@EnableAutoConfiguration

public class InternetinisSkaiciuotuvasController {
    // nebutina nurodyti method = RequestMethod.GET, value =
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index () {
        // ApplicationContext yra interface skirtas suteikti informacija apie aplikacijos konfiguracija.
        // Siuo atveju naudojama konfiguracija paimama is beans.xml failo
        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");

        // bean - klases objektas kuris atitinka singleton sablona.
        HelloWorld bean = (HelloWorld) appContext.getBean("helloWorld");
        return bean.getHello();
//        return "Internetinis Skaiciuotuvas <p>" +
//                "<b>Galimos operacijos:     </b></br>" +
//                "<li>&nbsp;&nbsp; sudeti    </br></li>"+
//                "<li>&nbsp;&nbsp; dauginti  </br></li>"+
//                "<li>&nbsp;&nbsp; dalinti   </br></li>"+
//                "<li>&nbsp;&nbsp; atimtis   </br></li></p>";
    }

}

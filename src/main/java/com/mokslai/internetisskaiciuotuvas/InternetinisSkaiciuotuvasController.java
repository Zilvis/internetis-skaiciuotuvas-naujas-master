package com.mokslai.internetisskaiciuotuvas;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

// Web kontroleris leidzia viduje naudoti @RequestMapping.
// @RestController anotacija nurodo , jog pvz: String tipo rezultatas turetu buti ispauzdinamas klijentui toks koks yra.

// @Restcontroller anotacija naudojama tada kai frontend nenaudojam springo ( javaScript React Angular )
// Dazniausiai grazinami formatai ( json , xml )
// Tai yra negraziname vaizdo ( formos HTML JSP )
// Kadangi mums reikia grazinti vaizda ( View ) pagal spring mvc naudosime anotacija @Controller
@Controller

// Zymi konfiguracijos komponenta viduje leidzia kurti bean per metodus su @Bean anotacija.
// Si klases lygio anotacija nurodo spring karkasui "Atspeti" konfiguracija.
// Rementis priklausomybemis ( Jar bibliotekomis ) kurias programuotojas ytraukia i projekta ( pom.xml )
// Siuo atveju ji veikia kartu su main metodu.
@EnableAutoConfiguration

public class InternetinisSkaiciuotuvasController {
    // nebutina nurodyti method = RequestMethod.GET, value =
    // Kadangi skaiciuotuvo forma naudoja POST metoda cia irgi nurodysime POST
    @RequestMapping(method = RequestMethod.POST, value = "/skaiciuoti")
    // RequestParam anotacija perduoda siuo atveju per url perduotus duomenis ( du skaiciai operacijos zenklas )
    // kurie patalpinami i sarasa ( raktas reiksme )
    // Pirmas String yra raktas (sk1 sk2 zenklas ) o antras - reiksme (8 , 5 , + )
    // TODO: Raktai tiek frontend tiek backend turi sutapti !
    // URL pvz: http://localhost:8080/skaiciuoti?sk1=2&sk2=3&zenklas=*
    // Encoder https://meyerweb.com/eric/tools/dencoder/


    public String skaiciuoti(@RequestParam HashMap <String , String> ivedimoSarasas, ModelMap isvedimoSarasas) {
        // Per url perduodamas raktas ( kintamasis ) turi pavadinima sk1
        // Pagal rakta sk1 istraukiama reiksme pvz ( tarkime vartotojas ivede 8 )
        // Vadinasi mums reikia konvertuoti is String i Int kad paskaiciuotumeme rezultata
        int sk1 = Integer.parseInt(ivedimoSarasas.get("sk1"));
        int sk2 = Integer.parseInt(ivedimoSarasas.get("sk2"));
        String zenklas = ivedimoSarasas.get("zenklas");

        double ats = 0;
        if (zenklas.equals("+")) {
            ats = sk1 + sk2;
        } else if (zenklas.equals("-")) {
            ats = sk1 - sk2;
        } else if (zenklas.equals("*")){
            ats = sk1 * sk2;
        } else if (zenklas.equals("/") && sk2 != 0){
            ats = sk1 / sk2;
        }

        // Ivedimo sarasas naudojamas siusti duomenis is Spring MVC controlerio i Jsp faila ( vaizda )
        isvedimoSarasas.put("sk1", sk1);
        isvedimoSarasas.put("sk2", sk2);
        isvedimoSarasas.put("zenklas", zenklas);
        isvedimoSarasas.put("rezultatas", ats);

        // Grazinamas vaizdas ( forma )
        // Svarbu nurodyti per Aplication.properties prefix ir suffix
        // Nes pagal tai ieskos vaizdo projekte
        return "skaiciuoti";
        // ApplicationContext yra interface skirtas suteikti informacija apie aplikacijos konfiguracija.
        // Siuo atveju naudojama konfiguracija paimama is beans.xml failo
        //ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");

        // bean - klases objektas kuris atitinka singleton sablona.
       // HelloWorld bean = (HelloWorld) appContext.getBean("helloWorld");
       // return bean.getHello();
//        return "Internetinis Skaiciuotuvas <p>" +
//                "<b>Galimos operacijos:     </b></br>" +
//                "&nbsp;&nbsp; sudeti    </br>"+
//                "&nbsp;&nbsp; dauginti  </br>"+
//                "&nbsp;&nbsp; dalinti   </br>"+
//                "&nbsp;&nbsp; atimtis   </br></p>";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String rodytiPagrindiniPuslapi (){

        // Graziname jsp faila kuris turi buti talpinamas "webapp -> WEB-INF -> JSP" aplanke
        return "skaiciuotuvas";
    }
}

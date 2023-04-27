package com.mokslai.internetisskaiciuotuvas.config;

import com.mokslai.internetisskaiciuotuvas.Service.SkaiciaiService;
import com.mokslai.internetisskaiciuotuvas.Service.SkaiciaiServiceImpl;
import com.mokslai.internetisskaiciuotuvas.model.SkaiciusZenklasDAO;
import com.mokslai.internetisskaiciuotuvas.model.SkaiciusZenklasDAOImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration anotacija zyminti konfiguracijos komponenta
// Viduje leidzia kurti @Bean per metodus su @Beam anotacija
@Configuration
public class SpringConfig {

    // @Bean tai objektai kurie sudaro Spring aplikacijos pagrinda.
    // Paprastai tai java klase realizuojanti tam tikra interface ir java @Bean specifikacija
    // @Bean atitinka Singleton sablona - programines irangos projektavimo schema,
    // kuri riboja klases ivykdyma vienu vieninteliu egzemplioriumi
    // Tai naudinga kai reikia tiksliai vieno objekto norint kordinuoti veiksmus visoje sistemoje.
    @Bean
    // @Qualifier anotacija kartu su @Autowired patikslina su kuriuo konkreciai @Bean susieti priklausomybe
    // Jeigu @Configuration klaseje yra daugiau negu vienas @Bean , @Qualifier anotacija yra privaloma
    @Qualifier("SkaiciusZenklasDAO")
    public SkaiciusZenklasDAO getSkaiciusZenklasDAO(){
        return new SkaiciusZenklasDAOImpl();
    }

    @Bean
    @Qualifier ("SkaiciaiService")
    public SkaiciaiService getSkaiciaiService(){
        return new SkaiciaiServiceImpl();
    }

}

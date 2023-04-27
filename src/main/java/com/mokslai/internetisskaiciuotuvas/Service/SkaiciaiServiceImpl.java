package com.mokslai.internetisskaiciuotuvas.Service;

import com.mokslai.internetisskaiciuotuvas.model.SkaiciusZenklas;
import com.mokslai.internetisskaiciuotuvas.model.SkaiciusZenklasDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

// Service - servisu sluoksnis verslo logikai
// Service yra Spring Boot architektūros dalis, kuri yra skirta atskirti verslo logiką nuo prezentacijos sluoksnio.
// Tai reiškia, kad service klasės aprašo konkrečias funkcijas arba operacijas, kurias reikia atlikti aplikacijoje.
// Paprastai service klasės turi sąsajas, kurias naudoja kiti komponentai, pvz., kontroleris arba kitos serviso klasės.
// Po serviso sluoksniu kreipiames i DAO ( DB )
@Service
public class SkaiciaiServiceImpl implements SkaiciaiService{

    // @Autowired naudojama automatiniai priklausomybiu injekcijai
    // Kad panaudoti @Autowired anotacija reikia pirmiausia tureti apsirasius @Bean @Configuration klase
    @Autowired
    // @Qualifier anotacija kartu su @Autowired patikslina su kuriuo konkreciai @Bean susieti priklausomybe
    // Jeigu @Configuration klaseje yra daugiau negu vienas @Bean , @Qualifier anotacija yra privaloma
    // Kitu atveju metama klaida:
    //// 'Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans,
    // or using @Qualifier to identify the bean that should be consumed'
    // T.Y: Ši pranešimas yra spausdinamas, kai Spring konteineryje yra daugiau
    // nei vienas bean'as su tuo pačiu tipu ir nėra nurodyta, kuris iš jų naudoti.
    @Qualifier("SkaiciusZenklasDAO")
    private SkaiciusZenklasDAO skaiciusZenklasDAO;

    @Override
    public void insert(SkaiciusZenklas skaicius) {
        skaiciusZenklasDAO.insertEntity(skaicius);
    }

    @Override
    public SkaiciusZenklas getById(int id) {
        return skaiciusZenklasDAO.findEntityById(id);
    }

    @Override
    public List<SkaiciusZenklas> getAll() {
        return skaiciusZenklasDAO.findEntities();
    }

    @Override
    public void update(SkaiciusZenklas skaicius) {
        skaiciusZenklasDAO.updateEntity(skaicius);
    }

    @Override
    public void delete(int id) {
        skaiciusZenklasDAO.findEntityById(id);
    }
}

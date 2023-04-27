package com.mokslai.internetisskaiciuotuvas.model;
import java.util.List;
// DAO yra akronimas, kuris reiškia "Data Access Object".
// Tai yra projektavimo šablonas, naudojamas Java programavime, siekiant atskirti verslo loginę dalį nuo duomenų bazės valdymo dalies.
// DAO šablonas apibrėžia atskirą sluoksnį (klasę arba grupę klasių), kuri atsakinga už duomenų perdavimą tarp verslo logikos
// ir duomenų bazės. Šis sluoksnis suteikia abstrakciją nuo duomenų bazės ir suteikia lengvą prieigą prie duomenų bazės
// iš verslo logikos sluoksnio.

// DAO klasės paprastai turi kelis pagrindinius metodus,
// pvz., create, read, update ir delete, kurie leidžia atlikti atitinkamas duomenų bazės operacijas.
// Šios klasės gali turėti specifinius metodus, kad galėtų vykdyti sudėtingesnes užklausas,
// kaip, pvz., surasti visus klientus, kurie yra senesni nei 30 metų.

public interface SkaiciusZenklasDAO {

    void insertEntity (SkaiciusZenklas skaicius);

    SkaiciusZenklas findEntityById(int id);

    List<SkaiciusZenklas> findEntities();

    void updateEntity(SkaiciusZenklas skaicius);

    void removeEntityById(int id);
}

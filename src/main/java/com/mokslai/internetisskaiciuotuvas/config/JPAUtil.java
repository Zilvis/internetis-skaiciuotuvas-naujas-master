package com.mokslai.internetisskaiciuotuvas.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Sukuria gamykla kuri valdys Entity
public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static EntityManagerFactory entityManagerFactory;

    // entityManagerFactory per aplikacijos veikima bus tik viena ( sesiju bus daug )
    // entityManagerFactory veikia SINGLETON sablonu
    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory;
    }

    /**
     * Uzdaro gamykla
     */
    public static void shutdownEntityManager (){
        if (entityManagerFactory != null){
            entityManagerFactory.close();
        }
    }
}

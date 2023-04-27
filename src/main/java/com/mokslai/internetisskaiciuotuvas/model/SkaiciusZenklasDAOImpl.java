package com.mokslai.internetisskaiciuotuvas.model;

import com.mokslai.internetisskaiciuotuvas.InternetinisSkaiciuotuvasApplication;
import com.mokslai.internetisskaiciuotuvas.config.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class SkaiciusZenklasDAOImpl implements SkaiciusZenklasDAO{

    @Override
    public void insertEntity(SkaiciusZenklas skaicius) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        // EntityTransaction objektas leidžia pradėti transakciją, užbaigti ją arba atšaukti,
        // taip pat gali patikrinti, ar jau vyksta transakcija, ar ne.
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(skaicius); // Issaugo objekta duomenu bazeje ( Objektas = Irasas lenteleje )

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public SkaiciusZenklas findEntityById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // ORM modelyje ieskome ne duomenu bazes lenteleje bet Entyty
        List<SkaiciusZenklas> skaiciai = entityManager
                .createQuery("SELECT x FROM SkaiciusZenklas x WHERE x.id = :id")
                .setParameter("id", id)
                .getResultList(); // Negrazinamas ResultSet, o grazinamas List

        entityManager.getTransaction().commit();
        entityManager.close();

        return skaiciai.get(0);
    }

    @Override
    public List<SkaiciusZenklas> findEntities() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        List<SkaiciusZenklas> skaiciai = entityManager
                .createQuery("SELECT x FROM SkaiciusZenklas x")
                    .getResultList(); // Negrazinamas ResultSet, o grazinamas List

        entityManager.getTransaction().commit();
        entityManager.close();
        return skaiciai;
    }

    @Override
    public void updateEntity(SkaiciusZenklas skaicius) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // Kad atnaujinti irasa reikia pirmiausiai ji surasti duomenu bazeje
        SkaiciusZenklas skaiciusDB = entityManager.find(SkaiciusZenklas.class, skaicius.getId());
        skaiciusDB.setSk1(skaicius.getSk1());
        skaiciusDB.setSk2(skaicius.getSk2());
        skaiciusDB.setZenklas(skaicius.getZenklas());
        skaiciusDB.setRezultatas(skaicius.getRezultatas());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removeEntityById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        SkaiciusZenklas skaiciusDB = entityManager.find(SkaiciusZenklas.class, id);
        entityManager.remove(skaiciusDB);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

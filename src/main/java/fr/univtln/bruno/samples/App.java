package fr.univtln.bruno.samples;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("mypu");
        EntityManager em = emf.createEntityManager();

        Animal animal = Animal.builder().name("A").build();

        Chien chien = new Chien(12);

        EntityTransaction transac = em.getTransaction();

        transac.begin();
        em.persist(animal);
        em.persist(chien);
        transac.commit();
    }
}

package fr.univtln.bruno.samples;

import fr.univtln.bruno.samples.annotations.MyAnnotation;
import fr.univtln.bruno.samples.dao.AnimalDAO;
import fr.univtln.bruno.samples.entities.Animal;
import fr.univtln.bruno.samples.entities.Chien;

import javax.persistence.EntityTransaction;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * Hello world!
 */

@MyAnnotation(MyAnnotation.MesValeurs.UN)
public class App {

    static final public Properties properties = new Properties();

    static {
        properties.setProperty("pu", "mypu");
    }

    @MyAnnotation(MyAnnotation.MesValeurs.DEUX)
    public static void main(String[] args) {
        Animal animal, animal2;
        Chien chien;
        List<Animal> animaux = Arrays.asList(
                animal = Animal.animalBuilder().name("BBB").build(),
                animal2 = Animal.animalBuilder().name("AAA").build(),
                chien = Chien.chienBuilder().name("Rex").build());

        MyAnnotation.MesValeurs valueOfClassAnimal = animal.getClass().getAnnotation(MyAnnotation.class).value();
        System.out.println(valueOfClassAnimal);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        for (Animal a:animaux) {
            Set<ConstraintViolation<Animal>> v = validator.validate(a);
            System.out.println(v);
        }

        try (AnimalDAO animalDAO = AnimalDAO.of()) {

            EntityTransaction transaction = animalDAO.getTransaction();


            transaction.begin();
            animalDAO.persist(animal);
            animalDAO.persist(animal2);
            animalDAO.persist(chien);

            System.out.println("Animal 1:" + animalDAO.find(2));
            System.out.println("Animal 2:" + animalDAO.find(3));
            System.out.println("Rex ?:" + animalDAO.findByName("Rex"));

            transaction.commit();

        }

    }
}

package fr.univtln.bruno.samples.entities;


import fr.univtln.bruno.samples.annotations.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Builder(builderMethodName = "animalBuilder")
@NoArgsConstructor
@AllArgsConstructor

@NamedQueries({
        @NamedQuery(name = "animal.findByName", query = "select animal from Animal animal where animal.name=:name"),
        @NamedQuery(name = "animal.findByNameLength", query = "select animal from Animal animal where LENGTH(animal.name)>3")})
@MyAnnotation(MyAnnotation.MesValeurs.DEUX)
public class Animal implements SimpleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;


    @NotNull
    @Size(min = 2, max = 10)
    private String name;
}

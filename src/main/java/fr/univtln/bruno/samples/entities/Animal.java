package fr.univtln.bruno.samples.entities;


import fr.univtln.bruno.samples.annotations.MyAnnotation;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Builder(builderMethodName = "animalBuilder")
@NoArgsConstructor
@AllArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
@NamedQueries({
        @NamedQuery(name = "animal.findByName", query = "select animal from Animal animal where animal.name=:name"),
        @NamedQuery(name = "animal.findByNameLengthGT", query = "select animal from Animal animal where LENGTH(animal.name)>:lenght")})
@MyAnnotation(MyAnnotation.MesValeurs.DEUX)
public class Animal implements SimpleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    long id;


    @NotNull
    @Size(min = 2, max = 10)
    String name;
}

package fr.univtln.bruno.samples.entities;

import lombok.*;
import lombok.extern.java.Log;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CHIEN")
@Data
@NoArgsConstructor
@Log
@ToString(callSuper = true, exclude = "random")
public class Chien extends Animal {
    @Transient
    private double random;

    @Builder(builderMethodName = "chienBuilder")
    public Chien(int id, String name) {
        super(id, name);
    }

    @PrePersist
    public void uneMethode() {
        log.info("PRE PERSIST");
    }
}

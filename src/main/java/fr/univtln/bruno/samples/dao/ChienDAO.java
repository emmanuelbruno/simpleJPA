package fr.univtln.bruno.samples.dao;

import fr.univtln.bruno.samples.entities.Chien;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "of")
public class ChienDAO extends AbstractDAO<Chien> {
}

package fr.efrei.pokemon.repositories;

import fr.efrei.pokemon.models.Arene;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreneRepository extends JpaRepository<Arene, Long> {
}

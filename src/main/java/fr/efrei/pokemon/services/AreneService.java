package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Arene;
import fr.efrei.pokemon.repositories.AreneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreneService {

    private final AreneRepository repository;

    @Autowired
    public AreneService(AreneRepository repository) {
        this.repository = repository;
    }

    public List<Arene> findAll() {
        return repository.findAll();
    }

    public Arene findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(Arene arene) {
        repository.save(arene);
    }

    public void update(Long id, Arene arene) {
        arene.setId(String.valueOf(id));
        repository.save(arene);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void partialUpdate(Long id, Arene areneBody) {
        Arene existingArene = findById(id);
        if (existingArene != null) {
            if (areneBody.getName() != null) {
                existingArene.setName(areneBody.getName());
            }
            if (areneBody.getBadge() != null) {
                existingArene.setBadge(areneBody.getBadge());
            }
            repository.save(existingArene);
        }
    }
}

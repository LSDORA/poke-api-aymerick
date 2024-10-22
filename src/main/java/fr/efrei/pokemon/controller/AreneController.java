package fr.efrei.pokemon.controller;
import fr.efrei.pokemon.models.Attaque;
import fr.efrei.pokemon.models.Pokemon;
import fr.efrei.pokemon.models.Trainer;
import fr.efrei.pokemon.services.TrainerService;
import fr.efrei.pokemon.models.Arene;
import fr.efrei.pokemon.services.AreneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arenes")
public class AreneController {

    private final AreneService service;
    private final TrainerService trainerService;


    @Autowired
    public AreneController(AreneService service, TrainerService trainerService) {
        this.service = service;
        this.trainerService = trainerService;
    }

    // GET all arenas
    @GetMapping
    public ResponseEntity<List<Arene>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    // GET arena by ID
    @GetMapping("/{id}")
    public ResponseEntity<Arene> findById(@PathVariable Long id) {
        Arene arene = service.findById(id);
        if (arene == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(arene, HttpStatus.OK);
    }

    // POST create arena
    @PostMapping
    public ResponseEntity<Arene> create(@RequestBody Arene arene) {
        service.save(arene);
        return new ResponseEntity<>(arene, HttpStatus.CREATED);
    }

    // PUT update arena
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Arene arene) {
        Arene existingArene = service.findById(id);
        if (existingArene == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(id, arene);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Arene arene = service.findById(id);
        if (arene == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdate(@PathVariable Long id, @RequestBody Arene areneBody) {
        Arene arene = service.findById(id);
        if (arene == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.partialUpdate(id, areneBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/{id}/defier")
    public ResponseEntity<String> defierArene(@PathVariable Long id, @RequestParam String trainerName) {
        Arene arene = service.findById(id);
        if (arene == null) {
            return new ResponseEntity<>("Arene non trouvée", HttpStatus.NOT_FOUND);
        }

        Trainer trainer = trainerService.findByName(trainerName);
        if (trainer == null) {
            return new ResponseEntity<>("Trainer non trouvé", HttpStatus.NOT_FOUND);
        }
        String result = lancerDefi(arene, trainer);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private String lancerDefi(Arene arene, Trainer trainer) {
        return "Le trainer " + trainer.getName() + " a défié l'arène " + arene.getName();
    }

    @PostMapping("/{id}/combat")
    public ResponseEntity<String> lancerCombat(@PathVariable Long id, @RequestParam String trainerName) {
        Arene arene = service.findById(id);
        if (arene == null) {
            return new ResponseEntity<>("Arene non trouvée", HttpStatus.NOT_FOUND);
        }

        Trainer trainer = trainerService.findByName(trainerName);
        if (trainer == null) {
            return new ResponseEntity<>("Trainer non trouvé", HttpStatus.NOT_FOUND);
        }

        Pokemon championPokemon = arene.getChampion().getTeam().get(0);
        Pokemon trainerPokemon = trainer.getTeam().get(0);
        String combatResult = executerAttaque(championPokemon, trainerPokemon);
        return new ResponseEntity<>(combatResult, HttpStatus.OK);
    }

    private String executerAttaque(Pokemon attacker, Pokemon defender) {
        Attaque firstAttack = attacker.getAttacks().get(0);
        int damage = firstAttack.getPower();
        defender.setHealthPoints(defender.getHealthPoints() - damage);
        if (defender.getHealthPoints() <= 0) {
            return defender.getName() + " a été vaincu par " + attacker.getName() + "!";
        }
        return defender.getName() + " a " + defender.getHealthPoints() + " points de vie restants après l'attaque de " + attacker.getName();
    }


}

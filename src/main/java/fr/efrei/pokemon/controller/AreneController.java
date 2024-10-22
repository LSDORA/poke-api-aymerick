package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Arene;
import fr.efrei.pokemon.services.AreneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arenes")
public class AreneController {

    private final AreneService service;

    @Autowired
    public AreneController(AreneService service) {
        this.service = service;
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

    // DELETE arena
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Arene arene = service.findById(id);
        if (arene == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // PATCH update arena (for partial updates)
    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdate(@PathVariable Long id, @RequestBody Arene areneBody) {
        Arene arene = service.findById(id);
        if (arene == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.partialUpdate(id, areneBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

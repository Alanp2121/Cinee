package mx.edu.utez.cine.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mx.edu.utez.cine.model.Cine;
import mx.edu.utez.cine.service.CineService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cines")
public class CineController {

    private final CineService service;

    public CineController(CineService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Cine>> fidnAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cine> finById(@PathVariable Long id) {
        Optional<Cine> cine = service.findById(id);
        if(cine.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cine.get());
    }

    @PostMapping
    public ResponseEntity<Cine> savde(@RequestBody Cine cine){
        //TODO: process POST request
        Cine newCine = service.save(cine);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cine> update(@PathVariable Long id, @RequestBody Cine cineUpdated){
        //TODO: process PUT request
        Optional<Cine> cine = service.update(id, cineUpdated);
        if(cine.isPresent()){
            return ResponseEntity.ok(cine.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cine> delete(@PathVariable Long id){
        boolean delete = service.delete(id);
        if(!delete){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

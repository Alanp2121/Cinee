package mx.edu.utez.cine.service;

import java.util.List;
import java.util.Optional;

import mx.edu.utez.cine.model.Cine;
import mx.edu.utez.cine.repository.CineRepository;
import org.springframework.stereotype.Service;

@Service
public class CineService {

    private final CineRepository repo;

    public CineService(CineRepository repo){
        this.repo = repo;
    }

    public List<Cine> findAll(){
        return repo.findAll();
    }

    public Optional<Cine> findById(Long id){
        return repo.findById(id);
    }

    public Cine save(Cine cine){
        return repo.save(cine);
    }

    public Optional<Cine> update(long id, Cine newCine){
        Optional<Cine> optional = repo.findById(id);

        if (optional.isPresent()) {
            Cine cineBd = optional.get();
            cineBd.setPelicula(newCine.getPelicula());
            cineBd.setPrecioEntrada(newCine.getPrecioEntrada());
            cineBd.setCapacidadSala(newCine.getCapacidadSala());
            return Optional.of(repo.save(cineBd));
        }

        return Optional.empty();
    }

    public boolean delete(long id){
        if(!repo.existsById(id)){
            return false;
        }
        repo.deleteById(id);
        return true;
    }
}

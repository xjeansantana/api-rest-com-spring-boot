package com.example.bitmax.domain;

import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReleaseService {

    @Autowired
    private ReleaseRepository rep;

    public Iterable<Release> getRelease() {
        return rep.findAll();
    }

    public Optional<Release> getReleaseById(Long id) {
        return rep.findById(id);
    }

    public Iterable<Release> getReleaseByTipo(String tipo) {
        return rep.findByTipo(tipo);
    }

    public List<Release> getReleaseFake() {
        List<Release> releases = new ArrayList<>();
        releases.add(new Release(1L, "Versão 1.00"));
        releases.add(new Release(2L, "Versão 2.00"));
        releases.add(new Release(3L, "Versão 3.00"));

        return releases;
    }


    public Release insert(Release release) {
        return rep.save(release);
    }

    public Release update(Release release, Long id) {
        Assert.notNull(id, "Não foi possível atualizar o registro");

        //buscar a release no banco de dados
        Optional<Release> optional = getReleaseById(id);
        if (optional.isPresent()) {
            Release db = optional.get();
            //Copiar as propriedades
            db.setNome(release.getNome());
            db.setTipo(release.getTipo());
            System.out.println("Release id " + db.getId());

            //Atualiza o carro
            rep.save(db);
            return db;
        } else {
            throw new RuntimeException("Não foi possível atualizar o registro");
        }

    }

    public void delete(Long id) {
        Optional<Release> release = getReleaseById(id);
        if (release.isPresent()){
            rep.deleteById(id);
        } else {
            throw new RuntimeException("Não existe registros no banco de dados");
        }

    }
}

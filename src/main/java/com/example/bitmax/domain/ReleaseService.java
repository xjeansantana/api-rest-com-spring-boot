package com.example.bitmax.domain;

import com.example.bitmax.domain.dto.ReleaseDTO;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReleaseService {

    @Autowired
    private ReleaseRepository rep;

    public List<ReleaseDTO> getRelease() {
        List<Release> releases = rep.findAll();

        return rep.findAll().stream().map(ReleaseDTO::new).collect(Collectors.toList());

//        List<ReleaseDTO> list = new ArrayList<>();
//        for (Release r : releases){
//            list.add(new ReleaseDTO(r));
//
//        } return list;
    }

    public Optional<Release> getReleaseById(Long id) {
        return rep.findById(id);
    }

    public List<ReleaseDTO> getReleaseByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(ReleaseDTO::new).collect(Collectors.toList());
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
        if (release.isPresent()) {
            rep.deleteById(id);
        } else {
            throw new RuntimeException("Não existe registros no banco de dados");
        }

    }
}

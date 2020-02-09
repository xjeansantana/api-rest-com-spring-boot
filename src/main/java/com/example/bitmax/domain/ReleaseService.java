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

        return rep.findAll().stream().map(ReleaseDTO::create).collect(Collectors.toList());

    }

    public Optional<ReleaseDTO> getReleaseById(Long id) {
        return rep.findById(id).map(ReleaseDTO::create);
    }

    public List<ReleaseDTO> getReleaseByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(ReleaseDTO::create).collect(Collectors.toList());
    }


    public ReleaseDTO insert(Release release) {

        Assert.isNull(release.getId(), "Não foi possível inserir o registro");

        return ReleaseDTO.create(rep.save(release));
    }

    public ReleaseDTO update(Release release, Long id) {
        Assert.notNull(id, "Não foi possível atualizar o registro");

        //buscar a release no banco de dados
        Optional<Release> optional = rep.findById(id);
        if (optional.isPresent()) {
            Release db = optional.get();
            //Copiar as propriedades
            db.setNome(release.getNome());
            db.setTipo(release.getTipo());
            System.out.println("Release id " + db.getId());

            //Atualiza o carro
            rep.save(db);

            return ReleaseDTO.create(db);
        } else {
            return null;
//            throw new RuntimeException("Não foi possível atualizar o registro");
        }

    }

    public boolean delete(Long id) {

        if (getReleaseById(id).isPresent()) {
            rep.deleteById(id);
            return true;
        }
        return false;

    }
}

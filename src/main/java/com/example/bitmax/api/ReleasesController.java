package com.example.bitmax.api;

import com.example.bitmax.domain.Release;
import com.example.bitmax.domain.ReleaseService;
import com.example.bitmax.domain.dto.ReleaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/releases")
public class ReleasesController {
    @Autowired
    private ReleaseService service;

    @GetMapping
    public ResponseEntity<List<ReleaseDTO>> get() {
        return ResponseEntity.ok(service.getRelease());
        // return new ResponseEntity<>(service.getRelease(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Release> release = service.getReleaseById(id);

        return release
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

//        if (release.isPresent()){
//            return ResponseEntity.ok(release.get());
//        }else {
//            return ResponseEntity.notFound().build();
//        }

    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity getReleaseByTipo(@PathVariable("tipo") String tipo) {
        List<ReleaseDTO> releases= service.getReleaseByTipo(tipo);
        return releases.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(releases);
    }

    @PostMapping
    public String post(@RequestBody Release release) {
        Release s = service.insert(release);
        return "Release inserida com sucesso: " + s.getId();
    }

    @PutMapping("/{id}")
    public String put(@PathVariable("id") Long id, @RequestBody Release release) {
        Release s = service.update(release, id);
        return "Release Atualizada com sucesso: " + s.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "Registro deletado com sucesso";
    }

}

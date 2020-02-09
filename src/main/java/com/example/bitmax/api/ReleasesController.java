package com.example.bitmax.api;

import com.example.bitmax.domain.Release;
import com.example.bitmax.domain.ReleaseService;
import com.example.bitmax.domain.dto.ReleaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        Optional<ReleaseDTO> release = service.getReleaseById(id);

        return release
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity getReleaseByTipo(@PathVariable("tipo") String tipo) {
        List<ReleaseDTO> releases = service.getReleaseByTipo(tipo);
        return releases.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(releases);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Release release) {
        try {
            ReleaseDTO s = service.insert(release);

            URI location = getUri(s.getId());

            return ResponseEntity.created(location).build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Release release) {
        release.setId(id);

        ReleaseDTO r = service.update(release, id);
        return r != null ?
                ResponseEntity.ok(r) :
                ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "Registro deletado com sucesso";
    }

}

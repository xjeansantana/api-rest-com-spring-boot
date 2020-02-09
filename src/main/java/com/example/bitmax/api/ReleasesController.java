package com.example.bitmax.api;

import com.example.bitmax.domain.Release;
import com.example.bitmax.domain.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/releases")
public class ReleasesController {
    @Autowired
    private ReleaseService service;

    @GetMapping
    public Iterable<Release> get() {
        return service.getRelease();
    }

    @GetMapping("/{id}")
    public Optional<Release> get(@PathVariable("id") Long id) {
        return service.getReleaseById(id);
    }

    @GetMapping("/tipo/{tipo}")
    public Iterable<Release> getReleaseByTipo(@PathVariable("tipo") String tipo) {
        return service.getReleaseByTipo(tipo);
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

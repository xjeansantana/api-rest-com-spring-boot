package com.example.bitmax.api;

import com.example.bitmax.domain.Release;
import com.example.bitmax.domain.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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


}

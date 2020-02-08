package com.example.bitmax.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReleaseService {

    @Autowired
    private ReleaseRepository rep;

    public Iterable<Release> getRelease() {
        return rep.findAll();

    }

    public List<Release> getReleaseFake() {
        List<Release> releases = new ArrayList<>();
        releases.add(new Release(1L, "Versão 1.00"));
        releases.add(new Release(2L, "Versão 2.00"));
        releases.add(new Release(3L, "Versão 3.00"));

        return releases;
    }
}

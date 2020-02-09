package com.example.bitmax.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReleaseRepository extends CrudRepository <Release, Long>{


    Iterable<Release> findByTipo(String tipo);
}

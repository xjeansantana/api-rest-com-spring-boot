package com.example.bitmax.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReleaseRepository extends CrudRepository <Release, Long>{


    List<Release> findByTipo(String tipo);
}

package com.example.bitmax.domain.dto;

import com.example.bitmax.domain.Release;
import lombok.Data;

@Data
public class ReleaseDTO {
    private Long id;
    private String nome;
    private String tipo;

    public ReleaseDTO(Release r) {
        this.id = r.getId();
        this.nome = r.getNome();
        this.tipo = r.getTipo();
    }
}

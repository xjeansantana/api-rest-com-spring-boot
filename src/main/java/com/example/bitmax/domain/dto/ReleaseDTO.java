package com.example.bitmax.domain.dto;

import com.example.bitmax.domain.Release;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ReleaseDTO {
    private Long id;
    private String nome;
    private String tipo;

    public static ReleaseDTO create(Release r) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(r, ReleaseDTO.class);
    }
}

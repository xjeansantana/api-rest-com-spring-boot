package com.example.bitmax;


import com.example.bitmax.domain.Release;
import com.example.bitmax.domain.ReleaseService;
import com.example.bitmax.domain.dto.ReleaseDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;



import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
class BitmaxApplicationTests {

    @Autowired
    private ReleaseService service;

    @Test
    public void teste1() {
        Release release = new Release();
        release.setNome("5.00");
        release.setTipo("Empresarial");

        ReleaseDTO r = service.insert(release);

        assertNotNull(r);

        Long id = r.getId();
        assertNotNull(id);

        //Buscar objeto
        Optional<ReleaseDTO> op = service.getReleaseById(id);
        assertTrue(op.isPresent());

        r = op.get();
        assertEquals ("5.00", r.getNome());
        assertEquals("Empresarial", r.getTipo());

        //deletar o objeto

        service.delete(id);

        // Verificar se deletou
        assertFalse((service.getReleaseById(id).isPresent()));




    }

    private void assertTrue(boolean present) {
    }

    @Test
    public void teste2() {

    }

}

package com.example.bitmax;

import com.example.bitmax.domain.Release;
import com.example.bitmax.domain.ReleaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BitmaxApplicationTests {

    @Autowired
    private ReleaseService service;

    @Test
    public void teste1() {
        Release release = new Release();
        release.setNome("5.00");
        release.setTipo("Empresarial");

        service.insert(release);

    }

    @Test
    public void teste2() {

    }

}

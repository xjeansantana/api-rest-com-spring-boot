package com.example.bitmax.api;

import com.example.bitmax.domain.Release;
import com.example.bitmax.domain.ReleaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/releases")
public class ReleasesController {
    private ReleaseService service = new ReleaseService();

    @GetMapping
    public List<Release> get() {
        return service.getRelease();
    }


}

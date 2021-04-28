package sp.sample.simpleCurd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static sp.sample.simpleCurd.utils.Constants.VERSION;

@RestController
@RequestMapping(VERSION)
@Slf4j
public class HealthController {

    @GetMapping("/application/health")
    private ResponseEntity getHealth(){
        log.info("Inside health method");
        return ResponseEntity.ok("Health check successful");
    }
}

package com.frimil.frimilcalculator.dianteiro;

import com.frimil.frimilcalculator.lucro.Lucro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dianteiros")
public class DianteiroResource {

    private final DianteiroService dianteiroService;

    public DianteiroResource(DianteiroService dianteiroService){
        this.dianteiroService = dianteiroService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Lucro> calcularLucroDianteiro(@RequestBody Dianteiro dianteiroDTO){
        return ResponseEntity.ok().body(dianteiroService.calcularLucro(dianteiroDTO));
    }
}

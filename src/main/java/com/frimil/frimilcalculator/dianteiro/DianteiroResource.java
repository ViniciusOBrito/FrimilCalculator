package com.frimil.frimilcalculator.dianteiro;

import com.frimil.frimilcalculator.lucro.Lucro;
import com.frimil.frimilcalculator.peca.PecaDTO;
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
    public ResponseEntity<PecaDTO> calcularLucroDianteiro(@RequestBody PecaDTO pecaDTO){
        return ResponseEntity.ok().body(dianteiroService.salvarDianteiro(pecaDTO));
    }
}

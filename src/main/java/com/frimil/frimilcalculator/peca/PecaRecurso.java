package com.frimil.frimilcalculator.peca;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/peca")
public class PecaRecurso {

    private final PecaServico pecaServico;

    @PostMapping()
    public ResponseEntity<PecaDTO> calcularLucroDianteiro(@RequestBody PecaDTO pecaDTO){
        return ResponseEntity.ok().body(pecaServico.cadastrarPecaEProdutos(pecaDTO));
    }
}

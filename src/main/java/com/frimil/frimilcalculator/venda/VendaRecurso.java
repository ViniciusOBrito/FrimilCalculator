package com.frimil.frimilcalculator.venda;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venda")
public class VendaRecurso {

    private final VendaServico vendaServico;

    public VendaRecurso(VendaServico vendaServico) {
        this.vendaServico = vendaServico;
    }

    @PostMapping
    public ResponseEntity<VendaDTO> salvarVenda(VendaDTO vendaDTO){
        return ResponseEntity.ok().body(vendaServico.salvarVenda(vendaDTO));
    }
}

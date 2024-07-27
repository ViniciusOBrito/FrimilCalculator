package com.frimil.frimilcalculator.peca;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pecas")
public class PecaRecurso implements PecaOperations{

    private final PecaServico pecaServico;

    @PostMapping()
    public ResponseEntity<PecaDTO> cadastrar(@RequestBody PecaDTO pecaDTO){
            return ResponseEntity.ok().body(pecaServico.cadastrarPecaEProdutos(pecaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PecaDTO> buscaPeca(@PathVariable Long id){
            return ResponseEntity.ok().body(pecaServico.buscarPeca(id));
    }

    @GetMapping("/listaPorId/{idPeca}")
    public ResponseEntity<List<PecaDTO>> listarPecas(@PathVariable Long idPeca){
        return ResponseEntity.ok().body(pecaServico.listarPecas(idPeca));
    }
}

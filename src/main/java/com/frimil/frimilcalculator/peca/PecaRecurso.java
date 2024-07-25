package com.frimil.frimilcalculator.peca;

import com.frimil.frimilcalculator.exception.EntidadeNaoEncontradaException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/peca")
public class PecaRecurso {

    private final PecaServico pecaServico;

    @PostMapping()
    public ResponseEntity<PecaDTO> calcularLucroDianteiro(@RequestBody PecaDTO pecaDTO){
        return ResponseEntity.ok().body(pecaServico.cadastrarPecaEProdutos(pecaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PecaDTO> buscaPeca(@PathVariable Long id){
        try{
            return ResponseEntity.ok().body(pecaServico.buscarPeca(id));
        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listaPorId/{idPeca}")
    public ResponseEntity<List<PecaDTO>> listarPecas(@PathVariable Long idPeca){
        return ResponseEntity.ok().body(pecaServico.listarPecas(idPeca));
    }
}

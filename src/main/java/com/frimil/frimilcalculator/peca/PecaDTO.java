package com.frimil.frimilcalculator.peca;

import com.frimil.frimilcalculator.produto.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PecaDTO {

    private Long id;
    private Long idPeca;
    private BigDecimal peso;
    private BigDecimal valorDeCompra;
    private List<Produto> listaDeProdutos;



    public PecaDTO(Peca peca) {
        this.id = peca.getId();
        this.idPeca = peca.getIdPeca();
        this.peso = peca.getPeso();
        this.valorDeCompra = peca.getValorDeCompra();
        this.listaDeProdutos = peca.getListaDeProdutos();
    }
}

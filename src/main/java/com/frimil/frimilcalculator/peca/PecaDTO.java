package com.frimil.frimilcalculator.peca;

import com.frimil.frimilcalculator.produto.Produto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PecaDTO {

    private Long id;
    private Long idPeca;
    private BigDecimal peso;
    private BigDecimal valorDeCompra;
    private List<Produto> listaDeProdutos;

}

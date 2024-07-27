package com.frimil.frimilcalculator.venda;

import com.frimil.frimilcalculator.peca.Peca;
import com.frimil.frimilcalculator.produto.Produto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class VendaDTO {

    private Long id;
    @NotNull(message = "Id do produto não pode ser nulo.")
    private Long idProduto;
    @NotNull(message = "Id da peça não pode ser nulo.")
    private Long idPeca;
    @NotNull(message = "Valor de venda não pode ser nulo.")
    private BigDecimal valorDeVenda;
    private Date dataAtualizacao;

}

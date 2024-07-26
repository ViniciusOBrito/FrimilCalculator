package com.frimil.frimilcalculator.peca;

import com.frimil.frimilcalculator.produto.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PecaDTO {

    private Long id;
    @NotNull(message = "ID da peça não pode ser nulo.")
    private Long idPeca;
    @NotNull(message = "O peso da peça não pode ser nulo.")
    private BigDecimal peso;
    @NotNull(message = "O valor da compra não pode ser nulo.")
    private BigDecimal valorDeCompra;

    @Size(min = 1, message = "A lista de produtos não pode estar vazia.")
    private List<Produto> listaDeProdutos;


    public PecaDTO(Peca peca) {
        this.id = peca.getId();
        this.idPeca = peca.getIdPeca();
        this.peso = peca.getPeso();
        this.valorDeCompra = peca.getValorDeCompra();
        this.listaDeProdutos = peca.getListaDeProdutos();
    }
}

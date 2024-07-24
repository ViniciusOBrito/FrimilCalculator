package com.frimil.frimilcalculator.venda;

import com.frimil.frimilcalculator.peca.Peca;
import com.frimil.frimilcalculator.produto.Produto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idProduto;
    private Long idPeca;
    private BigDecimal valorDeVenda;
    private Date dataAtualizacao;

}

package com.frimil.frimilcalculator.peca;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.frimil.frimilcalculator.produto.Produto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idPeca;
    private BigDecimal peso;
    private BigDecimal valorDeCompra;
    @OneToMany(mappedBy = "peca", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Produto> listaDeProdutos = new ArrayList<>();

    public void addProduto(Produto produto) {
        produto.setPeca(this);
        this.listaDeProdutos.add(produto);
    }
}

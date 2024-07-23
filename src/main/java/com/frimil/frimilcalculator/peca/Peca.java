package com.frimil.frimilcalculator.peca;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.frimil.frimilcalculator.produto.Produto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Long idPeca) {
        this.idPeca = idPeca;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getValorDeCompra() {
        return valorDeCompra;
    }

    public void setValorDeCompra(BigDecimal valorDeCompra) {
        this.valorDeCompra = valorDeCompra;
    }

    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(List<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    public void addProduto(Produto produto) {
        produto.setPeca(this);
        this.listaDeProdutos.add(produto);
    }
}

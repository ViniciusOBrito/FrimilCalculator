package com.frimil.frimilcalculator.produto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.frimil.frimilcalculator.peca.Peca;
import com.frimil.frimilcalculator.venda.Venda;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table()
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "peca_id")
    @JsonBackReference
    private Peca peca;
    @OneToOne
    private Venda venda;
    private BigDecimal peso;
    private BigDecimal quantidade;
    private BigDecimal percentual;
    private BigDecimal custo;
    private BigDecimal total;

    public Produto(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPercentual() {
        return percentual;
    }

    public void setPercentual(BigDecimal percentual) {
        this.percentual = percentual;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

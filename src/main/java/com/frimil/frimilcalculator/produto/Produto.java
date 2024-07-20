package com.frimil.frimilcalculator.produto;

import java.math.BigDecimal;

public class Produto {

    BigDecimal quantidade;

    BigDecimal percentual;

    BigDecimal custo;

    BigDecimal venda;

    BigDecimal total;

    public Produto(){}

    public Produto(BigDecimal quantidade, BigDecimal percentual, BigDecimal custo, BigDecimal venda, BigDecimal total) {
        this.quantidade = quantidade;
        this.percentual = percentual;
        this.custo = custo;
        this.venda = venda;
        this.total = total;
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

    public BigDecimal getVenda() {
        return venda;
    }

    public void setVenda(BigDecimal venda) {
        this.venda = venda;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

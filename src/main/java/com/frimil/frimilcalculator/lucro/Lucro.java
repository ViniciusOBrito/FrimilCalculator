package com.frimil.frimilcalculator.lucro;

import java.math.BigDecimal;

public class Lucro {

    private BigDecimal custo;
    private BigDecimal venda;
    private BigDecimal lucroBruto;

    public Lucro(){
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

    public BigDecimal getLucroBruto() {
        return lucroBruto;
    }

    public void setLucroBruto(BigDecimal lucroBruto) {
        this.lucroBruto = lucroBruto;
    }

}

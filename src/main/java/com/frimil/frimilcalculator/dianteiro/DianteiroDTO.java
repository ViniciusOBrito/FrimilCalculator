package com.frimil.frimilcalculator.dianteiro;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;

public class DianteiroDTO {

    @NonNull
    private BigDecimal dianteiroPeso;

    @NonNull
    private BigDecimal dianteiroPreco;

    private BigDecimal pescocoPeso;

    private BigDecimal acemPeso;

    private BigDecimal cupimPeso;

    @NonNull
    public BigDecimal getDianteiroPeso() {
        return dianteiroPeso;
    }

    public void setDianteiroPeso(@NonNull BigDecimal dianteiroPeso) {
        this.dianteiroPeso = dianteiroPeso;
    }

    @NonNull
    public BigDecimal getDianteiroPreco() {
        return dianteiroPreco;
    }

    public void setDianteiroPreco(@NonNull BigDecimal dianteiroPreco) {
        this.dianteiroPreco = dianteiroPreco;
    }

    public BigDecimal getPescocoPeso() {
        return pescocoPeso;
    }

    public void setPescocoPeso(BigDecimal pescocoPeso) {
        this.pescocoPeso = pescocoPeso;
    }

    public BigDecimal getAcemPeso() {
        return acemPeso;
    }

    public void setAcemPeso(BigDecimal acemPeso) {
        this.acemPeso = acemPeso;
    }

    public BigDecimal getCupimPeso() {
        return cupimPeso;
    }

    public void setCupimPeso(BigDecimal cupimPeso) {
        this.cupimPeso = cupimPeso;
    }
}

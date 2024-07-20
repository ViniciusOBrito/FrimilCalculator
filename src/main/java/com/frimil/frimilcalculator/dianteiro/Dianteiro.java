package com.frimil.frimilcalculator.dianteiro;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;

public class Dianteiro {

    @NonNull
    private BigDecimal dianteiroPeso;
    @NonNull
    private BigDecimal dianteiroPreco;
    private BigDecimal agulhaSemOssoPeso;
    private BigDecimal bistecaDaPaPeso;
    private BigDecimal cupimPeso;
    private BigDecimal ossoBucoPeso;
    private BigDecimal paComOssoPeso;
    private BigDecimal paSemOssoPeso;

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

    public BigDecimal getAgulhaSemOssoPeso() {
        return agulhaSemOssoPeso;
    }

    public void setAgulhaSemOssoPeso(BigDecimal agulhaSemOssoPeso) {
        this.agulhaSemOssoPeso = agulhaSemOssoPeso;
    }

    public BigDecimal getBistecaDaPaPeso() {
        return bistecaDaPaPeso;
    }

    public void setBistecaDaPaPeso(BigDecimal bistecaDaPaPeso) {
        this.bistecaDaPaPeso = bistecaDaPaPeso;
    }

    public BigDecimal getCupimPeso() {
        return cupimPeso;
    }

    public void setCupimPeso(BigDecimal cupimPeso) {
        this.cupimPeso = cupimPeso;
    }

    public BigDecimal getOssoBucoPeso() {
        return ossoBucoPeso;
    }

    public void setOssoBucoPeso(BigDecimal ossoBucoPeso) {
        this.ossoBucoPeso = ossoBucoPeso;
    }

    public BigDecimal getPaComOssoPeso() {
        return paComOssoPeso;
    }

    public void setPaComOssoPeso(BigDecimal paComOssoPeso) {
        this.paComOssoPeso = paComOssoPeso;
    }

    public BigDecimal getPaSemOssoPeso() {
        return paSemOssoPeso;
    }

    public void setPaSemOssoPeso(BigDecimal paSemOssoPeso) {
        this.paSemOssoPeso = paSemOssoPeso;
    }
}

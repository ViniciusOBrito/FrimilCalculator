package com.frimil.frimilcalculator.dianteiro;

import java.math.BigDecimal;

public class ValorVendaDianteiro {

    private BigDecimal valorAgulhaSemOsso = BigDecimal.valueOf(24.90);

    private BigDecimal valoBistecaDaPa = BigDecimal.valueOf(22.90);

    private BigDecimal valoCupim = BigDecimal.valueOf(34.90);

    private BigDecimal valorOssoBuco = BigDecimal.valueOf(17.90);

    private BigDecimal valorPaComOsso = BigDecimal.valueOf(19.90);

    private BigDecimal valorPaSemOsso = BigDecimal.valueOf(24.90);

    public BigDecimal getValorAgulhaSemOsso() {
        return valorAgulhaSemOsso;
    }

    public void setValorAgulhaSemOsso(BigDecimal valorAgulhaSemOsso) {
        this.valorAgulhaSemOsso = valorAgulhaSemOsso;
    }

    public BigDecimal getValoBistecaDaPa() {
        return valoBistecaDaPa;
    }

    public void setValoBistecaDaPa(BigDecimal valoBistecaDaPa) {
        this.valoBistecaDaPa = valoBistecaDaPa;
    }

    public BigDecimal getValoCupim() {
        return valoCupim;
    }

    public void setValoCupim(BigDecimal valoCupim) {
        this.valoCupim = valoCupim;
    }

    public BigDecimal getValorOssoBuco() {
        return valorOssoBuco;
    }

    public void setValorOssoBuco(BigDecimal valorOssoBuco) {
        this.valorOssoBuco = valorOssoBuco;
    }

    public BigDecimal getValorPaComOsso() {
        return valorPaComOsso;
    }

    public void setValorPaComOsso(BigDecimal valorPaComOsso) {
        this.valorPaComOsso = valorPaComOsso;
    }

    public BigDecimal getValorPaSemOsso() {
        return valorPaSemOsso;
    }

    public void setValorPaSemOsso(BigDecimal valorPaSemOsso) {
        this.valorPaSemOsso = valorPaSemOsso;
    }
}

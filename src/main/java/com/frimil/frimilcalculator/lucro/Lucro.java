package com.frimil.frimilcalculator.lucro;

import com.frimil.frimilcalculator.dianteiro.*;

import java.math.BigDecimal;

public class Lucro {

    private BigDecimal custo;

    private BigDecimal venda;
    private BigDecimal lucroBruto;

    private AgulhaSemOsso agulhaSemOsso;

    private BistecaDaPa bistecaDaPa;

    private Cupim cupim;

    private OssoBuco ossoBuco;

    private PaComOsso paComOsso;

    private PaSemOsso paSemOsso;

    public BigDecimal getLucroBruto() {
        return lucroBruto;
    }

    public void setLucroBruto(BigDecimal lucroBruto) {
        this.lucroBruto = lucroBruto;
    }
}

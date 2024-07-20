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
    public Lucro(){
    }

    public Lucro(BigDecimal custo, BigDecimal venda, BigDecimal lucroBruto, AgulhaSemOsso agulhaSemOsso, BistecaDaPa bistecaDaPa, Cupim cupim, OssoBuco ossoBuco, PaComOsso paComOsso, PaSemOsso paSemOsso) {
        this.custo = custo;
        this.venda = venda;
        this.lucroBruto = lucroBruto;
        this.agulhaSemOsso = agulhaSemOsso;
        this.bistecaDaPa = bistecaDaPa;
        this.cupim = cupim;
        this.ossoBuco = ossoBuco;
        this.paComOsso = paComOsso;
        this.paSemOsso = paSemOsso;
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

    public AgulhaSemOsso getAgulhaSemOsso() {
        return agulhaSemOsso;
    }

    public void setAgulhaSemOsso(AgulhaSemOsso agulhaSemOsso) {
        this.agulhaSemOsso = agulhaSemOsso;
    }

    public BistecaDaPa getBistecaDaPa() {
        return bistecaDaPa;
    }

    public void setBistecaDaPa(BistecaDaPa bistecaDaPa) {
        this.bistecaDaPa = bistecaDaPa;
    }

    public Cupim getCupim() {
        return cupim;
    }

    public void setCupim(Cupim cupim) {
        this.cupim = cupim;
    }

    public OssoBuco getOssoBuco() {
        return ossoBuco;
    }

    public void setOssoBuco(OssoBuco ossoBuco) {
        this.ossoBuco = ossoBuco;
    }

    public PaComOsso getPaComOsso() {
        return paComOsso;
    }

    public void setPaComOsso(PaComOsso paComOsso) {
        this.paComOsso = paComOsso;
    }

    public PaSemOsso getPaSemOsso() {
        return paSemOsso;
    }

    public void setPaSemOsso(PaSemOsso paSemOsso) {
        this.paSemOsso = paSemOsso;
    }
}

package com.frimil.frimilcalculator.dianteiro;

import com.frimil.frimilcalculator.lucro.Lucro;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class DianteiroService {

    public Lucro calcularLucro(Dianteiro dianteiroDTO){

        Lucro lucro = new Lucro();

        ValorVendaDianteiro valorVendaDianteiro = new ValorVendaDianteiro();

        BigDecimal precoTotalDianteiro = dianteiroDTO.getDianteiroPeso().multiply(dianteiroDTO.getDianteiroPreco());

        BigDecimal pescocoLucro = dianteiroDTO.getPescocoPeso().multiply(new BigDecimal(15.65));

        BigDecimal acemLucro = dianteiroDTO.getAcemPeso().multiply(new BigDecimal(10));

        BigDecimal cupimLucro = dianteiroDTO.getCupimPeso().multiply(new BigDecimal(20.31));

        BigDecimal totalSoma = pescocoLucro.add(acemLucro.add(cupimLucro));

        lucro.setLucroBruto(totalSoma.subtract(precoTotalDianteiro).setScale(2, RoundingMode.HALF_UP));

        return lucro;
    }


    public BigDecimal calculaTotal(BigDecimal venda, BigDecimal quantidade){
        return venda.multiply(quantidade);
    }

    public BigDecimal calculaCusto(BigDecimal pesoTotalProdutos, BigDecimal precoTotalDianteiro){
        return precoTotalDianteiro.divide(pesoTotalProdutos);
    }

    public BigDecimal calculaPercentual(BigDecimal pesoProduto, BigDecimal pesoTotalDianteiro){
        return pesoProduto.divide(pesoTotalDianteiro).multiply(BigDecimal.valueOf(100));
    }

}

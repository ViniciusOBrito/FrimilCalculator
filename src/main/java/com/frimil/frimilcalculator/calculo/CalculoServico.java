package com.frimil.frimilcalculator.calculo;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculoServico {

    public BigDecimal calculaVendaTotalProduto(BigDecimal valorVenda, BigDecimal quantidade){
        return valorVenda.multiply(quantidade);
    }

    public BigDecimal calculaCustoProduto(BigDecimal pesoTotalProdutos, BigDecimal precoTotalDianteiro){
        return precoTotalDianteiro.divide(pesoTotalProdutos, RoundingMode.HALF_UP);
    }

    public BigDecimal calculaPercentual(BigDecimal pesoProduto, BigDecimal pesoDianteiro){
        BigDecimal valorDividido = pesoProduto.divide(pesoDianteiro, 3, RoundingMode.HALF_UP);
        return valorDividido.multiply(BigDecimal.valueOf(100)).setScale(RoundingMode.HALF_UP.ordinal());
    }

    public BigDecimal calcularLucroTotal(BigDecimal custoTotal, BigDecimal vendaTotal){
        return vendaTotal.subtract(custoTotal);
    }

    public BigDecimal calculaCustoTotal(BigDecimal quantidadeTotal, BigDecimal custoTotal){
        return quantidadeTotal.multiply(custoTotal);
    }
}

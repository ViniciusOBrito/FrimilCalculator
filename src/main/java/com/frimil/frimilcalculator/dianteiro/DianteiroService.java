package com.frimil.frimilcalculator.dianteiro;

import com.frimil.frimilcalculator.lucro.Lucro;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Service
public class DianteiroService {

    public Lucro calcularLucro(Dianteiro dianteiroDTO){

        ValorVendaDianteiro valorVendaDianteiro = new ValorVendaDianteiro();

        BigDecimal precoTotalDianteiro = dianteiroDTO.getDianteiroPeso().multiply(dianteiroDTO.getDianteiroPreco());

        BigDecimal pesoTotalProdutos = somarTotalProdutos(dianteiroDTO);


        AgulhaSemOsso agulhaSemOsso  = new AgulhaSemOsso(
                dianteiroDTO.getAgulhaSemOssoPeso(),
                this.calculaPercentual(dianteiroDTO.getAgulhaSemOssoPeso(), dianteiroDTO.getDianteiroPeso()),
                this.calculaCustoProduto(pesoTotalProdutos, precoTotalDianteiro),
                valorVendaDianteiro.getValorAgulhaSemOsso(),
                this.calculaVendaProduto(valorVendaDianteiro.getValorAgulhaSemOsso(), dianteiroDTO.getAgulhaSemOssoPeso())
        );

        BistecaDaPa bistecaDaPa  = new BistecaDaPa(
                dianteiroDTO.getBistecaDaPaPeso(),
                this.calculaPercentual(dianteiroDTO.getBistecaDaPaPeso(), dianteiroDTO.getDianteiroPeso()),
                this.calculaCustoProduto(pesoTotalProdutos, precoTotalDianteiro),
                valorVendaDianteiro.getValoBistecaDaPa(),
                this.calculaVendaProduto(valorVendaDianteiro.getValoBistecaDaPa(), dianteiroDTO.getBistecaDaPaPeso())
        );

        Cupim cupim  = new Cupim(
                dianteiroDTO.getCupimPeso(),
                this.calculaPercentual(dianteiroDTO.getCupimPeso(), dianteiroDTO.getDianteiroPeso()),
                this.calculaCustoProduto(pesoTotalProdutos, precoTotalDianteiro),
                valorVendaDianteiro.getValoCupim(),
                this.calculaVendaProduto(valorVendaDianteiro.getValoCupim(), dianteiroDTO.getCupimPeso())
        );

        OssoBuco ossoBuco  = new OssoBuco(
                dianteiroDTO.getOssoBucoPeso(),
                this.calculaPercentual(dianteiroDTO.getOssoBucoPeso(), dianteiroDTO.getDianteiroPeso()),
                this.calculaCustoProduto(pesoTotalProdutos, precoTotalDianteiro),
                valorVendaDianteiro.getValorOssoBuco(),
                this.calculaVendaProduto(valorVendaDianteiro.getValorOssoBuco(), dianteiroDTO.getOssoBucoPeso())
        );

        PaComOsso paComOsso  = new PaComOsso(
                dianteiroDTO.getPaComOssoPeso(),
                this.calculaPercentual(dianteiroDTO.getPaComOssoPeso(), dianteiroDTO.getDianteiroPeso()),
                this.calculaCustoProduto(pesoTotalProdutos, precoTotalDianteiro),
                valorVendaDianteiro.getValorPaComOsso(),
                this.calculaVendaProduto(valorVendaDianteiro.getValorPaComOsso(), dianteiroDTO.getPaComOssoPeso())
        );

        PaSemOsso paSemOsso  = new PaSemOsso(
                dianteiroDTO.getPaSemOssoPeso(),
                this.calculaPercentual(dianteiroDTO.getPaSemOssoPeso(), dianteiroDTO.getDianteiroPeso()),
                this.calculaCustoProduto(pesoTotalProdutos, precoTotalDianteiro),
                valorVendaDianteiro.getValorPaSemOsso(),
                this.calculaVendaProduto(valorVendaDianteiro.getValorPaSemOsso(), dianteiroDTO.getPaSemOssoPeso())
        );

        BigDecimal custoTotal = this.calculaTotal(
                agulhaSemOsso.getCusto(),
                bistecaDaPa.getCusto(),
                cupim.getCusto(),
                ossoBuco.getCusto(),
                paComOsso.getCusto(),
                paSemOsso.getCusto()
        );

        BigDecimal quantidadeTotal = this.calculaTotal(
                dianteiroDTO.getAgulhaSemOssoPeso(),
                dianteiroDTO.getBistecaDaPaPeso(),
                dianteiroDTO.getCupimPeso(),
                dianteiroDTO.getOssoBucoPeso(),
                dianteiroDTO.getPaComOssoPeso(),
                dianteiroDTO.getPaSemOssoPeso()
        );

        BigDecimal vendaTotal = this.calculaTotal(
                agulhaSemOsso.getTotal(),
                bistecaDaPa.getTotal(),
                cupim.getTotal(),
                ossoBuco.getTotal(),
                paComOsso.getTotal(),
                paSemOsso.getTotal()
        );

        return new Lucro(
                this.calculaCustoTotal(quantidadeTotal, custoTotal),
                vendaTotal,
                this.calcularLucroTotal(custoTotal, vendaTotal),
                agulhaSemOsso,
                bistecaDaPa,
                cupim,
                ossoBuco,
                paComOsso,
                paSemOsso
        );
    }


    public BigDecimal calculaVendaProduto(BigDecimal valorVenda, BigDecimal quantidade){
        return valorVenda.multiply(quantidade);
    }

    public BigDecimal calculaCustoProduto(BigDecimal pesoTotalProdutos, BigDecimal precoTotalDianteiro){
        return precoTotalDianteiro.divide(pesoTotalProdutos, RoundingMode.HALF_UP);
    }

    public BigDecimal calculaPercentual(BigDecimal pesoProduto, BigDecimal pesoDianteiro){
         BigDecimal valorDividido = pesoProduto.divide(pesoDianteiro , RoundingMode.HALF_UP);
         return valorDividido.multiply(BigDecimal.valueOf(100));
    }

    public BigDecimal calcularLucroTotal(BigDecimal custoTotal, BigDecimal vendaTotal){
        return vendaTotal.subtract(custoTotal);
    }

    public BigDecimal calculaCustoTotal(BigDecimal quantidadeTotal, BigDecimal custoTotal){
        return quantidadeTotal.multiply(custoTotal);
    }

    public BigDecimal calculaTotal(BigDecimal valor1, BigDecimal valor2, BigDecimal valor3, BigDecimal valor4, BigDecimal valor5,BigDecimal valor6){
        BigDecimal soma = BigDecimal.ZERO;

        soma = soma.add(valor1);
        soma = soma.add(valor2);
        soma = soma.add(valor3);
        soma = soma.add(valor4);
        soma = soma.add(valor5);
        soma = soma.add(valor6);
        return soma;
    }

    public BigDecimal somarTotalProdutos(Dianteiro dianteiroDTO){
        BigDecimal soma = BigDecimal.ZERO;
        Field[] fields = dianteiroDTO.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.getType().equals(BigDecimal.class) && field.getAnnotation(NonNull.class) == null) {
                field.setAccessible(true);
                try {
                    BigDecimal value = (BigDecimal) field.get(dianteiroDTO);
                    if (Objects.nonNull(value)) {
                        soma = soma.add(value);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return soma;
    }

}

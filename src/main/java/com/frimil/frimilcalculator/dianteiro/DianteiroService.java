package com.frimil.frimilcalculator.dianteiro;

import com.frimil.frimilcalculator.peca.Peca;
import com.frimil.frimilcalculator.peca.PecaDTO;
import com.frimil.frimilcalculator.peca.PecaServico;
import com.frimil.frimilcalculator.produto.Produto;
import com.frimil.frimilcalculator.produto.ProdutoServico;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DianteiroService {

    private final PecaServico pecaServico;

    private final ProdutoServico produtoServico;

    public DianteiroService(PecaServico pecaServico, ProdutoServico produtoServico) {
        this.pecaServico = pecaServico;
        this.produtoServico = produtoServico;
    }

    @Transactional
    public PecaDTO salvarDianteiro(PecaDTO pecaDTO){
        try{
            Peca peca = new Peca();
            peca.setIdPeca(1L);
            peca.setPeso(pecaDTO.getPeso());
            peca.setValorDeCompra(pecaDTO.getValorDeCompra());

            List<Produto> produtos = pecaDTO.getListaDeProdutos().stream().map(
                    produtoDTO -> {
                        Produto produto = new Produto();
                        BeanUtils.copyProperties(produtoDTO, produto);
                        return produto;
                    }).collect(Collectors.toList());


            produtos.forEach(peca::addProduto);

            return pecaServico.salvaPeca(peca);

        }catch (Exception e){
            throw new RuntimeException();
        }
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

    public BigDecimal somarTotalProdutos(DianteiroDTO dianteiroDTO){
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

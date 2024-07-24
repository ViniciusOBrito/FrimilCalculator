package com.frimil.frimilcalculator.dianteiro;

import com.frimil.frimilcalculator.peca.Peca;
import com.frimil.frimilcalculator.peca.PecaDTO;
import com.frimil.frimilcalculator.peca.PecaServico;
import com.frimil.frimilcalculator.produto.Produto;
import com.frimil.frimilcalculator.produto.ProdutoServico;
import com.frimil.frimilcalculator.venda.VendaServico;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class DianteiroService {

    private final PecaServico pecaServico;

    private final ProdutoServico produtoServico;

    private final VendaServico vendaServico;



    @Transactional
    public PecaDTO salvarDianteiro(PecaDTO pecaDTO){
        try{
            Peca peca = new Peca();
            peca.setIdPeca(1L);
            peca.setPeso(pecaDTO.getPeso());
            peca.setValorDeCompra(pecaDTO.getValorDeCompra());

            BigDecimal pesoTotalProdutos = pecaDTO.getListaDeProdutos().
                    stream().
                    map(Produto::getQuantidade)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal custoProduto = this.calculaCustoProduto(pesoTotalProdutos, pecaDTO.getPeso());

            List<Produto> produtos = pecaDTO.getListaDeProdutos().stream().map(
                    produtoDTO -> {
                        Produto produto = new Produto();
                        BeanUtils.copyProperties(produtoDTO, produto);
                        produto.setPercentual(this.calculaPercentual(produto.getQuantidade(), pecaDTO.getPeso()));
                        produto.setCusto(custoProduto);
                        produto.setVenda(vendaServico.buscaVendaPorIdProdutoEPeca(peca.getIdPeca(), produto.getIdProduto()));
                        produto.setTotal(this.calculaVendaTotalProduto(produto.getVenda(), produto.getQuantidade()));
                        return produto;
                    }).collect(Collectors.toList());

            produtos.forEach(peca::addProduto);

            return pecaServico.salvaPeca(peca);

        }catch (Exception e){
            throw new RuntimeException();
        }
    }




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

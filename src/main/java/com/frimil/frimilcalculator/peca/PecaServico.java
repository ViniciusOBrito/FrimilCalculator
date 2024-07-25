package com.frimil.frimilcalculator.peca;

import com.frimil.frimilcalculator.calculo.CalculoServico;
import com.frimil.frimilcalculator.produto.Produto;
import com.frimil.frimilcalculator.venda.VendaServico;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PecaServico {

    private final PecaRepositorio pecaRepositorio;

    private final CalculoServico calculoServico;

    private final VendaServico vendaServico;

    @Transactional
    public PecaDTO cadastrarPecaEProdutos(PecaDTO pecaDTO){
        try{
            Peca peca = new Peca();
            peca.setIdPeca(1L);
            peca.setPeso(pecaDTO.getPeso());
            peca.setValorDeCompra(pecaDTO.getValorDeCompra());

            BigDecimal pesoTotalProdutos = pecaDTO.getListaDeProdutos().
                    stream().
                    map(Produto::getQuantidade)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal custoProduto = calculoServico.calculaCustoProduto(pesoTotalProdutos, pecaDTO.getPeso());

            List<Produto> produtos = pecaDTO.getListaDeProdutos().stream().map(
                    produtoDTO -> {
                        Produto produto = new Produto();
                        BeanUtils.copyProperties(produtoDTO, produto);
                        produto.setPercentual(calculoServico.calculaPercentual(produto.getQuantidade(), pecaDTO.getPeso()));
                        produto.setCusto(custoProduto);
                        produto.setVenda(vendaServico.buscaVendaPorIdProdutoEPeca(peca.getIdPeca(), produto.getIdProduto()));
                        produto.setTotal(calculoServico.calculaVendaTotalProduto(produto.getVenda(), produto.getQuantidade()));
                        return produto;
                    }).collect(Collectors.toList());

            produtos.forEach(peca::addProduto);

            return salvaPeca(peca);

        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public PecaDTO salvaPeca(Peca peca){
        Peca pecaSalva =  pecaRepositorio.save(peca);
        PecaDTO pecaDTO = new PecaDTO();
        BeanUtils.copyProperties(pecaSalva, pecaDTO);

        return pecaDTO;
    }
}

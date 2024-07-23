package com.frimil.frimilcalculator.produto;

import com.frimil.frimilcalculator.peca.Peca;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServico {

    private final ProdutoRepositorio produtoRepositorio;

    public ProdutoServico(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    public List<Produto> salvaProdutos(List<Produto> listaDeProdutos, Peca peca){
        listaDeProdutos.forEach(produto -> {
            produto.setPeca(peca);
            produtoRepositorio.save(produto);
        });

        return listaDeProdutos;
    }
}

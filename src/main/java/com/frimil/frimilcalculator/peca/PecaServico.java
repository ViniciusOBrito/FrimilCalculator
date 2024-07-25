package com.frimil.frimilcalculator.peca;

import com.frimil.frimilcalculator.calculo.CalculoServico;
import com.frimil.frimilcalculator.produto.Produto;
import com.frimil.frimilcalculator.venda.VendaServico;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
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
            BeanUtils.copyProperties(pecaDTO, peca);

            List<Produto> produtos = pecaDTO.getListaDeProdutos().stream().map(
                    produtoDTO -> {
                        Produto produto = new Produto();
                        BeanUtils.copyProperties(produtoDTO, produto);
                        calcularValoresDoProduto(produto, pecaDTO);

                        return produto;
                    }).collect(Collectors.toList());

            produtos.forEach(peca::addProduto);

            return salvarPeca(peca);

        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public PecaDTO buscarPeca(Long id){
        Peca peca =  pecaRepositorio.findById(id).orElseThrow(()-> new EmptyResultDataAccessException(1));
        return new PecaDTO(peca);
    }

    public List<PecaDTO> listarPecas(Long idPeca){
        return pecaRepositorio.findAllByIdPeca(idPeca)
                .stream()
                .map(PecaDTO::new)
                .collect(Collectors.toList());
    }

    public void calcularValoresDoProduto(Produto produto, PecaDTO pecaDTO){
        BigDecimal percentual = calculoServico.calculaPercentual(produto.getQuantidade(), pecaDTO.getPeso());
        BigDecimal custo = calculoServico.calculaCustoProduto(pecaDTO.getListaDeProdutos(), pecaDTO.getPeso());
        BigDecimal venda = vendaServico.buscaVendaPorIdProdutoEPeca(pecaDTO.getIdPeca(), produto.getIdProduto());
        BigDecimal total = calculoServico.calculaVendaTotalProduto(venda, produto.getQuantidade());
        produto.setPercentual(percentual);
        produto.setCusto(custo);
        produto.setVenda(venda);
        produto.setTotal(total);
    }

    public PecaDTO salvarPeca(Peca peca){
        Peca pecaSalva =  pecaRepositorio.save(peca);
        PecaDTO pecaDTO = new PecaDTO();
        BeanUtils.copyProperties(pecaSalva, pecaDTO);

        return pecaDTO;
    }
}

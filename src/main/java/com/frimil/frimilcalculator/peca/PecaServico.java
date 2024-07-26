package com.frimil.frimilcalculator.peca;

import com.frimil.frimilcalculator.calculo.CalculoServico;
import com.frimil.frimilcalculator.exception.EntidadeNaoEncontradaException;
import com.frimil.frimilcalculator.produto.Produto;
import com.frimil.frimilcalculator.venda.VendaServico;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.util.List;


@Service
@AllArgsConstructor
public class PecaServico {

    private final PecaRepositorio pecaRepositorio;

    private final CalculoServico calculoServico;

    private final VendaServico vendaServico;

    @Transactional
    public PecaDTO cadastrarPecaEProdutos(PecaDTO pecaDTO){
        try{

            PecaDTOValidator.validate(pecaDTO);

            Peca peca = new Peca();
            BeanUtils.copyProperties(pecaDTO, peca);

            List<Produto> produtos = pecaDTO.getListaDeProdutos().stream().map(
                    produtoDTO -> {
                        Produto produto = new Produto();
                        BeanUtils.copyProperties(produtoDTO, produto);
                        calcularValoresDoProduto(produto, pecaDTO);

                        return produto;
                    }).toList();

            produtos.forEach(peca::addProduto);

            return salvarPeca(peca);

        }catch (ConstraintViolationException e){
            throw e;
        }catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public PecaDTO buscarPeca(Long id){
        Peca peca =  pecaRepositorio.findById(id).
                orElseThrow(()-> new EntidadeNaoEncontradaException(String.format("Não foi encontado nenhum registro com o ID: %d", id)));
        return new PecaDTO(peca);
    }

    public List<PecaDTO> listarPecas(Long idPeca){
        return pecaRepositorio.findAllByIdPeca(idPeca)
                .stream()
                .map(PecaDTO::new)
                .toList();
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

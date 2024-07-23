package com.frimil.frimilcalculator.peca;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PecaServico {

    private final PecaRepositorio pecaRepositorio;

    public PecaServico(PecaRepositorio pecaRepositorio) {
        this.pecaRepositorio = pecaRepositorio;
    }

    public PecaDTO salvaPeca(Peca peca){
        Peca pecaSalva =  pecaRepositorio.save(peca);
        PecaDTO pecaDTO = new PecaDTO();
        BeanUtils.copyProperties(pecaSalva, pecaDTO);

        return pecaDTO;
    }
}

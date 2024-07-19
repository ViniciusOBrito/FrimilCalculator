package com.frimil.frimilcalculator.dianteiro;

import com.frimil.frimilcalculator.lucro.Lucro;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class DianteiroService {

    public Lucro calcularLucro(DianteiroDTO  dianteiroDTO){

        Lucro lucro = new Lucro();

        BigDecimal pescocoLucro = dianteiroDTO.getPescocoPeso().multiply(new BigDecimal(15.65));

        BigDecimal acemLucro = dianteiroDTO.getAcemPeso().multiply(new BigDecimal(10));

        BigDecimal cupimLucro = dianteiroDTO.getCupimPeso().multiply(new BigDecimal(20.31));

        BigDecimal totalSoma = pescocoLucro.add(acemLucro.add(cupimLucro));

        lucro.setLucro(totalSoma.subtract(dianteiroDTO.getDianteiroPreco()).setScale(2, RoundingMode.HALF_UP));

        

        return lucro;
    }
}

package com.frimil.frimilcalculator.dianteiro;

import com.frimil.frimilcalculator.produto.Produto;

import java.math.BigDecimal;

public class OssoBuco extends Produto {
    public OssoBuco(BigDecimal quantidade, BigDecimal percentual, BigDecimal custo, BigDecimal venda, BigDecimal total) {
        super(quantidade, percentual, custo, venda, total);
    }
}

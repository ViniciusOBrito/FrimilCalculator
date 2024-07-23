package com.frimil.frimilcalculator.dianteiro;

import com.frimil.frimilcalculator.produto.Produto;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.List;

public class DianteiroDTO {

    @NonNull
    private BigDecimal dianteiroPeso;
    @NonNull
    private BigDecimal dianteiroPreco;

    private List<Produto> listaDeProdutos;

    @NonNull
    public BigDecimal getDianteiroPeso() {
        return dianteiroPeso;
    }

    public void setDianteiroPeso(@NonNull BigDecimal dianteiroPeso) {
        this.dianteiroPeso = dianteiroPeso;
    }

    @NonNull
    public BigDecimal getDianteiroPreco() {
        return dianteiroPreco;
    }

    public void setDianteiroPreco(@NonNull BigDecimal dianteiroPreco) {
        this.dianteiroPreco = dianteiroPreco;
    }

    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(List<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }
}

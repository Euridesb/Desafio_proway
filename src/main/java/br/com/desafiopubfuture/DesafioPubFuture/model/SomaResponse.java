package br.com.desafiopubfuture.DesafioPubFuture.model;

import java.math.BigDecimal;

public class SomaResponse {
    private BigDecimal soma;

    public SomaResponse(BigDecimal soma) {
        this.soma = soma;
    }

    public BigDecimal getSoma() {
        return soma;
    }

    public void setSoma(BigDecimal soma) {
        this.soma = soma;
    }
}

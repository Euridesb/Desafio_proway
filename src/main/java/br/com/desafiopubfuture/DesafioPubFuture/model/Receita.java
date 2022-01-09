package br.com.desafiopubfuture.DesafioPubFuture.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Receita")
public class Receita {
    private int id;
    private BigDecimal valor;
    private String dataRecebimento;
    private String dataRecebimentoEsperado;
    private String descricao;
    private BigDecimal conta;
    private String tipoReceita;

    public Receita() {
    }

    public Receita(int id, BigDecimal valor, String dataRecebimento, String dataRecebimentoEsperado,
                   String descricao, BigDecimal conta, String tipoReceita ) {
        this.id = id;
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.descricao = descricao;
        this.conta = conta;
        this.tipoReceita = tipoReceita
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getDataRecebimentoEsperado() {
        return dataRecebimentoEsperado;
    }

    public void setDataRecebimentoEsperado(String dataRecebimentoEsperado) {
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getConta() {
        return conta;
    }

    public void setConta(BigDecimal conta) {
        this.conta = conta;
    }

    public String getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(String tipoReceita) {
        this.tipoReceita = tipoReceita;
    }
}
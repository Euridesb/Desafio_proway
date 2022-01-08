package br.com.desafiopubfuture.DesafioPubFuture.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Conta")
public class Conta {
    private int id;
    private BigDecimal saldo;
    private String instituicaoFinanceira;

    public Conta() {
    }

    public Conta(int id, BigDecimal saldo, String instituicaoFinanceira) {
        this.id = id;
        this.saldo = saldo;
        this.instituicaoFinanceira = instituicaoFinanceira;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    public void setInstituicaoFinanceira(String instituicaoFinanceira) {
        this.instituicaoFinanceira = instituicaoFinanceira;
    }
}
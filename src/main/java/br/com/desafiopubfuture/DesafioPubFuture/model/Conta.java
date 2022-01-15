package br.com.desafiopubfuture.DesafioPubFuture.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import br.com.desafiopubfuture.DesafioPubFuture.model.Despesa;

@Entity
@Table(name = "conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal saldo;
    private String instituicaoFinanceira;
    @OneToMany(mappedBy = "conta")
    private List<Despesa> despesaList;
    @OneToMany(mappedBy = "conta")
    private List<Receita> receitaList;

    public Conta(){}

    public Conta(int id, BigDecimal saldo, String instituicaoFinanceira) {
        this.id = id;
        this.saldo = saldo;
        this.instituicaoFinanceira = instituicaoFinanceira;
    }

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
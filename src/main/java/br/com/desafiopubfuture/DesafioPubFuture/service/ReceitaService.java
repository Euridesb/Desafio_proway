package br.com.desafiopubfuture.DesafioPubFuture.service;

import br.com.desafiopubfuture.DesafioPubFuture.model.Despesa;
import br.com.desafiopubfuture.DesafioPubFuture.model.Receita;
import br.com.desafiopubfuture.DesafioPubFuture.model.ReceitaType;
import br.com.desafiopubfuture.DesafioPubFuture.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
@Service
@Transactional
public class ReceitaService {
    @Autowired
    private ReceitaRepository receitaRepository;
    public List<Receita> listAllReceitas() {
        return receitaRepository.findAll();
    }

    public void saveReceita(Receita receita) {
        receitaRepository.save(receita);
    }

    public Receita getReceita(Integer id) {
        return receitaRepository.findById(id).get();
    }

    public void deleteReceita(Integer id) {
        receitaRepository.deleteById(id);
    }

    public BigDecimal somaTotal(){
        return receitaRepository.somaTotal();
    }

    public List<Receita> listByType(String tipo){
        return receitaRepository.listByType(ReceitaType.valueOf(tipo));
    }
}
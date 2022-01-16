package br.com.desafiopubfuture.DesafioPubFuture.service;

import br.com.desafiopubfuture.DesafioPubFuture.model.Despesa;
import br.com.desafiopubfuture.DesafioPubFuture.model.DespesaType;
import br.com.desafiopubfuture.DesafioPubFuture.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
@Service
@Transactional
public class DespesaService {
    @Autowired
    private DespesaRepository despesaRepository;
    public List<Despesa> listAllDespesa() {
        return despesaRepository.findAll();
    }

    public void saveDespesa(Despesa despesa) {
        despesaRepository.save(despesa);
    }

    public Despesa getDespesa(Integer id) {
        return despesaRepository.findById(id).get();
    }

    public void deleteDespesa(Integer id) {
        despesaRepository.deleteById(id);
    }

    public BigDecimal somaTotal(){
       return despesaRepository.somaTotal();
    }

    public List<Despesa> listByType(String tipo){
        return despesaRepository.listByType(DespesaType.valueOf(tipo));
    }

}
package br.com.desafiopubfuture.DesafioPubFuture.service;

import br.com.desafiopubfuture.DesafioPubFuture.model.Conta;
import br.com.desafiopubfuture.DesafioPubFuture.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
@Service
@Transactional
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;
    public List<Conta> listAllContas() {
        return contaRepository.findAll();
    }
    public BigDecimal calculaSomaTotal(){
        return contaRepository.somaSaldo();
    }

    public void saveConta(Conta conta) {
        contaRepository.save(conta);
    }

    public Conta getConta(Integer id) {
        return contaRepository.findById(id).get();
    }

    public void deleteConta(Integer id) {
        contaRepository.deleteById(id);
    }
}
package com.bancoapp.digital.controller;

import com.bancoapp.digital.model.Cliente;
import com.bancoapp.digital.model.Conta;
import com.bancoapp.digital.repository.ClienteRepository;
import com.bancoapp.digital.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @GetMapping
    public List<Conta> listar() {
        return contaRepository.findAll();
        // return clienteRepository.findByNomeContaining("Si");
    }

    @GetMapping("/{contaId}")
    public ResponseEntity<Conta> buscar(@PathVariable Long contaId) {
        java.util.Optional<Conta> conta = contaRepository.findById(contaId);

        if (conta.isPresent()) {
            return ResponseEntity.ok(conta.get());
        }

        return ResponseEntity.notFound().build();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta adicionar(@Valid @RequestBody Conta conta) {
        return contaRepository.save(conta);
    }

    @PutMapping("/{contaId}")
    public ResponseEntity<Conta> atualizar(@Valid @PathVariable Long contaId, @RequestBody Conta conta) {

        if (!contaRepository.existsById(contaId)) {
            return ResponseEntity.notFound().build();
        }
        conta.setId(contaId);
        conta = contaRepository.save(conta);

        return ResponseEntity.ok(conta);
    }

    @DeleteMapping("/{contaId}")
    public ResponseEntity<Void> remover(@PathVariable Long contaId){
        if (!contaRepository.existsById(contaId)) {
            return ResponseEntity.notFound().build();
        }

        contaRepository.deleteById(contaId);
        return ResponseEntity.noContent().build();
    }




}

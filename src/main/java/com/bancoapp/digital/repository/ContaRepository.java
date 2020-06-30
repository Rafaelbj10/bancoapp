package com.bancoapp.digital.repository;

import com.bancoapp.digital.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    /*List<Conta> findByNome(Long id);
    List<Conta> findByNomeContaining(Long id);*/
}

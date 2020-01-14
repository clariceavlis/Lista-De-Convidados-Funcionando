package com.algaworks.gestaofesta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.gestaofesta.Convidado;

@Repository
public interface Convidados extends JpaRepository<Convidado, Long> {

}
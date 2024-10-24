package br.com.dengue.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dengue.modelo.Registro;

public interface RegistroRepositorio extends JpaRepository<Registro, Long> {
  

}

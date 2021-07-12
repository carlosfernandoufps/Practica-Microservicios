package co.pragma.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.pragma.customerservice.entity.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

}

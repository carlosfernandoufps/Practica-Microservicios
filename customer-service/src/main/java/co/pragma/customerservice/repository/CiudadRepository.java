package co.pragma.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.pragma.customerservice.entity.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

}

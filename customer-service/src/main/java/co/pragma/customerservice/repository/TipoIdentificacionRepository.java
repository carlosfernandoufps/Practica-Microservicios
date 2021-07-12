package co.pragma.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.pragma.customerservice.entity.TipoIdentificacion;

public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Long>{
	
}

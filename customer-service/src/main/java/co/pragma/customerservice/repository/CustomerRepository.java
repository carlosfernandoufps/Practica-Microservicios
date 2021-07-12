package co.pragma.customerservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import co.pragma.customerservice.entity.Customer;
import co.pragma.customerservice.entity.TipoIdentificacion;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findByIdentificacionAndTipoIdentificacion(String identificacion, TipoIdentificacion tipoIdentificacion);
	public List<Customer> findByEdadGreaterThanEqual(int edad);
}

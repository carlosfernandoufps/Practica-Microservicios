package co.pragma.customerservice.service;

import java.util.List;

import co.pragma.customerservice.dto.CustomerDTO;


public interface ICustomerService {

	public List<CustomerDTO> getCustomers();
	public CustomerDTO getCustomer(Long id);
	public CustomerDTO createCustomer(CustomerDTO customer);
	public CustomerDTO updateCustomer(CustomerDTO customer);
	public void deleteCustomer(Long id);
	public CustomerDTO getByIdentificacion(String identificacion, Long tipoIdentificacion);
	public List<CustomerDTO> getByEdad(int edad);
	
}

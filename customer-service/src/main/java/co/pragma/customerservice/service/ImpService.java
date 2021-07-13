package co.pragma.customerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import co.pragma.customerservice.entity.Customer;
import co.pragma.customerservice.entity.TipoIdentificacion;
import co.pragma.customerservice.client.PhotoClient;
import co.pragma.customerservice.dto.*;
import co.pragma.customerservice.exception.CustomerException;
import co.pragma.customerservice.mapper.Mapper;
import co.pragma.customerservice.repository.CustomerRepository;
import co.pragma.customerservice.repository.TipoIdentificacionRepository;

@Service
public class ImpService implements ICustomerService{

	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private TipoIdentificacionRepository daoTipo;
	
	@Autowired
	private Mapper<CustomerDTO, Customer> mapper;
	
	@Autowired
	private PhotoClient fotoClient;
	
	@Override
	public List<CustomerDTO> getCustomers() {
		List<Customer> customersDB = repository.findAll();
		if(customersDB.isEmpty())
			throw new CustomerException(HttpStatus.NOT_FOUND, "No existen clientes en la Base de Datos");
		List<CustomerDTO> list = mapper.EntityToDto(customersDB);
		for(int i = 0; i < list.size(); i++) {
			list.get(i).setPhotoUrl(fotoClient.getFoto(list.get(i).getIdTipoIdentificacion(), list.get(i).getIdentificacion()).getId());
		}
		return list;
	}

	@Override
	public CustomerDTO getCustomer(Long id) {
		Customer customerDB = repository.getById(id);
		if(customerDB == null)
			throw new CustomerException(HttpStatus.NOT_FOUND, "No existe el cliente en la Base de Datos");
		CustomerDTO dto = mapper.EntityToDto(customerDB);
		PhotoDto foto = fotoClient.getFoto(dto.getIdTipoIdentificacion(), dto.getIdentificacion());
		String idFoto = foto.getId();
		dto.setPhotoUrl(idFoto);
		return dto;
	}

	@Override
	public CustomerDTO createCustomer(CustomerDTO customer) {
		TipoIdentificacion tipoDB = daoTipo.getById(customer.getIdTipoIdentificacion());
		Customer customerDB = repository.findByIdentificacionAndTipoIdentificacion(customer.getIdentificacion(), tipoDB);
		if(customerDB != null)
			throw new CustomerException(HttpStatus.BAD_REQUEST, "El cliente ya existe en la Base de Datos");
		customerDB = mapper.DtoToEntity(customer);
		repository.save(customerDB);
		return customer;
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customer) {
		Customer customerDB = repository.getById(customer.getId());
		if(customerDB == null)
			throw new CustomerException(HttpStatus.NOT_FOUND, "El cliente no existe en la Base de Datos");
		customerDB = mapper.DtoToEntity(customer);
		repository.save(customerDB);
		return customer;
	}

	@Override
	public void deleteCustomer(Long id) {
		Customer customerDB = repository.getById(id);
		if(customerDB == null)
			throw new CustomerException(HttpStatus.NOT_FOUND, "El cliente no existe en la Base de Datos");
		repository.delete(customerDB);
	}

	@Override
	public CustomerDTO getByIdentificacion(String identificacion, Long tipoIdentificacion) {
		TipoIdentificacion tipoDB = daoTipo.getById(tipoIdentificacion);
		Customer customerDB = repository.findByIdentificacionAndTipoIdentificacion(identificacion, tipoDB);
		if(customerDB == null)
			throw new CustomerException(HttpStatus.NOT_FOUND, "El cliente no existe en la Base de Datos");
		CustomerDTO dto = mapper.EntityToDto(customerDB);
		PhotoDto foto = fotoClient.getFoto(dto.getIdTipoIdentificacion(), dto.getIdentificacion());
		String idFoto = foto.getId();
		dto.setPhotoUrl(idFoto);
		return dto;
	}

	@Override
	public List<CustomerDTO> getByEdad(int edad) {
		List<Customer> customersDB = repository.findByEdadGreaterThanEqual(edad);
		if(customersDB.isEmpty())
			throw new CustomerException(HttpStatus.NOT_FOUND, "No existen clientes en la Base de Datos con edad mayor o igual a "+edad);
		List<CustomerDTO> list = mapper.EntityToDto(customersDB);
		return list;
	}

}

package co.pragma.customerservice.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.pragma.customerservice.dto.CiudadDTO;
import co.pragma.customerservice.dto.CustomerDTO;
import co.pragma.customerservice.dto.TipoIdentificacionDTO;
import co.pragma.customerservice.entity.Ciudad;
import co.pragma.customerservice.entity.Customer;
import co.pragma.customerservice.entity.TipoIdentificacion;
import co.pragma.customerservice.service.CiudadService;
import co.pragma.customerservice.service.TipoIdentificacionService;

@Component
public class CustomerMapper implements Mapper<CustomerDTO, Customer>{

	@Autowired
	private TipoIdentificacionService serviceTipo;
	
	@Autowired
	private CiudadService serviceCiudad;
	
	@Autowired
	private Mapper<TipoIdentificacionDTO, TipoIdentificacion> mapperTipo;
	
	@Autowired
	private Mapper<CiudadDTO, Ciudad> mapperCiudad;
	
	@Override
	public Customer DtoToEntity(CustomerDTO dto) {
		Customer entity = new Customer();
		entity.setApellido(dto.getApellido());
		entity.setEdad(dto.getEdad());
		entity.setId(dto.getId());
		entity.setIdentificacion(dto.getIdentificacion());
		entity.setNombre(dto.getNombre());
		Long idTipo = dto.getIdTipoIdentificacion();
		TipoIdentificacionDTO tipoDTO = serviceTipo.getTipoIdentificacion(idTipo);
		entity.setTipoIdentificacion(mapperTipo.DtoToEntity(tipoDTO));
		Long idCiudad = dto.getIdCiudad();
		CiudadDTO ciudadDto = serviceCiudad.getCiudadDto(idCiudad);
		entity.setCiudadDeNacimiento(mapperCiudad.DtoToEntity(ciudadDto));
		return entity;
	}

	@Override
	public CustomerDTO EntityToDto(Customer entity) {
		CustomerDTO dto = new CustomerDTO();
		dto.setNombre(entity.getNombre());
		dto.setApellido(entity.getApellido());
		dto.setEdad(entity.getEdad());
		dto.setId(entity.getId());
		dto.setIdCiudad(entity.getCiudadDeNacimiento().getId());
		dto.setIdentificacion(entity.getIdentificacion());
		dto.setIdTipoIdentificacion(entity.getTipoIdentificacion().getId());
		return dto;
	}

	@Override
	public List<Customer> DtoToEntity(List<CustomerDTO> dto) {
		List<Customer> entity = new ArrayList<>();
		for(int i = 0; i < dto.size(); i++) {
			entity.add(DtoToEntity(dto.get(i)));
		}
		return entity;
	}

	@Override
	public List<CustomerDTO> EntityToDto(List<Customer> entity) {
		List<CustomerDTO> dto = new ArrayList<>();
		for(int i = 0; i < entity.size(); i++)
			dto.add(EntityToDto(entity.get(i)));
		return dto;
	}

}

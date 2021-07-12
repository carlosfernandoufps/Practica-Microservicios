package co.pragma.customerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.pragma.customerservice.dto.CiudadDTO;
import co.pragma.customerservice.entity.Ciudad;
import co.pragma.customerservice.mapper.Mapper;
import co.pragma.customerservice.repository.CiudadRepository;

@Service
public class ImpCiudadService implements CiudadService {

	@Autowired
	private CiudadRepository dao;
	
	@Autowired
	private Mapper<CiudadDTO, Ciudad> mapper;
	
	@Override
	public CiudadDTO getCiudadDto(Long id) {
		Ciudad entity = dao.getById(id);
		return mapper.EntityToDto(entity);
	}

	
	
}

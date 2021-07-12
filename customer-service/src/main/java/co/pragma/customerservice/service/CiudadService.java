package co.pragma.customerservice.service;

import org.springframework.stereotype.Service;

import co.pragma.customerservice.dto.CiudadDTO;

public interface CiudadService {

	public CiudadDTO getCiudadDto(Long id);
	
}

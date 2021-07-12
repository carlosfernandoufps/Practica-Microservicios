package co.pragma.customerservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.pragma.customerservice.dto.PaisDTO;


public interface PaisService {
	
	public List<PaisDTO> getPaises();
	public PaisDTO getPais(Long id);
	public PaisDTO createPais(PaisDTO dto);
	public PaisDTO updatePais(PaisDTO dto);
	public void deletePais(Long id);
	
	
}

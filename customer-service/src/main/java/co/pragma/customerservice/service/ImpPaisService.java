package co.pragma.customerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.pragma.customerservice.dto.PaisDTO;
import co.pragma.customerservice.entity.Pais;
import co.pragma.customerservice.mapper.Mapper;
import co.pragma.customerservice.repository.PaisRepository;

@Service
public class ImpPaisService implements PaisService{

	@Autowired
	private PaisRepository dao;
	
	@Autowired
	private Mapper<PaisDTO, Pais> mapper;
	
	@Override
	public List<PaisDTO> getPaises() {
		List<Pais> entity = dao.findAll();
		List<PaisDTO> dto = mapper.EntityToDto(entity);
		return dto;
	}

	@Override
	public PaisDTO getPais(Long id) {
		Pais entity = dao.getById(id);
		return mapper.EntityToDto(entity);
	}

	@Override
	public PaisDTO createPais(PaisDTO dto) {
		Pais entity = mapper.DtoToEntity(dto);
		dao.save(entity);
		return dto;
	}

	@Override
	public PaisDTO updatePais(PaisDTO dto) {
		Pais entity = dao.getById(dto.getId());
		dao.save(entity);
		return dto;
	}

	@Override
	public void deletePais(Long id) {
		// TODO Auto-generated method stub
		
	}

}

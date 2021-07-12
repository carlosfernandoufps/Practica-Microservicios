package co.pragma.customerservice.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.pragma.customerservice.dto.CiudadDTO;
import co.pragma.customerservice.dto.PaisDTO;
import co.pragma.customerservice.entity.Ciudad;
import co.pragma.customerservice.entity.Pais;
import co.pragma.customerservice.service.PaisService;

@Component
public class CiudadMapper implements Mapper<CiudadDTO, Ciudad> {
	
	@Autowired
	private PaisService service;
	
	@Autowired
	private Mapper<PaisDTO, Pais> mapper;
	
	@Override
	public Ciudad DtoToEntity(CiudadDTO dto) {
		Ciudad ciudad = new Ciudad();
		ciudad.setId(dto.getId());
		ciudad.setNombre(dto.getNombre());
		Long idPais = dto.getIdPais();
		PaisDTO paisDTO = service.getPais(idPais);
		Pais pais = mapper.DtoToEntity(paisDTO);
		ciudad.setPais(pais);
		return ciudad;
	}

	@Override
	public CiudadDTO EntityToDto(Ciudad entity) {
		CiudadDTO dto = new CiudadDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setIdPais(entity.getPais().getId());
		return dto;
	}

	@Override
	public List<Ciudad> DtoToEntity(List<CiudadDTO> dto) {
		List<Ciudad> ciudades = new ArrayList<>();
		for(int i = 0; i < dto.size(); i++)
			ciudades.add(DtoToEntity(dto.get(i)));
		return ciudades;
	}

	@Override
	public List<CiudadDTO> EntityToDto(List<Ciudad> entity) {
		List<CiudadDTO> ciudades = new ArrayList<>();
		for(int i = 0; i < entity.size(); i++) {
			ciudades.add(EntityToDto(entity.get(i)));
		}
		return ciudades;
	}



	
}

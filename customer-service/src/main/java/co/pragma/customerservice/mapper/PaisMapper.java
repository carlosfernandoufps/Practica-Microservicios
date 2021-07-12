package co.pragma.customerservice.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.pragma.customerservice.dto.PaisDTO;
import co.pragma.customerservice.entity.Pais;

@Component
public class PaisMapper implements Mapper<PaisDTO, Pais>{

	@Override
	public Pais DtoToEntity(PaisDTO dto) {
		Pais pais = new Pais();
		pais.setId(dto.getId());
		pais.setNombre(dto.getNombre());
		return pais;
	}

	@Override
	public PaisDTO EntityToDto(Pais entity) {
		PaisDTO dto = new PaisDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		return dto;
	}

	@Override
	public List<Pais> DtoToEntity(List<PaisDTO> dto) {
		List<Pais> paises = new ArrayList<>();
		for(int i = 0; i < dto.size(); i++) {
			paises.add(this.DtoToEntity(dto.get(i)));
		}
		return paises;
	}

	@Override
	public List<PaisDTO> EntityToDto(List<Pais> entity) {
		List<PaisDTO> paisesDto = new ArrayList<>();
		for(int i = 0; i < entity.size(); i++) {
			paisesDto.add(this.EntityToDto(entity.get(i)));
		}
		return paisesDto;
	}
	
	
}

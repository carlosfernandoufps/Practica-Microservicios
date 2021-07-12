package co.pragma.customerservice.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.pragma.customerservice.dto.TipoIdentificacionDTO;
import co.pragma.customerservice.entity.TipoIdentificacion;

@Component
public class TipoIdentificacionMapper implements Mapper<TipoIdentificacionDTO, TipoIdentificacion>{

	@Override
	public TipoIdentificacion DtoToEntity(TipoIdentificacionDTO dto) {
		TipoIdentificacion entity = new TipoIdentificacion();
		entity.setId(dto.getId());
		entity.setTipo(dto.getTipo());
		return entity;
	}

	@Override
	public TipoIdentificacionDTO EntityToDto(TipoIdentificacion entity) {
		TipoIdentificacionDTO dto = new TipoIdentificacionDTO();
		dto.setId(entity.getId());
		dto.setTipo(entity.getTipo());
		return dto;
	}

	@Override
	public List<TipoIdentificacion> DtoToEntity(List<TipoIdentificacionDTO> dto) {
		List<TipoIdentificacion> list = new ArrayList<>();
		for(int i = 0; i < dto.size(); i++) {
			list.add(DtoToEntity(dto.get(i)));
		}
		return list;
	}

	@Override
	public List<TipoIdentificacionDTO> EntityToDto(List<TipoIdentificacion> entity) {
		List<TipoIdentificacionDTO> list = new ArrayList<>();
		for(int i = 0; i < entity.size(); i++) {
			list.add(EntityToDto(entity.get(i)));
		}
		return list;
	}

}

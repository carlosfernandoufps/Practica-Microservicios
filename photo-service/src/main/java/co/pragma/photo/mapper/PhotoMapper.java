package co.pragma.photo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.pragma.photo.dto.PhotoDto;
import co.pragma.photo.entity.Photo;

@Component
public class PhotoMapper implements IPhotoMapper {

	@Override
	public PhotoDto EntityToDto(Photo entity) {
		PhotoDto dto = new PhotoDto();
		dto.setActual(entity.isActual());
		dto.setBase64(entity.getBase64());
		dto.setId(entity.getId());
		dto.setIdentificacionPropietario(entity.getIdentificacionPropietario());
		dto.setIdTipoIdentificacion(entity.getIdTipoIdentificacion());
		return dto;
	}

	@Override
	public Photo DtoToEntity(PhotoDto dto) {
		Photo entity = new Photo();
		entity.setActual(dto.isActual());
		entity.setBase64(dto.getBase64());
		entity.setId(dto.getId());
		entity.setIdentificacionPropietario(dto.getIdentificacionPropietario());
		entity.setIdTipoIdentificacion(dto.getIdTipoIdentificacion());
		return entity;
	}

	@Override
	public List<PhotoDto> EntityToDto(List<Photo> entity) {
		List<PhotoDto> list = new ArrayList<>();
		for(int i = 0; i < entity.size(); i++){
			list.add(EntityToDto(entity.get(i)));
		}
		return list;
	}

	@Override
	public List<Photo> DtoToEntity(List<PhotoDto> dto) {
		List<Photo> list = new ArrayList<>();
		for(int i = 0; i < dto.size(); i++){
			list.add(DtoToEntity(dto.get(i)));
		}
		return list;
	}

}

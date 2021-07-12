package co.pragma.photo.mapper;

import java.util.List;

import co.pragma.photo.dto.PhotoDto;
import co.pragma.photo.entity.Photo;

public interface IPhotoMapper {

	public PhotoDto EntityToDto(Photo entity);
	public Photo DtoToEntity(PhotoDto dto);
	public List<PhotoDto> EntityToDto(List<Photo> entity);
	public List<Photo> DtoToEntity(List<PhotoDto> dto);
}

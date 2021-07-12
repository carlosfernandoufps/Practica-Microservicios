package co.pragma.photo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import co.pragma.photo.dto.PhotoDto;
import co.pragma.photo.entity.Photo;
import co.pragma.photo.exception.PhotoException;
import co.pragma.photo.mapper.PhotoMapper;
import co.pragma.photo.repository.PhotoRepository;

@Service
public class PhotoService implements IPhotoService{

	@Autowired
	private PhotoRepository dao;
	
	@Autowired
	private PhotoMapper mapper;
	
	
	@Override
	public List<PhotoDto> getFotos() {
		List<Photo> listDB = dao.findAll();
		if(listDB == null)
			throw new PhotoException(HttpStatus.NOT_FOUND, "No hay fotos en la base de datos");
		List<PhotoDto> listDto = mapper.EntityToDto(listDB);
		return listDto;
	}

	@Override
	public List<PhotoDto> getFotos(Long idTipoIdentificacion, String identificacionPropietario) {
		List<Photo> list = dao.findByIdTipoIdentificacionAndIdentificacionPropietario(idTipoIdentificacion, identificacionPropietario);
		return mapper.EntityToDto(list);
	}

	@Override
	public PhotoDto updateFoto(PhotoDto photo) {
		PhotoDto fotoActual = getFotoActual(photo.getIdTipoIdentificacion(), photo.getIdentificacionPropietario());
		if(fotoActual != null) {
			fotoActual.setActual(false);
			Photo foto = mapper.DtoToEntity(fotoActual);
			dao.save(foto);
		}
		photo.setActual(true);
		Photo fotoDB = mapper.DtoToEntity(photo);
		dao.save(fotoDB);
		return photo;
	}

	@Override
	public PhotoDto deleteFoto(Long idTipoIdentificacion, String identificacionPropietario) {
		Photo foto = dao.findByIdTipoIdentificacionAndIdentificacionPropietarioAndActual(idTipoIdentificacion, identificacionPropietario, true);
		foto.setActual(false);
		dao.save(foto);
		return mapper.EntityToDto(foto);
	}

	@Override
	public PhotoDto getFotoActual(Long idTipoIdentificacion, String identificacionPropietario) {
		Photo foto = dao.findByIdTipoIdentificacionAndIdentificacionPropietarioAndActual(idTipoIdentificacion, identificacionPropietario, true);
		if(foto == null)
			return null;
		return mapper.EntityToDto(foto);
	}

}

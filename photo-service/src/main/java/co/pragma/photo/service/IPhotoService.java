package co.pragma.photo.service;

import java.util.List;

import co.pragma.photo.dto.PhotoDto;

public interface IPhotoService {

	public List<PhotoDto> getFotos();
	public List<PhotoDto> getFotos(Long idTipoIdentificacion, String identificacionPropietario);
	public PhotoDto getFotoActual(Long idTipoIdentificacion, String identificacionPropietario);
	public PhotoDto updateFoto(PhotoDto photo);
	public PhotoDto deleteFoto(Long idTipoIdentificacion, String identificacionPropietario);
	
}

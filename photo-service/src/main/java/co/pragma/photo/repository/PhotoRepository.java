package co.pragma.photo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.pragma.photo.entity.Photo;

public interface PhotoRepository extends MongoRepository<Photo, Long>{

	public List<Photo> findByIdTipoIdentificacionAndIdentificacionPropietario(Long idTipoIdentificacion, String identificacionPropietario);
	public Photo findByIdTipoIdentificacionAndIdentificacionPropietarioAndActual(Long idTipoIdentificacion, String identificacionPropietario, boolean actual);
	
}

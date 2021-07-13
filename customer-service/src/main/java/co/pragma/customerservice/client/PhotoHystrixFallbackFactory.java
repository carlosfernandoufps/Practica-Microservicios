package co.pragma.customerservice.client;

import org.springframework.stereotype.Component;

import co.pragma.customerservice.dto.PhotoDto;

@Component
public class PhotoHystrixFallbackFactory  implements PhotoClient{

	
	@Override
	public PhotoDto getFoto(Long tipo, String identificacion) {
		PhotoDto photo = new PhotoDto();
		photo.setActual(false);
		photo.setBase64("none");
		photo.setId("none");
		photo.setIdentificacionPropietario("none");
		photo.setIdTipoIdentificacion(1L);
		return photo;
	}

}

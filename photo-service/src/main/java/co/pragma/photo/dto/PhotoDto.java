package co.pragma.photo.dto;

import lombok.Data;

@Data
public class PhotoDto {

	private String id;
	private Long idTipoIdentificacion;
	private String identificacionPropietario;
	private String base64;
	private boolean actual;
}

package co.pragma.photo.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document @Data
public class Photo {
	
	@Id
	private String id;
	
	private Long idTipoIdentificacion;
	private String identificacionPropietario;
	private String base64;
	private boolean actual;
	
	
}

package co.pragma.customerservice.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PhotoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Long idTipoIdentificacion;
	private String identificacionPropietario;
	private String base64;
	private boolean actual;
	
}

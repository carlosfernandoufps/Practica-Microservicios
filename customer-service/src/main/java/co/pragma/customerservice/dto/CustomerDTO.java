package co.pragma.customerservice.dto;


import java.io.Serializable;

import lombok.Data;

@Data
public class CustomerDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombre;
	private String apellido;
	private Long idTipoIdentificacion;
	private String identificacion;
	private int edad;
	private Long idCiudad;
	private String photoUrl;
	
}

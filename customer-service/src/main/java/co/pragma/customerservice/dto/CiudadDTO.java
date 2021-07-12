
package co.pragma.customerservice.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CiudadDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private Long idPais;
}

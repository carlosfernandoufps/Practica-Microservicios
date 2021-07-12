package co.pragma.customerservice.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PaisDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	
}

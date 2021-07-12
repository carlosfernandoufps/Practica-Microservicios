package co.pragma.customerservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.pragma.customerservice.dto.TipoIdentificacionDTO;


public interface TipoIdentificacionService {
	
	public List<TipoIdentificacionDTO> getTiposIdentificacion();
	public TipoIdentificacionDTO getTipoIdentificacion(Long id);
	public TipoIdentificacionDTO createTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDto);
	public TipoIdentificacionDTO updateTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDto);
	public void deleteTipoIdentificacion(Long id);
}

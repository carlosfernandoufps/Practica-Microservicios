package co.pragma.customerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import co.pragma.customerservice.dto.TipoIdentificacionDTO;
import co.pragma.customerservice.entity.TipoIdentificacion;
import co.pragma.customerservice.exception.CustomerException;
import co.pragma.customerservice.mapper.Mapper;
import co.pragma.customerservice.repository.TipoIdentificacionRepository;

@Service
public class ImpTipoIdentificacionService implements TipoIdentificacionService{

	@Autowired
	private TipoIdentificacionRepository dao;
	
	@Autowired
	private Mapper<TipoIdentificacionDTO, TipoIdentificacion> mapper;
	
	@Override
	public List<TipoIdentificacionDTO> getTiposIdentificacion() {
		List<TipoIdentificacion> listDB = dao.findAll();
		if(listDB == null)
			throw new CustomerException(HttpStatus.NOT_FOUND, "No existen registros de Tipo de Identificacion en la Base de Datos");
		return mapper.EntityToDto(listDB);
	}

	@Override
	public TipoIdentificacionDTO getTipoIdentificacion(Long id) {
		TipoIdentificacion tipoDB = dao.getById(id);
		if(tipoDB == null)
			throw new CustomerException(HttpStatus.NOT_FOUND, "No existen el registro en la Base de Datos");
		return mapper.EntityToDto(tipoDB);
	}

	@Override
	public TipoIdentificacionDTO createTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDto) {
		TipoIdentificacion tipoDB = mapper.DtoToEntity(tipoIdentificacionDto);
		dao.save(tipoDB);
		return tipoIdentificacionDto;
	}

	@Override
	public TipoIdentificacionDTO updateTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDto) {
		TipoIdentificacion tipoDB = dao.getById(tipoIdentificacionDto.getId());
		tipoDB.setId(tipoIdentificacionDto.getId());
		tipoDB.setTipo(tipoIdentificacionDto.getTipo());
		dao.save(tipoDB);
		return tipoIdentificacionDto;
	}

	@Override
	public void deleteTipoIdentificacion(Long id) {
		dao.deleteById(id);
	}




	
	
}

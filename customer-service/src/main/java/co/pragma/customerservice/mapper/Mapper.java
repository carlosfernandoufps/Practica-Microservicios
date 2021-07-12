package co.pragma.customerservice.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

public interface Mapper<D, E>{

	public E DtoToEntity(D dto);
	public D EntityToDto(E entity);
	public List<E> DtoToEntity(List<D> dto);
	public List<D> EntityToDto(List<E> entity);
	
}

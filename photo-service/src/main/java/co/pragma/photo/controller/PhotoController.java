package co.pragma.photo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.pragma.photo.dto.PhotoDto;
import co.pragma.photo.service.IPhotoService;

@RestController
@RequestMapping("/foto")
public class PhotoController {

	@Autowired
	private IPhotoService service;
	
	@GetMapping
	public List<PhotoDto> listar() {
		return service.getFotos();
	}

	@GetMapping("/{tipo}/{identificacion}")
	public PhotoDto getFoto(@PathVariable(name = "tipo") Long tipo, @PathVariable(name = "identificacion") String identificacion) {
		return service.getFotoActual(tipo, identificacion);
	}
	
	@PostMapping
	public PhotoDto updateFoto(@RequestBody PhotoDto foto) {
		return service.updateFoto(foto);
	}
	
}

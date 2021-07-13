package co.pragma.customerservice.client;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.cloud.openfeign.FeignClient;

import co.pragma.customerservice.dto.PhotoDto;

@FeignClient(name = "photo-service")
@RequestMapping("/foto")
public interface PhotoClient {

	@GetMapping("/{tipo}/{identificacion}")
	public PhotoDto getFoto(@PathVariable(name = "tipo") Long tipo, @PathVariable(name = "identificacion") String identificacion);
	
}

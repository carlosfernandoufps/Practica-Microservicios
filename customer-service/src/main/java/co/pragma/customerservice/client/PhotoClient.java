package co.pragma.customerservice.client;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

import co.pragma.customerservice.dto.PhotoDto;

@FeignClient(name = "photo-service", fallback = PhotoHystrixFallbackFactory.class)
public interface PhotoClient {

	@GetMapping("/foto/{tipo}/{identificacion}")
	public PhotoDto getFoto(@PathVariable(name = "tipo") Long tipo, @PathVariable(name = "identificacion") String identificacion);
	
}

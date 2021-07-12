package co.pragma.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.pragma.customerservice.service.ICustomerService;
import co.pragma.customerservice.dto.CustomerDTO;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService service;
	
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> listar(){
		return new ResponseEntity<>(service.getCustomers(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<>(service.getCustomer(id), HttpStatus.OK);
	}
	
	@GetMapping("/>={edad}")
	public ResponseEntity<List<CustomerDTO>> getCustomersByEdad(@PathVariable(name = "edad") int edad){
		return new ResponseEntity<>(service.getByEdad(edad), HttpStatus.OK);
	}
	
	@GetMapping("/{tipoIdentificacion}/{identificacion}")
	public ResponseEntity<CustomerDTO> getCustomerByIdentificacion(@PathVariable(name="identificacion") String identificacion,
												@PathVariable(name="tipoIdentificacion") Long tipoIdentificacion){
		return new ResponseEntity<>(service.getByIdentificacion(identificacion, tipoIdentificacion), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customer){
		return new ResponseEntity<>(service.createCustomer(customer), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customer){
		return new ResponseEntity<>(service.updateCustomer(customer), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteCustomer(@PathVariable(name = "id") Long id){
		service.deleteCustomer(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}	


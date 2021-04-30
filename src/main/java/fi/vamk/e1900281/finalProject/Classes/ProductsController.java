package fi.vamk.e1900281.finalProject;import java.util.*;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.DeleteMapping;import org.springframework.web.bind.annotation.PutMapping;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RestController;
@RestControllerpublic class ProductsController {	@Autowired	private ProductsRepository repository;	@GetMapping("/products/")	public Iterable<Products> getProducts() {		return repository.findAll();	}	@GetMapping(value ="/products/{id}")	public Optional<Products> getById(@PathVariable("id") int id) {		return repository.findById(id);	}	@PostMapping("/products")	public Products create(@RequestBody Products oneProducts) {		return repository.save(oneProducts);	}	@PutMapping("/products")	public Products update(@RequestBody Products newProducts) {		return repository.save(newProducts);	}	@DeleteMapping("/products")	public void delete(@RequestBody Products deleteProducts) {		repository.delete(deleteProducts);	}}
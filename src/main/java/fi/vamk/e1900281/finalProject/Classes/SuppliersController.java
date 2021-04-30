package fi.vamk.e1900281.finalProject;import java.util.*;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.DeleteMapping;import org.springframework.web.bind.annotation.PutMapping;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RestController;
@RestControllerpublic class SuppliersController {	@Autowired	private SuppliersRepository repository;	@GetMapping("/suppliers/")	public Iterable<Suppliers> getSuppliers() {		return repository.findAll();	}	@GetMapping(value ="/suppliers/{id}")	public Optional<Suppliers> getById(@PathVariable("id") int id) {		return repository.findById(id);	}	@PostMapping("/suppliers")	public Suppliers create(@RequestBody Suppliers oneSuppliers) {		return repository.save(oneSuppliers);	}	@PutMapping("/suppliers")	public Suppliers update(@RequestBody Suppliers newSuppliers) {		return repository.save(newSuppliers);	}	@DeleteMapping("/suppliers")	public void delete(@RequestBody Suppliers deleteSuppliers) {		repository.delete(deleteSuppliers);	}}
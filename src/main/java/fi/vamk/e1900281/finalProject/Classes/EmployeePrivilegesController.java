package fi.vamk.e1900281.finalProject;import java.util.*;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.DeleteMapping;import org.springframework.web.bind.annotation.PutMapping;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RestController;
@RestControllerpublic class EmployeePrivilegesController {	@Autowired	private EmployeePrivilegesRepository repository;	@GetMapping("/employeeprivileges/")	public Iterable<EmployeePrivileges> getEmployeePrivileges() {		return repository.findAll();	}	@GetMapping(value ="/employeeprivileges/{id}")	public Optional<EmployeePrivileges> getById(@PathVariable("id") int id) {		return repository.findById(id);	}	@PostMapping("/employeeprivileges")	public EmployeePrivileges create(@RequestBody EmployeePrivileges oneEmployeePrivileges) {		return repository.save(oneEmployeePrivileges);	}	@PutMapping("/employeeprivileges")	public EmployeePrivileges update(@RequestBody EmployeePrivileges newEmployeePrivileges) {		return repository.save(newEmployeePrivileges);	}	@DeleteMapping("/employeeprivileges")	public void delete(@RequestBody EmployeePrivileges deleteEmployeePrivileges) {		repository.delete(deleteEmployeePrivileges);	}}
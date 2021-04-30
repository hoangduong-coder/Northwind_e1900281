package fi.vamk.e1900281.finalProject;import java.util.*;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.DeleteMapping;import org.springframework.web.bind.annotation.PutMapping;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RestController;
@RestControllerpublic class InventoryTransactionsController {	@Autowired	private InventoryTransactionsRepository repository;	@GetMapping("/inventorytransactions/")	public Iterable<InventoryTransactions> getInventoryTransactions() {		return repository.findAll();	}	@GetMapping(value ="/inventorytransactions/{id}")	public Optional<InventoryTransactions> getById(@PathVariable("id") int id) {		return repository.findById(id);	}	@PostMapping("/inventorytransactions")	public InventoryTransactions create(@RequestBody InventoryTransactions oneInventoryTransactions) {		return repository.save(oneInventoryTransactions);	}	@PutMapping("/inventorytransactions")	public InventoryTransactions update(@RequestBody InventoryTransactions newInventoryTransactions) {		return repository.save(newInventoryTransactions);	}	@DeleteMapping("/inventorytransactions")	public void delete(@RequestBody InventoryTransactions deleteInventoryTransactions) {		repository.delete(deleteInventoryTransactions);	}}
package cm.lotoStudio.cti.utilisateur.controleur;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cm.lotoStudio.cti.utilisateur.ServiceIplm.AutorisationService;
import cm.lotoStudio.cti.utilisateur.models.Autorisation;

@RestController
@RequestMapping("api/autorisation")
public class AutorisationControleur  {
	
	@Autowired
	private AutorisationService autorisationService;
	
	@GetMapping
	public List<Autorisation> findAllClient(){
		return autorisationService.getAll();
	}
	
	@GetMapping("/{id}")
	public Autorisation findById(
			@PathVariable("id") Long id
			) {
		return autorisationService.find(id);
	}
	@PostMapping
	public Autorisation create(
		@RequestBody Autorisation autorisation
		) {
		if(autorisationService.findByName(autorisation.getName()) != null) {
			return null;
		} else {
			autorisation.setId(null);
			
			autorisationService.add(autorisation);
			return autorisation;
		}
		
		}
	
	@PutMapping
	public Autorisation update(
		@RequestBody Autorisation autorisation
		) {	
		if(autorisationService.find(autorisation.getId())!= null) {
			Autorisation autorisation2 = autorisationService.find(autorisation.getId());
			
			autorisation2.setName(autorisation.getName());
			
			autorisationService.update(autorisation);
			return autorisation;
		} else {
			return null;
		  }
		}
	
	@DeleteMapping("/{id}")
	public String delete(
		@PathVariable("id") Long id
		) {
		
		if(autorisationService.find(id) != null) {
			autorisationService.delete(id);
			return "Suppression Ok";
		} else {
			return "not exist";
		  }
		}

}

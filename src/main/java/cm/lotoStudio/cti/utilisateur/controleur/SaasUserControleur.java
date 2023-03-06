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
import cm.lotoStudio.cti.utilisateur.ServiceIplm.SaasUserService;
import cm.lotoStudio.cti.utilisateur.models.SaasUser;

@RestController
@RequestMapping("api/saasUser")
public class SaasUserControleur {
	
	@Autowired
	private SaasUserService saasUserService;

	
	@GetMapping
	public List<SaasUser> findAllClient(){
		return saasUserService.getAll();
	}
	
	@GetMapping("/{id}")
	public SaasUser findById(
		@PathVariable("id") Long id
		) {
		return saasUserService.find(id);
	}
	
	
	@PostMapping
	public SaasUser create(
		@RequestBody SaasUser saasUser
		) {
		saasUser.setId(null);
		
		saasUserService.add(saasUser);
		return saasUser;
	}
	
	@PutMapping
	public SaasUser update(
		@RequestBody SaasUser saasUser) {	
		if(saasUserService.find(saasUser.getId()) != null) {
			SaasUser saasUser2 = saasUserService.find(saasUser.getId());
				
			saasUserService.update(saasUser2);
			return saasUser2;
		} else {
			return null;
		 }
	}
	
	@DeleteMapping("/{id}")
	public String delete(
		@PathVariable("id") Long id
		) {
		if(saasUserService.find(id) != null) {
			saasUserService.delete(id);
			return "Suppression Ok";
		} else {
			return "not exist";
		 }
	}
}

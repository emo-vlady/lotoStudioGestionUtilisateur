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
import cm.lotoStudio.cti.utilisateur.ServiceIplm.AreaSaasService;
import cm.lotoStudio.cti.utilisateur.models.AreaSaas;


@RestController
@RequestMapping("api/areaSaas")
public class AreaSaasControleur {
	@Autowired
	private AreaSaasService areaSaasService;
	@GetMapping
	public List<AreaSaas> findAllClient(){
		return areaSaasService.getAll();
	}
	
	@PostMapping
	public AreaSaas create(
		@RequestBody AreaSaas areaSaas
		) {
		areaSaas.setId(null);
		
		areaSaasService.add(areaSaas);
		return areaSaas;
	}
	
	@PutMapping
	public AreaSaas update(
		@RequestBody AreaSaas areaSaas
		) {	
	areaSaasService.add(areaSaas);
		return areaSaas;
	}
	
	@DeleteMapping("/{id}")
	public String delete(
		@PathVariable("id") Long id
		) {
		if(areaSaasService.find(id) != null) {
			areaSaasService.delete(id);
			return "Suppression Ok";
		} else {
			return "not exist";
		 }
	}



}

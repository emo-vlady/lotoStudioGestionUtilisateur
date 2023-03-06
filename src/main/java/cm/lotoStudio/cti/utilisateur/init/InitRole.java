package cm.lotoStudio.cti.utilisateur.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import cm.lotoStudio.cti.utilisateur.ServiceIplm.AutorisationService;
import cm.lotoStudio.cti.utilisateur.enums.RoleEnum;
import cm.lotoStudio.cti.utilisateur.models.Autorisation;



@Order(1)
@Component
public class InitRole implements ApplicationRunner{

	@Autowired
	private AutorisationService autorisationService;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Initialisation des roles...");
		
		Autorisation gestionAreaSaas = autorisationService.findByName(RoleEnum.ROLE_GESTION_AREASAAS);
		Autorisation gestionAutorisation = autorisationService.findByName(RoleEnum.ROLE_GESTION_AUTORISATION);
		Autorisation gestionSaasUser= autorisationService.findByName(RoleEnum.ROLE_GESTION_SAASUSER);
		Autorisation gestionAdministration = autorisationService.findByName(RoleEnum.ROLE_GESTION_ADMINISTRATEUR);
		
		
		if(gestionAreaSaas  == null) {
			autorisationService.add(new Autorisation(null, RoleEnum.ROLE_GESTION_AREASAAS));
		}
		
		if(gestionAutorisation == null) {
			autorisationService.add(new Autorisation(null, RoleEnum.ROLE_GESTION_AUTORISATION));
			
		}
		if(gestionSaasUser == null) {
			autorisationService.add(new Autorisation(null, RoleEnum.ROLE_GESTION_SAASUSER));
		}
		if(gestionAdministration == null) {
			autorisationService.add(new Autorisation(null, RoleEnum.ROLE_GESTION_ADMINISTRATEUR));
		}
		
	}

}

package cm.lotoStudio.cti.utilisateur.service;

import cm.lotoStudio.cti.utilisateur.models.Autorisation;

public interface AutorisationIService extends ICrudService<Autorisation, Long> {
	
	Autorisation findByName(String name);
}

package cm.lotoStudio.cti.utilisateur.ServiceIplm;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.lotoStudio.cti.utilisateur.exceptions.DAOException;
import cm.lotoStudio.cti.utilisateur.exceptions.FormValidationException;
import cm.lotoStudio.cti.utilisateur.models.Utilisateur;
import cm.lotoStudio.cti.utilisateur.repositories.UtilisateurRepository;
import cm.lotoStudio.cti.utilisateur.service.UtilisateurIService;
import jakarta.persistence.NoResultException;

@Service
public class UtilisateurService implements UtilisateurIService {
	
	@Autowired
	private UtilisateurRepository repository;

	@Override
	public List<Utilisateur> getAll() throws DAOException {
		try {
			return repository.findAll();
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		} catch (NoResultException e) {
			return new ArrayList<>();
		}
	}

	@Override
	public void add(Utilisateur entity) throws DAOException {
		try {
			entity.setId(null);
			repository.save(entity);
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void update(Utilisateur entity) throws DAOException {
		try {
			repository.save(entity);
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void delete(Long id) throws DAOException {
		try {
			repository.delete(find(id));
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public Utilisateur find(Long id) throws DAOException {
		try {
			return repository.findById(id).get();
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public void saveAll(Iterable<Utilisateur> iterable) throws DAOException {
		try {
			repository.saveAll(iterable);
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public Utilisateur findId(Long id) throws FormValidationException {
		try {
			return repository.findById(id).get();
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		} catch (NoSuchElementException e) {
			throw new FormValidationException(e.getMessage());
		}

	}

}

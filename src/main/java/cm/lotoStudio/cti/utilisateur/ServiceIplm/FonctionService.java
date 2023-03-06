package cm.lotoStudio.cti.utilisateur.ServiceIplm;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.lotoStudio.cti.utilisateur.exceptions.DAOException;
import cm.lotoStudio.cti.utilisateur.exceptions.FormValidationException;
import cm.lotoStudio.cti.utilisateur.models.Fonction;
import cm.lotoStudio.cti.utilisateur.repositories.FonctionRepository;
import cm.lotoStudio.cti.utilisateur.service.FonctionIService;
import jakarta.persistence.NoResultException;

@Service
public class FonctionService implements FonctionIService {

	@Autowired
	private FonctionRepository repository;
	@Override
	public List<Fonction> getAll() throws DAOException {
		try {
			return repository.findAll();
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		} catch (NoResultException e) {
			return new ArrayList<>();
		}
	}

	@Override
	public void add(Fonction entity) throws DAOException {
		try {
			entity.setId(null);
			repository.save(entity);
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void update(Fonction entity) throws DAOException {
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
	public Fonction find(Long id) throws DAOException {
		try {
			return repository.findById(id).get();
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public void saveAll(Iterable<Fonction> iterable) throws DAOException {
		try {
			repository.saveAll(iterable);
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Fonction findId(Long id) throws FormValidationException {
		try {
			return repository.findById(id).get();
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		} catch (NoSuchElementException e) {
			throw new FormValidationException(e.getMessage());
		}

	}
	
	

}

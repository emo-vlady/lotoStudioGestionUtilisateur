package cm.lotoStudio.cti.utilisateur.ServiceIplm;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.lotoStudio.cti.utilisateur.exceptions.DAOException;
import cm.lotoStudio.cti.utilisateur.exceptions.FormValidationException;
import cm.lotoStudio.cti.utilisateur.models.SaasUser;
import cm.lotoStudio.cti.utilisateur.repositories.SaasUserRepository;
import cm.lotoStudio.cti.utilisateur.service.SaasUserIService;
import jakarta.persistence.NoResultException;

@Service
public class SaasUserService implements SaasUserIService {
	
	@Autowired
	private SaasUserRepository repository;

	@Override
	public List<SaasUser> getAll() throws DAOException {
		try {
			return repository.findAll();
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		} catch (NoResultException e) {
			return new ArrayList<>();
		}
	}

	@Override
	public void add(SaasUser entity) throws DAOException {
		try {
			entity.setId(null);
			repository.save(entity);
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void update(SaasUser entity) throws DAOException {
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
	public SaasUser find(Long id) throws DAOException {
		try {
			return repository.findById(id).get();
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public void saveAll(Iterable<SaasUser> iterable) throws DAOException {
		try {
			repository.saveAll(iterable);
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public SaasUser findId(Long id) throws FormValidationException {
		try {
			return repository.findById(id).get();
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		} catch (NoSuchElementException e) {
			throw new FormValidationException(e.getMessage());
		}
	}

}

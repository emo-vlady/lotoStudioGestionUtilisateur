package cm.lotoStudio.cti.utilisateur.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import cm.lotoStudio.cti.utilisateur.models.Address;

@Repository
@RepositoryRestResource(exported = false)
public interface AddressRepository extends JpaRepository<Address, Long> {

}

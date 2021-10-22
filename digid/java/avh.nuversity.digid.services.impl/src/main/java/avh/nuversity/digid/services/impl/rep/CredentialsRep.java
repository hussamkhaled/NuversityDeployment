package avh.nuversity.digid.services.impl.rep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import avh.nuversity.digid.model.AvhCredentials;

@Repository
public interface CredentialsRep extends CrudRepository<AvhCredentials, String> {
//	public AvhCredentials findByLoginidAndCmethod(String login, String cmethod);
	public List<AvhCredentials> findByCmethod(String cmethod);
	public AvhCredentials findByLoginid(String loginid);
}

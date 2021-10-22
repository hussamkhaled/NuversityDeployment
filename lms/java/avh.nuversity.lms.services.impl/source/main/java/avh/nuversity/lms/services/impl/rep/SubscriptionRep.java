package avh.nuversity.lms.services.impl.rep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhStudent;
import avh.nuversity.lms.model.AvhSubscription;

public interface SubscriptionRep extends CrudRepository<AvhSubscription, String>{

	public List<AvhSubscription> findByStudentBean(AvhStudent studentBean);
}

package avh.nuversity.lms.services.impl.rep;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhStudent;

public interface StudentRep extends CrudRepository<AvhStudent, String>{
		public AvhStudent findByUserid(String userid);
}

package avh.nuversity.lms.services.impl.rep;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import avh.nuversity.lms.model.AvhCourseOfferSchedule;
@Repository
public interface CourseOfferScheduleRep extends CrudRepository<AvhCourseOfferSchedule, String>{

	public AvhCourseOfferSchedule findByOffer(String offer);
	
}

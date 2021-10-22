package avh.nuversity.lms.services.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import avh.nuversity.lms.model.AvhCampus;
import avh.nuversity.lms.services.impl.rep.AvhRep;

@Component
public class CampusControllerImpl {

	@Autowired
	private AvhRep rep;

	public AvhCampus createCampus(AvhCampus cmp) {
		cmp.setIid(UUID.randomUUID().toString());
		rep.getCampusRep().save(cmp);
		return cmp;
	}
}

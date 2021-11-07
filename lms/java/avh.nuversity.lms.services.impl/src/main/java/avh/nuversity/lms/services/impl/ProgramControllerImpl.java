package avh.nuversity.lms.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import avh.nuversity.lms.model.AvhPgm;
import avh.nuversity.lms.services.impl.query.CreateProgramQuery;
import avh.nuversity.lms.services.impl.rep.AvhRep;
import avh.nuversity.lms.services.impl.response.AllProgramsResponse;

@Component
public class ProgramControllerImpl {
	@Autowired
	private AvhRep rep;

	public AvhPgm createProgram(CreateProgramQuery fc) {
		AvhPgm pgm = new AvhPgm();
		
		pgm.setIid(UUID.randomUUID().toString());
		pgm.setName(fc.getName());
		pgm.setDepartmentBean(rep.getDepartmentRep().findByIid(fc.getDepartment()));
		rep.getProgramRep().save(pgm);
		return pgm;
	}

	public List<AllProgramsResponse> getAllPrograms() {
		
		List<AllProgramsResponse> res = new ArrayList<AllProgramsResponse>();
		List<AvhPgm> lst = rep.getProgramRep().findAll();
		for (AvhPgm avhPgm : lst) {
			AllProgramsResponse pres = new AllProgramsResponse();
			pres.setName(avhPgm.getName());
			pres.setPgmid(avhPgm.getIid());
			res.add(pres);
		}
		return res;
	}
}

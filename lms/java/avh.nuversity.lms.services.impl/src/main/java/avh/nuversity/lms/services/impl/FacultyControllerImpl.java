package avh.nuversity.lms.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import avh.nuversity.lms.model.AvhDepartment;
import avh.nuversity.lms.model.AvhFaculty;
import avh.nuversity.lms.model.AvhMajor;
import avh.nuversity.lms.model.AvhPgm;
import avh.nuversity.lms.services.impl.query.CreateFacultyQuery;
import avh.nuversity.lms.services.impl.rep.AvhRep;
import avh.nuversity.lms.services.impl.util.DepartmentRepresentation;
import avh.nuversity.lms.services.impl.util.FacultyRepresentation;
import avh.nuversity.lms.services.impl.util.MajorRepresentation;
import avh.nuversity.lms.services.impl.util.ProgramRepresentation;

@Component
public class FacultyControllerImpl {
	@Autowired
	private AvhRep rep;

	public AvhFaculty createFaculty(CreateFacultyQuery fc) {
		AvhFaculty fac = new AvhFaculty();
		
		fac.setIid(UUID.randomUUID().toString());
		fac.setName(fc.getName());
		fac.setIsInternal(fc.isInternal());
		fac.setUniversityBean(rep.getUniversityRep().findByIid(fc.getUniversity()));
		rep.getFacultyRep().save(fac);
		return fac;
	}

	public List<FacultyRepresentation> facultyRepresentation() {
		
		List<FacultyRepresentation> lsFac = new ArrayList<FacultyRepresentation>();
		
		List<AvhFaculty> lsavhFac= rep.getFacultyRep().findAll();
		for (AvhFaculty fac : lsavhFac) {
			FacultyRepresentation frep = new FacultyRepresentation();
			frep.setFaculty(fac.getName());
			List<AvhDepartment> lsavhdep = rep.getDepartmentRep().findByFacultyBean(fac);
			List<DepartmentRepresentation> lsDep = new ArrayList<DepartmentRepresentation>();
			for (AvhDepartment dep : lsavhdep) {
				DepartmentRepresentation drep = new DepartmentRepresentation();
				drep.setDepartment(dep.getName());
				List<AvhPgm> lsavhpgm = rep.getProgramRep().findAll();
				List<ProgramRepresentation> lsProg = new ArrayList<ProgramRepresentation>();
				for (AvhPgm pgm : lsavhpgm) {
					ProgramRepresentation prep = new ProgramRepresentation();
					prep.setProgram(pgm.getName());
					List<AvhMajor> lsavhmajor = rep.getMajorRep().findByPgmBean(pgm);
					List<MajorRepresentation> lrepmajor = new ArrayList<MajorRepresentation>();
					for (AvhMajor maj : lsavhmajor) {
						MajorRepresentation mrp = new MajorRepresentation();
						mrp.setMajorId(maj.getIid());
						mrp.setMajorName(maj.getName());
						lrepmajor.add(mrp);
					}
					prep.setLsmajor(lrepmajor);
					lsProg.add(prep);
				}
				drep.setLsprogram(lsProg);
				lsDep.add(drep);
			}
			frep.setLsDepartment(lsDep);
			lsFac.add(frep);
		}
		
		return lsFac;
	}
}

package avh.nuversity.lms.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import avh.nuversity.lms.model.AvhContractSheet;
import avh.nuversity.lms.model.AvhMajor;
import avh.nuversity.lms.model.AvhMajorCourse;
import avh.nuversity.lms.model.AvhMajorReqDoc;
import avh.nuversity.lms.services.impl.query.ContractSheetQuery;
import avh.nuversity.lms.services.impl.query.CreateMajorQuery;
import avh.nuversity.lms.services.impl.query.MajorCourseQuery;
import avh.nuversity.lms.services.impl.rep.AvhRep;
import avh.nuversity.lms.services.impl.response.MajorByProgramResponse;
import avh.nuversity.lms.services.impl.response.MajorContractSheetResponse;
import avh.nuversity.lms.services.impl.response.MajorDescPreResponse;
import avh.nuversity.lms.services.impl.response.MajorReqDocResponse;

@Component
public class MajorControllerImpl {
	@Autowired
	private AvhRep rep;

	public AvhMajor createMajor(CreateMajorQuery fc) {
		AvhMajor major = new AvhMajor();
		
		major.setIid(UUID.randomUUID().toString());
		major.setName(fc.getName());
		major.setCreditCost(fc.getCrd_cost());
		major.setPgmBean(rep.getProgramRep().findByIid(fc.getProgram()));
		major.setCreditNumber(fc.getCrdNumber());
		major.setDescription(fc.getDescription());
		major.setPrequisets(fc.getPrerequ());
		major.setMyears(fc.getMyears());
		major.setCertificate(fc.getCertificate());
		
		rep.getMajorRep().save(major);
		return major;
	}

	public String majorCourse(MajorCourseQuery fc) {
		AvhMajorCourse mc = new AvhMajorCourse();
		mc.setCourseBean(rep.getCourseRep().findByIid(fc.getCourse()));
		mc.setMajorBean(rep.getMajorRep().findByIid(fc.getMajor()));
		mc.setCourseType(fc.getCourseType());
		mc.setIid(UUID.randomUUID().toString());
		rep.getMajorCourseRep().save(mc);
		return ErrorCode.Success;
	}

	public String contractSheet(ContractSheetQuery fc) {
		AvhContractSheet cst = new AvhContractSheet();
		cst.setCoreCredit(fc.getCoreCrd());
		cst.setElectiveCredit(fc.getElectiveCrd());
		cst.setGeneralCredit(fc.getGeneralCrd());
		cst.setMajorCredit(fc.getMajorCrd());
		cst.setMajorBean(rep.getMajorRep().findByIid(fc.getMajor()));
		cst.setIid(UUID.randomUUID().toString());
		
		rep.getContractSheetRep().save(cst);
		
		return ErrorCode.Success;
	}

	public String getMajorById(String mId) {
		return rep.getMajorRep().findByIid(mId).getName();
		
	}

	public List<MajorByProgramResponse> getMajorsByProgramsAndCerificate(String pId, String cer) {
		List<MajorByProgramResponse> response = new ArrayList<MajorByProgramResponse>();
		List<AvhMajor> lstmajor = rep.getMajorRep().findByPgmBean(rep.getProgramRep().findByIid(pId));
		for (AvhMajor mj : lstmajor) {
			if(mj.getCertificate().equals(cer)) {
				MajorByProgramResponse tmp = new MajorByProgramResponse();
				tmp.setMajorid(mj.getIid());
				tmp.setName(mj.getName());
				response.add(tmp);
			}
		}
		return response;
	}

	public MajorDescPreResponse getMajorDescAndPre(String mId) {
		MajorDescPreResponse response = new MajorDescPreResponse();
		AvhMajor mj = rep.getMajorRep().findByIid(mId);
		response.setDescription(mj.getDescription());
		response.setPrerequisites(mj.getPrequisets());
		return response;
	}

	public AvhMajor getAllMajorAttById(String mId) {
		return rep.getMajorRep().findByIid(mId);
	}

	public MajorContractSheetResponse getmajorContractSheet(String mId) {
		AvhContractSheet cs =  rep.getContractSheetRep().findByMajorBean(rep.getMajorRep().findByIid(mId));
		MajorContractSheetResponse response = new MajorContractSheetResponse();
		response.setCore(cs.getCoreCredit());
		response.setElective(cs.getElectiveCredit());
		response.setGeneral(cs.getGeneralCredit());
		response.setMajor(cs.getMajorCredit());
		return response;
	}

	public List<MajorReqDocResponse> getmajorRequiredDoc(String mId) {
		//TODO fix the repository class
//		List<MajorReqDocResponse> response = new ArrayList<MajorReqDocResponse>();
//		List<AvhMajorReqDoc> lst = rep.getMajorReqDocRep().findByMajorBean(rep.getMajorRep().findByIid(mId));
//		for (AvhMajorReqDoc mj : lst) {
//			MajorReqDocResponse res = new MajorReqDocResponse();
//			res.setDoc(mj.getLabel());
//			res.setMajor(mj.getMajorBean().getIid());
//			response.add(res);
//		}
//		return response;
		
		List<MajorReqDocResponse> response = new ArrayList<MajorReqDocResponse>();
		List<AvhMajorReqDoc> lst = new ArrayList<AvhMajorReqDoc>();
		Iterable<AvhMajorReqDoc> it = rep.getMajorReqDocRep().findAll();
		for (AvhMajorReqDoc rdc : it) {
			lst.add(rdc);
		}
		
		for (AvhMajorReqDoc mj : lst) {
			if(mj.getMajorBean().equals(mId)) {
		MajorReqDocResponse res = new MajorReqDocResponse();
		res.setDoc(mj.getLabel());
		res.setMajor(mj.getMajorBean());
		response.add(res);
			}
	}
	return response;
		
	}
}

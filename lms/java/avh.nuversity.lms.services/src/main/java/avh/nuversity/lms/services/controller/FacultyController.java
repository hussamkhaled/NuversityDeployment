package avh.nuversity.lms.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import avh.nuversity.lms.model.AvhFaculty;
import avh.nuversity.lms.services.impl.FacultyControllerImpl;
import avh.nuversity.lms.services.impl.query.CreateFacultyQuery;

import avh.nuversity.lms.services.impl.util.FacultyRepresentation;

		@RestController
		public class FacultyController {
		@Autowired
		private FacultyControllerImpl svc;
			@CrossOrigin(origins =CORSTitle.React_Nuversity)
			@PostMapping("/nuversity/api/lms/faculty")
			public AvhFaculty newFaculty(@RequestBody CreateFacultyQuery fc) {
				return svc.createFaculty(fc);
			}
			@CrossOrigin(origins =CORSTitle.React_Nuversity)
			@GetMapping("/nuversity/api/lms/facultyRepresentation")
			public List<FacultyRepresentation> facultyRepresentation() {
				return svc.facultyRepresentation();
			}

}

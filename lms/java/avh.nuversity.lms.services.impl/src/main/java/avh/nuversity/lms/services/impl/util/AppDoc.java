package avh.nuversity.lms.services.impl.util;

import org.springframework.web.multipart.MultipartFile;

public class AppDoc {

	MultipartFile document;
	public MultipartFile getDocument() {
		return document;
	}

	public void setDocument(MultipartFile document) {
		this.document = document;
	}

	
}

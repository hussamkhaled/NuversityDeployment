package avh.nuversity.digid.services.impl;

public interface DigidConstants {
	public static final int MAX_TRY = 5;
	public static final String LinkSentForgetPassword="http://45.9.190.133:3000/ChangeForgottenPassword";
	public static final int TimeToExpiryForgetPassMail = 10;
	public static final String MailTitleForgetPassword = "Forget Password";
	
	public static final String MakeStudent = "Make Student";
	public static final int timetoexpirypassword = 1;//month
//	public static final String ContactPhoto = "ContactPhoto";
//	public static final String ContactPhotoPath = "/PhotosContactPhotos/";	
	public static final String IdDocumentPhoto = "IdDocumentPhoto";
	public static final String IdDocumentPhotoPath = "IdDocumentPhoto";
	public static final String LinkSentSetPassword = "http://45.9.190.133:3000/SetPassword";
	public static final int TimeToExpirySetPassMail = 20;
	public static final String MailTitleSetPassword = null;
	public static final String ContactPhotoPath = "photos/Contact";
	public static final String IdPhotosPhotoPath = "photos/IdDocument";
	public static final String PENDING = "PENDING";
	public static final String EXPIRED = "EXPIRED";
	public static final String CONFIRMED = "CONFIRMED";
	public static final String AdminNumail = "01";
	public static final String TeacherNumail = "02";
	public static final String StudentNumail = "03";
	public static final String OtherNumail = "04";
	public static final String STUDENT = "STUDENT";

	
}

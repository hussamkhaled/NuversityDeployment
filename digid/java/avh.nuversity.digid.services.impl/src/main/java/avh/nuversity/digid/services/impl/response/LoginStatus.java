package avh.nuversity.digid.services.impl.response;

public enum LoginStatus {
	Success,
	UnregisteredEmail,
	WrongPassword,
	BlockedAccount,
	ExpiredPassword;
}

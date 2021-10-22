package avh.nuversity.digid.services.impl.rep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AvhRep {
	@Autowired
	private ContactRep contactRep;
	@Autowired
	private UserRep userRep;
	@Autowired
	private GroupRep groupRep;
	@Autowired
	private CredentialsRep credentialRep;
	@Autowired
	private PendingRequestRep pendingRequestRep;
	@Autowired
	private UserGroupsRep UGRep;
	@Autowired
	private IdDocumentRep IDDRep;
	@Autowired
	private NuidSequencenumberRep NSNRep;
	@Autowired
	private MmessageRep mmrep;
	
	public MmessageRep getMmrep() {
		return mmrep;
	}

	public void setMmrep(MmessageRep mmrep) {
		this.mmrep = mmrep;
	}

	public AvhRep() {}

	public ContactRep getContactRep() {
		return this.contactRep;
	}

	public UserRep getUserRep() {
		return this.userRep;
	}
	
	public GroupRep getGroupRep() {
		return this.groupRep;
	}
	
	
	public CredentialsRep getCredentialRep() {
		return this.credentialRep;
	}
	
	public PendingRequestRep getPengingRep() {
		return this.pendingRequestRep;
	}
	
	public UserGroupsRep getUGRep() {
		return this.UGRep;
	}
	
	public IdDocumentRep getIDDRep() {
		return this.IDDRep;
	}
	
	public NuidSequencenumberRep getNSNRep() {
		return this.NSNRep;
	}
}

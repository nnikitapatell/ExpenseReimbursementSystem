package main.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import main.constants.ReimbursementStatus;
import main.constants.ReimbursementType;

/**
 * @author niki3
 *
 */
public class Reimbursement {

	private int reimAmount;
	private Timestamp reimDateSubmitted;
	private Timestamp reimDateResolved;
	private String reimDescription;
	private int author;
	private int resolver;
	private ReimbursementStatus statusId;
	private ReimbursementType typeId;
	private int reimId;
	private String authorName;
	private String resolverName;
	private String status;
	private String type;
	private String submitDate = "";
	private String resolvedDate = "";
	
	/**
	 * @param reimId
	 * @param reimAmount
	 * @param reimDateSubmitted
	 * @param reimDateResolved
	 * @param reimDescription
	 * @param author
	 * @param resolver
	 * @param statusId
	 * @param typeId
	 */
	public Reimbursement(int reimId, int reimAmount, Timestamp reimDateSubmitted, Timestamp reimDateResolved,
			String reimDescription, int author, int resolver, int statusId, int typeId) {
		
		super();
		this.reimId = reimId;
		this.reimAmount = reimAmount;
		this.reimDateSubmitted = reimDateSubmitted;
		this.reimDateResolved = reimDateResolved;
		this.reimDescription = reimDescription;
		this.author = author;
		this.resolver = resolver;
		this.statusId = ReimbursementStatus.fromInt(statusId);
		this.typeId = ReimbursementType.fromInt(typeId) ;
		this.submitDate = new SimpleDateFormat("MM/dd/yyyy").format(reimDateSubmitted);
		if(null != reimDateResolved) 	this.resolvedDate = new SimpleDateFormat("MM/dd/yyyy").format(reimDateResolved); //format date
	}


	/**
	 * @param int1
	 * @param int2
	 * @param timestamp
	 * @param timestamp2
	 * @param string
	 * @param string2
	 * @param string3
	 * @param string4
	 * @param string5
	 */
	public Reimbursement(int int1, int int2, Timestamp timestamp, Timestamp timestamp2, String string, String string2,
			String string3, String string4, String string5) {
	
		this.reimId = int1;
		this.reimAmount = int2;
		this.reimDateSubmitted = timestamp;
		this.reimDateResolved = timestamp2;
		this.reimDescription = string;
		this.authorName = string2;
		this.resolverName = string3;
		this.status = string4;
		this.type = string5;
		this.submitDate = new SimpleDateFormat("MM/dd/yyyy").format(timestamp);
		if(null != timestamp2) 	this.resolvedDate = new SimpleDateFormat("MM/dd/yyyy").format(timestamp2);
	}

	/**
	 * @return the reimId
	 */
	public int getReimId() {
		return reimId;
	}

	/**
	 * @param reimId the reimId to set
	 */
	public void setReimId(int reimId) {
		this.reimId = reimId;
	}

	/**
	 * @return the reimAmount
	 */
	public int getReimAmount() {
		return reimAmount;
	}

	/**
	 * @param reimAmount the reimAmount to set
	 */
	public void setReimAmount(int reimAmount) {
		this.reimAmount = reimAmount;
	}

	/**
	 * @return the reimDateSubmitted
	 */
	public Timestamp getReimDateSubmitted() {
		return reimDateSubmitted;
	}

	/**
	 * @param reimDateSubmitted the reimDateSubmitted to set
	 */
	public void setReimDateSubmitted(Timestamp reimDateSubmitted) {
		this.reimDateSubmitted = reimDateSubmitted;
	}

	/**
	 * @return the reimDateResolved
	 */
	public Timestamp getReimDateResolved() {
		return reimDateResolved;
	}

	/**
	 * @param reimDateResolved the reimDateResolved to set
	 */
	public void setReimDateResolved(Timestamp reimDateResolved) {
		this.reimDateResolved = reimDateResolved;
	}

	/**
	 * @return the reimDescription
	 */
	public String getReimDescription() {
		return reimDescription;
	}

	/**
	 * @param reimDescription the reimDescription to set
	 */
	public void setReimDescription(String reimDescription) {
		this.reimDescription = reimDescription;
	}

	/**
	 * @return the author
	 */
	public int getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(int author) {
		this.author = author;
	}

	/**
	 * @return the resolver
	 */
	public int getResolver() {
		return resolver;
	}

	/**
	 * @param resolver the resolver to set
	 */
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	/**
	 * @return the statusId
	 */
	public ReimbursementStatus getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(ReimbursementStatus statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the typeId
	 */
	public ReimbursementType getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(ReimbursementType typeId) {
		this.typeId = typeId;
	}


	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "Reimbursement [reimId=" + reimId + ", reimAmount=" + reimAmount + ", reimDateSubmitted="
				+ reimDateSubmitted + ", reimDateResolved=" + reimDateResolved + ", reimDescription=" + reimDescription
				+ ", author=" + author + ", resolver=" + resolver + ", statusId=" + statusId + ", Type=" + typeId
				+ "]";
	}

	/**
	 * @return
	 */
	public String getAuthorName() {
		return authorName;
	}


	/**
	 * @param authorName
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	/**
	 * @return
	 */
	public String getResolverName() {
		return resolverName;
	}


	/**
	 * @param resolverName
	 */
	public void setResolverName(String resolverName) {
		this.resolverName = resolverName;
	}


	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 * @return
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return
	 */
	public String getSubmitDate() {
		return submitDate;
	}


	/**
	 * @param submitDate
	 */
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}


	/**
	 * @return
	 */
	public String getResolvedDate() {
		return resolvedDate;
	}


	/**
	 * @param resolvedDate
	 */
	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	
}

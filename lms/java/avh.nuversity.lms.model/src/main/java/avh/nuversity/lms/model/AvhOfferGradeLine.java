package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the offer_grade_line database table.
 * 
 */
@Entity
@Table(name="offer_grade_line")
@NamedQuery(name="AvhOfferGradeLine.findAll", query="SELECT a FROM AvhOfferGradeLine a")
public class AvhOfferGradeLine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	@Column(name="exam_name")
	private String examName;

	private BigDecimal percentage;

	//uni-directional many-to-one association to AvhOfferGradeFormat
	@ManyToOne
	@JoinColumn(name="offer_format")
	private AvhOfferGradeFormat offerGradeFormat;

	public AvhOfferGradeLine() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getExamName() {
		return this.examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public BigDecimal getPercentage() {
		return this.percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	public AvhOfferGradeFormat getOfferGradeFormat() {
		return this.offerGradeFormat;
	}

	public void setOfferGradeFormat(AvhOfferGradeFormat offerGradeFormat) {
		this.offerGradeFormat = offerGradeFormat;
	}

}
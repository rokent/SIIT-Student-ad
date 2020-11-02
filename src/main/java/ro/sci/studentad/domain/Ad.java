package ro.sci.studentad.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Inheritance
@DiscriminatorColumn(name = "ADD_TYPE")
@DiscriminatorOptions(force = true)
@Table(name = "ads")
public class Ad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 10, message = "Title must be at least {min} long.")
	@NotNull(message = "Title cannot be null.")
	private String title;

	@Size(min = 10, max = 400, message = "Description must be between {min} and {max} long.")
	@NotNull(message = "Description cannot be null.")
	private String adBody;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	protected Calendar addDate;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	protected Calendar expirationDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PUBLISHER_ID")
	private SiteUser owner;

	@Column(name = "ADD_TYPE", insertable = false, updatable = false)
	private String adType;

	public Ad() {
	}

	@PrePersist
	protected void onCreate() {
		if (addDate == null) {
			addDate = new GregorianCalendar();
			expirationDate = new GregorianCalendar();
			expirationDate.add(Calendar.MONTH, 1);

		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAdBody() {
		return adBody;
	}

	public void setAdBody(String adBody) {
		this.adBody = adBody;
	}

	public Calendar getAddDate() {
		return addDate;
	}

	public void setAddDate(Calendar addDate) {
		this.addDate = addDate;
	}

	public Calendar getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Calendar expirationDate) {
		this.expirationDate = expirationDate;
	}

	public SiteUser getOwner() {
		return owner;
	}

	public void setOwner(SiteUser owner) {
		this.owner = owner;
	}

	public String getAdType() {
		return adType;
	}

	@Override
	public String toString() {
		return "" + addDate.getTime() + "expritation " + expirationDate.getTime();
	}

}

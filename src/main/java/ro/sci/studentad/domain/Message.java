package ro.sci.studentad.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 3, max = 30, message = "Message title must be between {min} and {max} long.")
	private String messageTitle;

	@Size(min = 10, max = 400, message = "Message must be between {min} and {max} long.")
	private String messageBody;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	private Calendar messageDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SENDER_ID")
	private SiteUser sender;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RECIVER_ID")
	private SiteUser reciver;

	private boolean senderVisibility;
	private boolean reciverisibility;

	@PrePersist
	protected void onCreate() {
		if (messageDate == null) {
			messageDate = new GregorianCalendar();

		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public Calendar getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Calendar messageDate) {
		this.messageDate = messageDate;
	}

	public SiteUser getSender() {
		return sender;
	}

	public void setSender(SiteUser sender) {
		this.sender = sender;
	}

	public SiteUser getReciver() {
		return reciver;
	}

	public void setReciver(SiteUser reciver) {
		this.reciver = reciver;
	}

	public boolean isSenderVisibility() {
		return senderVisibility;
	}

	public void setSenderVisibility(boolean senderVisibility) {
		this.senderVisibility = senderVisibility;
	}

	public boolean isReciverisibility() {
		return reciverisibility;
	}

	public void setReciverisibility(boolean reciverisibility) {
		this.reciverisibility = reciverisibility;
	}

}

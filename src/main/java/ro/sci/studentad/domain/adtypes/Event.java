package ro.sci.studentad.domain.adtypes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import ro.sci.studentad.domain.Ad;

@Entity
@DiscriminatorValue("Event")
public class Event extends Ad {

	@Column(name = "event_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Calendar eventDate;

	@Override
	@PrePersist
	protected void onCreate() {
		if (addDate == null) {
			addDate = new GregorianCalendar();
			expirationDate = eventDate;

		}
	}

	public Calendar getEventDate() {
		return eventDate;
	}

	public void setEventDate(Calendar eventDate) {
		this.eventDate = eventDate;
	}

}

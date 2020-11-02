package ro.sci.studentad.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "site_user")
public class SiteUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@Size(min = 2, max = 30, message = "First name must be between {min} and {max} long.")
	private String firstName;

	@Size(min = 2, max = 30, message = "Last name must be between {min} and {max} long.")
	private String lastName;

	@Column(unique = true)
	@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
			+ "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "{invalid.email}")
	private String email;

	// @Size(min = 6, max =12 , message = "Password must be between {min} and
	// {max} long.")
	private String password;

	@Past
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	// @NotNull(message = "{invalid.birthday}")
	private Calendar birthDate;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Please select a gender")
	private Gender gender;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	private Calendar userDateSignUp;

	private String role;

	@OneToMany(mappedBy = "sender")
	private List<Message> outbox;

	@OneToMany(mappedBy = "reciver")
	private List<Message> inbox;

	@OneToMany(mappedBy = "owner")
	private List<Ad> listOfUserAds;

	public SiteUser() {

	}

	public SiteUser(String firstName, String lastName, String email, String password, Calendar birthDate,
			Gender gender) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.gender = gender;

	}

	@PrePersist
	protected void onCreate() {
		if (userDateSignUp == null) {
			userDateSignUp = new GregorianCalendar();

		}

	}

	public List<Message> getOutbox() {
		return outbox;
	}

	public void setOutbox(List<Message> outbox) {
		this.outbox = outbox;
	}

	public List<Message> getInbox() {
		return inbox;
	}

	public void setInbox(List<Message> inbox) {
		this.inbox = inbox;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Calendar getUserDateSignUp() {
		return userDateSignUp;
	}

	public void setUserDateSignUp(Calendar userDateSignUp) {
		this.userDateSignUp = userDateSignUp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Ad> getListOfUserAds() {
		return listOfUserAds;
	}

	public void setListOfUserAds(List<Ad> listOfUserAds) {
		this.listOfUserAds = listOfUserAds;
	}

}

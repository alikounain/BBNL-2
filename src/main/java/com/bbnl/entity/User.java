package com.bbnl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(generator = "userId")
	@GenericGenerator(name = "userId",strategy = "com.bbnl.entity.generator.UserIdGenerator")
	@Column(name = "user_id", length = 100)
	private String userId;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false, length = 100)
	private String role;
	@Column(name = "sec_question")
	private String secQuestion;
	@Column(name = "sec_answer")
	private String secAnswer;
	@Column(name = "first_name", nullable = false, length = 100)
	private String firstName;
	@Column(name = "middle_name", length = 100)
	private String middleName;
	@Column(name = "last_name", nullable = false, length = 100)
	private String lastName;
	@Column(name = "email_id", nullable = false, length = 100)
	private String emailId;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false, length = 100)
	private String city;
	@Column(length = 1)
	@ColumnDefault("0")
	private byte status;
	@Column(name = "mobile_number")
	private Long mobileNumber;
	@Column(name = "is_locked")
	@ColumnDefault("false")
	private boolean isLocked;
	@Column(name = "unsuccessful_entry")
	@ColumnDefault("0")
	private int unsuccessfulEntry;

	public User() {
		super();
	}

	public User(String userId, String password, String role, String secQuestion, String secAnswer, String firstName,
			String middleName, String lastName, String emailId, String address, String city, byte status,
			Long mobileNumber, boolean isLocked, int unsuccessfulEntry) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.secQuestion = secQuestion;
		this.secAnswer = secAnswer;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.address = address;
		this.city = city;
		this.status = status;
		this.mobileNumber = mobileNumber;
		this.isLocked = isLocked;
		this.unsuccessfulEntry = unsuccessfulEntry;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSecQuestion() {
		return secQuestion;
	}

	public void setSecQuestion(String secQuestion) {
		this.secQuestion = secQuestion;
	}

	public String getSecAnswer() {
		return secAnswer;
	}

	public void setSecAnswer(String secAnswer) {
		this.secAnswer = secAnswer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public int getUnsuccessfulEntry() {
		return unsuccessfulEntry;
	}

	public void setUnsuccessfulEntry(int unsuccessfulEntry) {
		this.unsuccessfulEntry = unsuccessfulEntry;
	}
}

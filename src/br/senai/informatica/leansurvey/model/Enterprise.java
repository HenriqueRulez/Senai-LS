package br.senai.informatica.leansurvey.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Enterprise generated by hbm2java
 */
@Entity
@Table(name = "enterprise", catalog = "leansurvey")
public class Enterprise implements java.io.Serializable {

	private Long id;
	private String name;
	private String address;
	private String cnpj;
	private String logoPath;
	private String contactName;
	private String contactNumber;
	private String email;
	//private Set questionnaires = new HashSet(0);

	public Enterprise() {
	}

	public Enterprise(String name, String address, String cnpj, String logoPath, String contactName,
			String contactNumber, String email) {
		this.name = name;
		this.address = address;
		this.cnpj = cnpj;
		this.logoPath = logoPath;
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.email = email;
	}
/*
	public Enterprise(String name, String address, String cnpj, String logoPath, String contactName,
			String contactNumber, String email, Set questionnaires) {
		this.name = name;
		this.address = address;
		this.cnpj = cnpj;
		this.logoPath = logoPath;
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.questionnaires = questionnaires;
	}
*/
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "Name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Address", nullable = false, length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "CNPJ", nullable = false, length = 14)
	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "LogoPath", nullable = false, length = 130)
	public String getLogoPath() {
		return this.logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	@Column(name = "ContactName", nullable = false, length = 50)
	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Column(name = "ContactNumber", nullable = false, length = 15)
	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column(name = "Email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "enterprise")
	public Set getQuestionnaires() {
		return this.questionnaires;
	}

	public void setQuestionnaires(Set questionnaires) {
		this.questionnaires = questionnaires;
	}
*/
}

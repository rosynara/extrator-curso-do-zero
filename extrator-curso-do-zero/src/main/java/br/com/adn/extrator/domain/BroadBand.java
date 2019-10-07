package br.com.adn.extrator.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "BROADBAND_PLAN")
@SequenceGenerator(name = "SEQ_BROADBAND_PLAN", sequenceName = "SEQ_BROADBAND_PLAN")
public class BroadBand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true)
	private Long id;

	@Column(name = "MSISDN")
	private String msisdn;

	@Column(name = "PLAN")
	@Size(max = 100)
	private String plan;

	@Column(name = "CURRENT_CAMPAIGN")
	@Size(max = 100)
	private String currentCampaign;

	@Column(name = "PHONE")
	@Size(max = 20)
	private String phone;

	@Column(name = "CPF")
	@Size(max = 14)
	private String cpf;

	@Column(name = "NAME")
	@Size(max = 100)
	private String name;

	@Column(name = "CEP")
	@Size(max = 22)
	private String cep;

	@Column(name = "STATE")
	@Size(max = 2)
	private String state;

	@Column(name = "CITY")
	@Size(max = 50)
	private String city;

	@Column(name = "DISTRICT")
	@Size(max = 72)
	private String district;

	@Column(name = "ADDRESS_TYPE", length = 72)
	@Size(max = 72)
	private String addressType;

	@Column(name = "ADDRESS", length = 200)
	private String address;

	@Column(name = "COMPL1", length = 30)
	private String compl1;

	@Column(name = "NUM1", length = 5)
	private String num1;

	@Column(name = "COMPL2", length = 30)
	private String compl2;

	@Column(name = "NUM2", length = 5)
	private String num2;

	@Column(name = "COMPL3", length = 30)
	private String compl3;

	@Column(name = "NUM3", length = 5)
	private String num3;

	@Column(name = "BROADBAND_SPEED")
	private String broadbandSpeed;

	@Column(name = "BROADBAND_STATUS")
	private String broadbandStatus;

	@Column(name = "HOLDER_STATUS")
	private String holderStatus;

	@Column(name = "BUNDLE_STATUS")
	private String bundleStatus;

	@Column(name = "STATUS")
	private String status;

	@Temporal(TemporalType.DATE)
	@Column(name = "ACTIVATION_DATE")
	private Date activationDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "MIGRATION_DATE")
	private Date migrationDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "MIGRATION_PLAN_DATE")
	private Date migrationPlanDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "ADHESION_DATE")
	private Date adhesionDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFICATION_DATE")
	private Date modificationDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFICATION_STATUS_DATE")
	private Date modificationStatusDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFICATION_ADDRESS_DATE")
	private Date modificationAddressDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFICATION_SPEED_DATE")
	private Date modificationSpeedDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_MODIFICATION_DATE")
	private Date lastModificationDate;

	@Column(name = "ID_OI_TOTAL_DATA_PLAN", length = 30)
	private String oiTotalPlanId;

	@Column(name = "ID_TV_PLAN", length = 30)
	private String tvPlanId;

	@Column(name = "ID_DATA_PLAN", length = 30)
	private String dataPlanId;

	@Column(name = "ID_BENEFIT", length = 30)
	private String benefitId;

	
	public BroadBand()
	{
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getCurrentCampaign() {
		return currentCampaign;
	}

	public void setCurrentCampaign(String currentCampaign) {
		this.currentCampaign = currentCampaign;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompl1() {
		return compl1;
	}

	public void setCompl1(String compl1) {
		this.compl1 = compl1;
	}

	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getCompl2() {
		return compl2;
	}

	public void setCompl2(String compl2) {
		this.compl2 = compl2;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public String getCompl3() {
		return compl3;
	}

	public void setCompl3(String compl3) {
		this.compl3 = compl3;
	}

	public String getNum3() {
		return num3;
	}

	public void setNum3(String num3) {
		this.num3 = num3;
	}

	public String getBroadbandSpeed() {
		return broadbandSpeed;
	}

	public void setBroadbandSpeed(String broadbandSpeed) {
		this.broadbandSpeed = broadbandSpeed;
	}

	public String getBroadbandStatus() {
		return broadbandStatus;
	}

	public void setBroadbandStatus(String broadbandStatus) {
		this.broadbandStatus = broadbandStatus;
	}

	public String getHolderStatus() {
		return holderStatus;
	}

	public void setHolderStatus(String holderStatus) {
		this.holderStatus = holderStatus;
	}

	public String getBundleStatus() {
		return bundleStatus;
	}

	public void setBundleStatus(String bundleStatus) {
		this.bundleStatus = bundleStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Date getMigrationDate() {
		return migrationDate;
	}

	public void setMigrationDate(Date migrationDate) {
		this.migrationDate = migrationDate;
	}

	public Date getMigrationPlanDate() {
		return migrationPlanDate;
	}

	public void setMigrationPlanDate(Date migrationPlanDate) {
		this.migrationPlanDate = migrationPlanDate;
	}

	public Date getAdhesionDate() {
		return adhesionDate;
	}

	public void setAdhesionDate(Date adhesionDate) {
		this.adhesionDate = adhesionDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Date getModificationStatusDate() {
		return modificationStatusDate;
	}

	public void setModificationStatusDate(Date modificationStatusDate) {
		this.modificationStatusDate = modificationStatusDate;
	}

	public Date getModificationAddressDate() {
		return modificationAddressDate;
	}

	public void setModificationAddressDate(Date modificationAddressDate) {
		this.modificationAddressDate = modificationAddressDate;
	}

	public Date getModificationSpeedDate() {
		return modificationSpeedDate;
	}

	public void setModificationSpeedDate(Date modificationSpeedDate) {
		this.modificationSpeedDate = modificationSpeedDate;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public String getOiTotalPlanId() {
		return oiTotalPlanId;
	}

	public void setOiTotalPlanId(String oiTotalPlanId) {
		this.oiTotalPlanId = oiTotalPlanId;
	}

	public String getTvPlanId() {
		return tvPlanId;
	}

	public void setTvPlanId(String tvPlanId) {
		this.tvPlanId = tvPlanId;
	}

	public String getDataPlanId() {
		return dataPlanId;
	}

	public void setDataPlanId(String dataPlanId) {
		this.dataPlanId = dataPlanId;
	}

	public String getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(String benefitId) {
		this.benefitId = benefitId;
	}


	@Override
	public String toString() {
		return String.format(
				"Broadband [id=%s, msisdn=%s, plan=%s, currentCampaign=%s, phone=%s, cpf=%s, name=%s, cep=%s, state=%s, city=%s, district=%s, addressType=%s, address=%s, compl1=%s, num1=%s, compl2=%s, num2=%s, compl3=%s, num3=%s, broadbandSpeed=%s, broadbandStatus=%s, holderStatus=%s, bundleStatus=%s, status=%s, activationDate=%s, migrationDate=%s, migrationPlanDate=%s, adhesionDate=%s, modificationDate=%s, modificationStatusDate=%s, modificationAddressDate=%s, modificationSpeedDate=%s, lastModificationDate=%s, oiTotalPlanId=%s, tvPlanId=%s, dataPlanId=%s, benefitId=%s]",
					id, msisdn, plan, currentCampaign, phone, cpf, name, cep, state, city, district, addressType, address,
					compl1, num1, compl2, num2, compl3, num3, broadbandSpeed, broadbandStatus, holderStatus, bundleStatus,
					status, activationDate, migrationDate, migrationPlanDate, adhesionDate, modificationDate,
					modificationStatusDate, modificationAddressDate, modificationSpeedDate, lastModificationDate,
					oiTotalPlanId, tvPlanId, dataPlanId, benefitId);
	}

	
}



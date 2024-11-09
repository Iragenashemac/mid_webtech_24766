package model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;


@Entity
@Table(name = "membership")
public class Membership {
    @Id
    @GeneratedValue
    private UUID membershipId;

    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @Temporal(TemporalType.DATE)
    private Date expiringTime;

    @Column(nullable = false)
    private String membershipCode;

    @Enumerated(EnumType.STRING)
    private Status membershipStatus;

    @ManyToOne
    @JoinColumn(name = "membership_type_id")
    private MembershipType membershipType;

	public UUID getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(UUID membershipId) {
		this.membershipId = membershipId;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getExpiringTime() {
		return expiringTime;
	}

	public void setExpiringTime(Date expiringTime) {
		this.expiringTime = expiringTime;
	}

	public String getMembershipCode() {
		return membershipCode;
	}

	public void setMembershipCode(String membershipCode) {
		this.membershipCode = membershipCode;
	}

	public Status getMembershipStatus() {
		return membershipStatus;
	}

	public void setMembershipStatus(Status membershipStatus) {
		this.membershipStatus = membershipStatus;
	}

	public MembershipType getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(MembershipType membershipType) {
		this.membershipType = membershipType;
	}


}


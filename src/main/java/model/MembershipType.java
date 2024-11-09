package model;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "membership_type")
public class MembershipType {
    @Id
    @GeneratedValue
    private UUID membershipTypeId;

    private String membershipName;
    private int maxBooks;
    private int price;
	public UUID getMembershipTypeId() {
		return membershipTypeId;
	}
	public void setMembershipTypeId(UUID membershipTypeId) {
		this.membershipTypeId = membershipTypeId;
	}
	public String getMembershipName() {
		return membershipName;
	}
	public void setMembershipName(String membershipName) {
		this.membershipName = membershipName;
	}
	public int getMaxBooks() {
		return maxBooks;
	}
	public void setMaxBooks(int maxBooks) {
		this.maxBooks = maxBooks;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


}
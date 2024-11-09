package model;

import java.util.UUID;

import javax.persistence.*;


@Entity
@Table(name = "shelf")
public class Shelf {
    @Id
    @GeneratedValue
    private UUID shelfId;

    private String bookCategory;
    private int availableStock;
    private int borrowedNumber;
    private int totalStock;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

	public UUID getShelfId() {
		return shelfId;
	}

	public void setShelfId(UUID shelfId) {
		this.shelfId = shelfId;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public int getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
	}

	public int getBorrowedNumber() {
		return borrowedNumber;
	}

	public void setBorrowedNumber(int borrowedNumber) {
		this.borrowedNumber = borrowedNumber;
	}

	public int getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}


}

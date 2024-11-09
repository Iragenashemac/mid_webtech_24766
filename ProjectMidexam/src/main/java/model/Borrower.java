package model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "borrower")
public class Borrower {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Temporal(TemporalType.DATE)
    private Date borDate;

    @Temporal(TemporalType.DATE)
    private Date pickupDate;

    private int fine;
    private int lateChargeFees;
    private int returnId;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public Date getBorDate() { return borDate; }
    public void setBorDate(Date borDate) { this.borDate = borDate; }
    public Date getPickupDate() { return pickupDate; }
    public void setPickupDate(Date pickupDate) { this.pickupDate = pickupDate; }
    public int getFine() { return fine; }
    public void setFine(int fine) { this.fine = fine; }
    public int getLateChargeFees() { return lateChargeFees; }
    public void setLateChargeFees(int lateChargeFees) { this.lateChargeFees = lateChargeFees; }
    public int getReturnId() { return returnId; }
    public void setReturnId(int returnId) { this.returnId = returnId; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}

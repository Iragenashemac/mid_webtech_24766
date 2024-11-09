package model;



import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    private UUID bookId;

    @Column(nullable = false)
    private String title;

    private String isbnCode;
    private int edition;
    private String publisherName;

    @Temporal(TemporalType.DATE)
    private Date publicationYear;

    @Enumerated(EnumType.STRING)
    private BookStatus bookOrderStatus;

    @ManyToOne
    @JoinColumn(name = "shelf_id", nullable = true)
    private Shelf shelf;

	public UUID getBookId() {
		return bookId;
	}

	public void setBookId(UUID bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbnCode() {
		return isbnCode;
	}

	public void setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public Date getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Date publicationYear) {
		this.publicationYear = publicationYear;
	}

	public BookStatus getBookOrderStatus() {
		return bookOrderStatus;
	}

	public void setBookOrderStatus(BookStatus bookOrderStatus) {
		this.bookOrderStatus = bookOrderStatus;
	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}


}

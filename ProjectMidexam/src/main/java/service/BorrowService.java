package service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class BorrowService {

    private static final BigDecimal DAILY_FINE_AMOUNT = new BigDecimal("20"); // 20 Rwf per day

    private final BorrowRecordRepository borrowRecordRepository;
    private final MembershipTypeRepository membershipTypeRepository;
    private final BookRepository bookRepository;

    public BorrowService(BorrowRecordRepository borrowRecordRepository,
                         MembershipTypeRepository membershipTypeRepository,
                         BookRepository bookRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.membershipTypeRepository = membershipTypeRepository;
        this.bookRepository = bookRepository;
    }

    // Librarian-specific functionality to check overdue books and apply fines
    public void applyAutomaticFines() {
        List<BorrowRecord> overdueRecords = getOverdueBorrowRecords();
        for (BorrowRecord record : overdueRecords) {
            LocalDate dueDate = record.getDueDate();
            long daysLate = ChronoUnit.DAYS.between(dueDate, LocalDate.now());

            // Calculate the fine based on days late and apply it if it’s greater than zero
            if (daysLate > 0) {
                BigDecimal totalFine = DAILY_FINE_AMOUNT.multiply(BigDecimal.valueOf(daysLate));
                record.setFine(totalFine);
                borrowRecordRepository.save(record); // Save updated record with applied fine
            }
        }
    }

    // Method to get overdue records for librarian use
    public List<BorrowRecord> getOverdueBorrowRecords() {
        LocalDate today = LocalDate.now();
        return borrowRecordRepository.findByDueDateBeforeAndReturnDateIsNull(today);
    }

    // Librarian assigns books to shelves
    public void assignBookToShelf(Book book, Shelf shelf) {
        book.setShelf(shelf);
        bookRepository.save(book); // Save book with updated shelf assignment
    }

    // Librarian counts total books in a room
    public int countBooksInRoom(Room room) {
        return bookRepository.countByRoom(room);
    }
}

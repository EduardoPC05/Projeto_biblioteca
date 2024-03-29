package Model.Entity;

import java.time.LocalDate;

public class Loan implements Comparable<Loan>{
    private User bailee;
    private Book borrowed;
    private LocalDate acquiredDate;
    private LocalDate returnDate;

    public Loan(User bailee, Book book, LocalDate acquiredDate,
                LocalDate returnDate) {
        if (setBook(book) && setUser(bailee) && setDates(acquiredDate,
                returnDate)) {
            borrowed.setBorrow();
        }
    }
    public Boolean isDelayed(){
        return getReturnDate().isBefore(LocalDate.now());
    }

    public User getBailee() {
        return bailee;
    }

    public Book getBook() {
        return borrowed;
    }

    public LocalDate getAcquiredDate() {
        return acquiredDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
    private Boolean setBook(Book book){
        if (book.isAvailable()){
            this.borrowed = book;
            return true;
        }
        return false;
    }
    private Boolean setUser(User user){
        if (user.getPenalty() == 0){
            this.bailee = user;
            return true;
        }
        return false;
    }
    private Boolean setDates(LocalDate acquiredDate, LocalDate returnDate){
        if (acquiredDate.isBefore(returnDate)){
            this.acquiredDate = acquiredDate;
            this.returnDate = returnDate;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return this.bailee.equals(loan.bailee) &&
                this.borrowed.equals(loan.borrowed) &&
                this.acquiredDate.getDayOfYear() == loan.acquiredDate.getDayOfYear() && this.acquiredDate.getYear() == loan.acquiredDate.getYear();
    }

    @Override
    public int compareTo(Loan loan){
        if (this.equals(loan)) return 0;
        if (this.borrowed.equals(loan.borrowed)){
            return this.acquiredDate.compareTo(loan.acquiredDate);
        }
        return this.borrowed.compareTo(loan.borrowed);
    }
}
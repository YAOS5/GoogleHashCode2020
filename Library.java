import java.util.*;


class Library {
  int id;
  LibraryState state;
  int signUpDays;
  int scanPerDay;
  boolean isSignedUp;
  HashSet<Book> books;
  ArrayList<Book> scannedBooks;


  public Library(int id, int signUpDays, int scanPerDay, HashSet<Book> books) {
    this.id = id;
    this.signUpDays = signUpDays;
    this.scanPerDay = scanPerDay;
    this.books = books;

    this.isSignedUp = false;
    this.scannedBooks = new ArrayList<>();
    this.state = LibraryState.NOT_SIGNED_UP;
  }


}

import java.util.*;


class Library {
  int id;
  LibraryState state;
  int signUpDays;
  int daysLeftSignUpComplete;
  int scanPerDay;
  boolean isSignedUp;
  ArrayList<Book> booksLeft;
  ArrayList<Book> scannedBooks;
  ArrayList<Book> isScanning;


  public Library(int id, int signUpDays, int scanPerDay, ArrayList<Book> booksLeft) {
    this.id = id;
    this.signUpDays = signUpDays;
    this.scanPerDay = scanPerDay;
    this.booksLeft = booksLeft;

    this.isSignedUp = false;
    this.scannedBooks = new ArrayList<>();
    this.state = LibraryState.NOT_SIGNED_UP;

    this.daysLeftSignUpComplete = signUpDays;
    this.isScanning = new ArrayList<>();
  }


  public void scan() {
    if (this.state == LibraryState.COMPLETE)
      return;

    this.state = LibraryState.SCANNING_BOOKS;
    // scan as many books as I can for now
    int booksToScan = Math.min(scanPerDay, booksLeft.size());
    for (int i = 0; i < booksToScan; i++) {
        Book book = booksLeft.remove(booksLeft.size() - 1);

        book.state = BookState.SCANNING;
        isScanning.add(book);
    }
  }

  public void signUp() {
    this.state = LibraryState.SIGNING_UP;
  }

  public void nextDay() {
    if (this.state == LibraryState.SIGNING_UP) {
        daysLeftSignUpComplete--;

        if (daysLeftSignUpComplete == 0) {
          this.state = LibraryState.SCANNING_BOOKS;
        }
        return;

    }

    if (this.state == LibraryState.COMPLETE) {
      return;
    }

    if (this.state == LibraryState.SCANNING_BOOKS) {

      if (isScanning.size() != 0) {
        // add the books from yesterday to scanned
        scannedBooks.addAll(isScanning);
        isScanning.clear();
      }

      if (booksLeft.size() == 0) {
        this.state = LibraryState.COMPLETE;
        return;
      }

      this.scan();
    }
  }

}

class Book implements Comparable<Book> {
  int id;
  int score;
  BookState state;

  public Book(int id, int score){
    this.id = id;
    this.score = score;
    state = BookState.UNSCANNED;
  }

  public int compareTo(Book b)
      {
        // need the books with the smallest score to come first
        return this.score - b.score;
      }
}

class Book {
  int id;
  int score;
  BookState state;

  public Book(int id, int score) {
    this.id = id;
    this.score = score;
    state = BookState.UNSCANNED;
  }


}

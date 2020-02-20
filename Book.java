import java.util.ArrayList;
import java.util.*;
import java.util.Iterator;


class Book implements Comparable<Book> {
  int id;
  int score;
  int noLibs;
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

  public void calcNoLibs(HashSet<Library> libs) {

    int noLibs=0;
    Iterator<Library> it = libs.iterator();

    while(it.hasNext()){
      Library lib = it.next();

      if (lib.hasBook(this)) {
        noLibs++;
      }

      this.noLibs = noLibs;
    }

  }
}

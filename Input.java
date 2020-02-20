import java.util.*;
import java.io.File;  // Import the File class
import java.nio.charset.StandardCharsets;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList; // import the ArrayList class
import java.io.FileWriter;   // Import the FileWriter class
import java.util.HashSet;
import java.nio.file.Files;
import java.nio.file.Paths;

class Input {

  static int noBooks, noDays, noLibs;
  static HashSet <Book> books = new HashSet<>();
  static ArrayList <Book> booksArrayList = new ArrayList<>();
  static HashSet <Library> libs = new HashSet<>();


  public static void read() throws IOException {
    // path specified(CHANGE THIS IN YOUR MACHINE)
    String path = "/Users/shivam/Documents/GitHub/HashCode20/d.txt";
    // file to string
    String content = Files.readString(Paths.get(path), StandardCharsets.US_ASCII);
    // store them line by line
    String[] lines = content.split("\\r?\\n");

    String[] firstLine = lines[0].split(" ");

    noBooks = Integer.parseInt(firstLine[0]);
    noDays = Integer.parseInt(firstLine[2]);
    noLibs = Integer.parseInt(firstLine[1]);
    String[] secondLine = lines[1].split(" ");

    for(int i = 0; i < noBooks; i++)
    {
      Book temp = new Book(i, Integer.parseInt(secondLine[i]));
      books.add(temp);
      booksArrayList.add(temp);
    }

    int indexLib = 0;
    for(int i = 2; i < lines.length; i = i+2)
    {
      String[] libDesc = lines[i].split(" ");
      String[] booksDesc = lines[i+1].split(" ");
      int libBooks = Integer.parseInt(libDesc[0]);
      int signupTime = Integer.parseInt(libDesc[1]);
      int shipPerDay = Integer.parseInt(libDesc[2]);
      ArrayList<Book> booksContained = new ArrayList<>();
      for(int j = 0; j < booksDesc.length; j++)
      {
        Book temp = booksArrayList.get(Integer.parseInt(booksDesc[j]));
        booksContained.add(temp);
      }
      Library lib = new Library(indexLib, signupTime, shipPerDay, booksContained);
      libs.add(lib);
      indexLib++;
    }

    for(Book temp: books){
      temp.calcNoLibs();
    }

    Iterator<Library> it = libs.iterator();

    while(it.hasNext()){
      Library lib = it.next();

      lib.calcL();
    }

  }

  public static GoogleBooks getGoogleBooks()
  {
    GoogleBooks gBooks = new GoogleBooks(noDays,books,libs);
    return gBooks;
  }



}

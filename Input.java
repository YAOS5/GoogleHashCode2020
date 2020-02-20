class Input {

  int noBooks, noDays, noLibs;
  ArrayList <Book> books = new ArrayList<>();
  ArrayList <Library> libs = new ArrayList<>();


  public static void read() {
    // path specified(CHANGE THIS IN YOUR MACHINE)
    String path = "/Users/shivam/Documents/GitHub/HashCode20/a_example.txt";
    // file to string
    String content = Files.readString(path, StandardCharsets.US_ASCII);
    // store them line by line
    String[] lines = content.split("\\r?\\n");

    String[] firstLine = lines[0].split(" ");

    noBooks = firstLine[0];
    noDays = firstLine[2];
    noLibs = firstLine[1];
    String[] secondLine = lines[1].split(" ");

    for(int i = 0; i < noBooks; i++)
    {
      Book temp = new Book(Integer.parseInt(secondLine[i]), i);
      books.add(temp);
    }
    int indexLib = 0;
    for(int i = 2; i < lines.length; i = i+2)
    {
      String[] libDesc = lines[i].split(" ");
      String[] booksDesc = lines[i+1].split(" ");
      int libBooks = libDesc[0];
      int signupTime = libDesc[1];
      int shipPerDay = libDesc[2];
      ArrayList<Books> booksContained = new ArrayList<>();
      for(int j = 0; j < booksDesc.length; j++)
      {
        Book temp = books.get(Integer.parseInt(booksDesc[j]));
        booksContained.add(temp);
      }
      Library lib = new Library(indexLib, signupTime, shipPerDay, booksContained);
      index++;
    }
  }

  

}

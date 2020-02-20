
import java.util.ArrayList;
import java.io.IOException;  // Import the IOException class to handle errors

public class Main {

    public static void main(String[] args) throws IOException {

      Input.read();
      GoogleBooks googleBooks = Input.getGoogleBooks();

      ArrayList<Library> libraries = googleBooks.operate();
      output.outputToFile(libraries);
    }
}

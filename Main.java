
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
      Input.read();
      GoogleBooks googleBooks = Input.getGoogleBooks();

      ArrayList<Library> libraries = googleBooks.operate();
      Output.outputToFile(libraries);
    }
}

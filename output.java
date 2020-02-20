import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList; // import the ArrayList class
import java.io.FileWriter;   // Import the FileWriter class
import java.util.HashSet;

public class output {



//     public static void main(String[] args) {
//         ArrayList<Library> libraries=new ArrayList<Library>();
//
//         Library s = new Library(100, 20,20, new HashSet<Book>());
//         s.scannedBooks.add(new Book(0, 5));
//         s.scannedBooks.add(new Book(1,10));
//
//
//         Library s2 = new Library(200, 20,20, new HashSet<Book>());
//         s2.scannedBooks.add(new Book(2, 5));
//         s2.scannedBooks.add(new Book(3,11));
//
//
//         libraries.add(s);
//         libraries.add(s2);
//         outputToFile(libraries);
//     }



    public static void outputToFile(ArrayList<Library> libraries ) {



        int noOfLib = libraries.size();




        String lineTwo = "";

        // String lineThree = "";

        for (Library library : libraries) {
            if (library.scannedBooks.size() == 0){
              noOfLib--;
              continue;
            }

            lineTwo += String.valueOf(library.id);
            lineTwo += " ";

            lineTwo += String.valueOf(library.scannedBooks.size());
            lineTwo += "\n";

            for (Book book: library.scannedBooks){
                lineTwo += book.id;
                lineTwo += " ";
            }
            lineTwo = lineTwo.substring(0, lineTwo.length() - 1);
            lineTwo += "\n";


        }
        lineTwo = lineTwo.trim();




//        Create file
        try {
            File myObj = new File("submission.out");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


//      Write to file.
        try {
            FileWriter myWriter = new FileWriter("submission.out");
            String lineOne = String.valueOf(noOfLib);
            lineOne += "\n";
            myWriter.write(lineOne);
            myWriter.write(lineTwo);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}

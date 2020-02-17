import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList; // import the ArrayList class
import java.io.FileWriter;   // Import the FileWriter class

public class output {

//     public static void main(String[] args) {
//         ArrayList<Integer> list=new ArrayList<Integer>();
//         list.add(1);
//         list.add(5);
//         outputToFile(list);
//     }



    public static void outputToFile(ArrayList<Server> results ) {



        String lineTwo = "";
        int counter = 0;

        for (Server server : results) {
            if (server.videosStored.size() > 0){
                counter+=1;
                lineTwo+= server.id;
                for (Video v: videosStored ){
                    lineTwo += " ";
                    lineTwo += v.id;

                }
                lineTwo += "\n";
            }
        }

        String lineOne = String.valueOf(counter);

        lineOne += "\n";



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
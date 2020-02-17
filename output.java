import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList; // import the ArrayList class
import java.io.FileWriter;   // Import the FileWriter class
import java.util.HashSet;

public class output {



//     public static void main(String[] args) {
//         ArrayList<Server> servers=new ArrayList<Server>();
//
//         Server s = new Server(0, 20);
//         s.addVideo(new Video(0, 5));
//         s.addVideo(new Video(1,10));
//
//
//         Server s2 = new Server(0, 20);
//         s2.addVideo(new Video(2, 5));
//         s2.addVideo(new Video(3,10));
//
//
//         servers.add(s);
//         servers.add(s2);
//         outputToFile(servers);
//     }



    public static void outputToFile(ArrayList<Server> results ) {



        String lineTwo = "";
        int counter = 0;

        for (Server server : results) {
            if (server.videoStored.size() > 0){
                counter+=1;
                lineTwo+= server.id;
                for (Video v: server.videoStored ){
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
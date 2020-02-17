import java.util.ArrayList;

public class combinations {

    public static ArrayList<PQObject> createCombinations(ArrayList<Server> servers,  ArrayList<Video> videos, ArrayList<EndPoint> endpoints ) {

        ArrayList<PQObject> output = new ArrayList<PQObject>();

        for (Server server : servers){
            for (Video video : videos ){
                output.add( new PQObject(server, video, endpoints));
            }
        }
        
        return output;

    }


}

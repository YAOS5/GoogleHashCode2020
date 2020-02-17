import java.util.HashMap;


class EndPoint {
  HashMap<Video, Integer> requests = new HashMap<>();
  HashMap<Server, Integer> latencyMap = new HashMap<>();
  int id;

  public EndPoint(int id) {
    this.id = id;
  }

  boolean vidInE(Video v) {
    return requests.keySet().contains(v);
  }
}

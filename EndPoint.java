import java.util.HashMap;


class EndPoint {
  HashMap<Video, Integer> requests = new HashMap<>();
  HashMap<Server, Integer> latencyMap = new HashMap<>();
  int id;
  int dataCenterLatency;

  public EndPoint(int id, int dataCenterLatency) {
    this.id = id;
    this.dataCenterLatency = dataCenterLatency;
  }

  boolean vidInE(Video v) {
    return requests.keySet().contains(v);
  }
}

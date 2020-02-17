import java.util.HashSet;


class Server {
  HashSet<EndPoint> endpoints;
  int capacityLeft;
  HashSet<Video> videoStored;

  public Server(int capacity) {
    this.capacityLeft = capacity;
    endpoints = new HashSet<>();
    videoStored = new HashSet<>();
  }

  boolean addVideo(Video video) {
    if (capacityLeft <= 0)
      throw new IllegalArgumentException("This server shouldn't be available.");

    if (video.size > capacityLeft)
      return false;

    capacityLeft -= video.size;
    videoStored.add(video);

    return true;
  }
}

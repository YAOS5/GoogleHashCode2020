import java.util.HashSet;


class Server {
  int id;
  HashSet<EndPoint> endpoints;
  int capacityLeft;
  HashSet<Video> videoStored;

  public Server(int id, int capacity) {
    this.id = id;
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

  boolean isAvailable() {
    return this.capacityLeft > 0;
  }
}

import java.util.ArrayList;
import java.io.*;
import java.util.*;


class PQObject implements Comparable<PQObject>{
  Server server;
  Video video;
  int TS = -1;
  ArrayList<EndPoint> endpoints;

  public PQObject(Server s, Video v, ArrayList<EndPoint> endpoints) {
    this.server = s;
    this.video = v;
    this.endpoints = endpoints;
    updateTS();
  }

  public int compareTo(PQObject p)
    {
        return -(this.TS - p.TS);
    }

  public void updateTS() {
    // checking if the server is actually available
    if (!server.isAvailable()) {
      TS = -1;
      return;
    }

    TS = 0;
    for (EndPoint e: endpoints) {
      if (e.vidInE(video) && server.endpoints.contains(e)) {
        TS += e.dataCenterLatency - e.latencyMap.get(server);
      }
    }
  }


}

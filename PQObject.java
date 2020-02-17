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
  }

  public int compareTo(PQObject p) 
    {
        return -(this.TS - p.TS);
    }


}

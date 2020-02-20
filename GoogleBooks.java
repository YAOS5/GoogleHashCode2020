import java.util.ArrayList;
import java.util.*;
import java.util.Iterator;

public class GoogleBooks {

  public int maxDays;
  public int currDay;

  Library libSigningUp;

  HashSet<Book> books;
  HashSet<Library> unSignedUpLibs;
  HashSet<Library> libs;
  ArrayList<Library> signedUpLibs;

  public GoogleBooks(int maxDays, HashSet<Book> books, HashSet<Library> libraries) {
    this.maxDays = maxDays;
    this.currDay = 0;
    this.libSigningUp = null;
    this.books = books;
    this.libs = libraries;
    this.signedUpLibs = new ArrayList<Library>();
    this.unSignedUpLibs = (HashSet)libraries.clone();
  }

  public Library getBestNextLib(HashSet<Library> libs) {

    Library bestLib=null;
    double bestLibMetric = 0;

    Iterator<Library> it = libs.iterator();

    while(it.hasNext()){
      Library lib = it.next();

      if (lib.state == LibraryState.NOT_SIGNED_UP) {
        int daysLeft = this.maxDays-this.currDay-lib.signUpDays;

        if (daysLeft<0) {
          daysLeft=0;
        }
        double metric = lib.metric(daysLeft);

        if (metric>=bestLibMetric) {
          bestLib = lib;
        }
      }
    }

    return bestLib;
  }

  public ArrayList<Library> operate() {

    while(currDay<maxDays) {

      Library nextLib;

      if (libSigningUp != null) {
        if (libSigningUp.state == LibraryState.SCANNING_BOOKS) {
          this.signedUpLibs.add(libSigningUp);
          libSigningUp = null;
        }
      }

      if (libSigningUp == null) {
        nextLib = this.getBestNextLib(this.unSignedUpLibs);
        unSignedUpLibs.remove(nextLib);
        nextLib.signUp();
      }

      for (Library lib: signedUpLibs) {
        lib.nextDay();
      }
    }

    return this.signedUpLibs;

  }


}

import java.util.ArrayList;
import java.util.*;
import java.util.Iterator;

public class GoogleBooks {

  public int maxDay;
  public int currDay;

  Library libSigningUp;

  HashSet<Book> books;
  HashSet<Library> unscannedLibs;
  HashSet<Library> libs;
  ArrayList<Library> signedUpLibs

  GoogleBooks(int maxDay, HashSet<Book> books, HashSet<Library> libraries) {
    this.maxDay = maxDay;
    this.currDay = 0;
    this.libSigningUp = null;
    this.books = books;
    this.libs = libraries;
    this.scannedLibs = new ArrayList<Library>();
    this.unscannedLibs = libraries.clone();
  }

  public Library getBestNextLib(HashSet<Library> libs) {

    Iterator<Library> it = libs.iterator();

    while(it.hasNext()){
      Library lib = it.next();

      if (lib.LibState == NOT_SIGNEDUP) {
        return lib.next();
      }
    }

  }

  public ArrayList<Library> operate() {

    while(currDay<maxDay) {

      Library nextLib;

      if (libSigningUp != null) {
        if (libSigningUp.LibState == SCANNING_BOOK) {
          signedUpLibs.add(libSigningUp);
          libSigningUp = null;
        }
      }

      if (libSigningUp == null) {
        nextLib = this.getBestNextLib(this.unscannedLibs);
        unscannedLibs.remove(nextLib);
        nextLib.signUp();
      }

      for (Library lib: signedUpLibs) {
        lib.nextDay();
      }
    }

    return this.signedUpLibs;

  }


}

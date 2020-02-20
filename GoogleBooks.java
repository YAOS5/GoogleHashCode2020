import java.util.ArrayList;
import java.util.*;
import java.util.Iterator;

public class GoogleBooks {

  public int maxDay;
  public int currDay;

  Library libSigningUp;

  HashSet<Book> books;
  HashSet<Library> unSignedUpLibs;
  HashSet<Library> libs;
  ArrayList<Library> signedUpLibs;

  public GoogleBooks(int maxDay, HashSet<Book> books, HashSet<Library> libraries) {
    this.maxDay = maxDay;
    this.currDay = 0;
    this.libSigningUp = null;
    this.books = books;
    this.libs = libraries;
    this.signedUpLibs = new ArrayList<Library>();

    this.unSignedUpLibs = (HashSet)libraries.clone();
    System.out.println("libraries in constructor" + libraries);
    System.out.println("unSignedUpLibs in constructor" + unSignedUpLibs);
  }

  public Library getBestNextLib(HashSet<Library> libs) {

    Library resultLib=null;
    Iterator<Library> it = libs.iterator();

    while(it.hasNext()){
      Library lib = it.next();

      if (lib.state == LibraryState.NOT_SIGNED_UP) {
        resultLib = lib;
        break;
      }
    }

    return resultLib;
  }

  public ArrayList<Library> operate() {

    while(currDay<maxDay) {

      Library nextLib;
      if (libSigningUp != null) {
        System.out.println("uvin1" + libSigningUp.state);

        if (libSigningUp.state == LibraryState.SCANNING_BOOKS) {
          System.out.println("uvin");
          signedUpLibs.add(libSigningUp);
          System.out.println(this.signedUpLibs.size());
          libSigningUp = null;
        }
      }

      if (libSigningUp == null) {
        nextLib = this.getBestNextLib(this.unSignedUpLibs);

        if (nextLib != null){
          nextLib.signUp();
          unSignedUpLibs.remove(nextLib);
          libSigningUp = nextLib;

        }

      }

      System.out.println("signeduplibs" + this.signedUpLibs);

      //Update all signing up and scanning books libs
      if (libSigningUp != null) {
        libSigningUp.nextDay();
      }
      
      for (Library lib: this.signedUpLibs) {
        System.out.println("next day is called");
        lib.nextDay();
      }
      currDay++;
    }

    System.out.println(this.signedUpLibs.size());
    return this.signedUpLibs;

  }


}

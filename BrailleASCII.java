import java.io.File;
import java.io.FileInputStream;

public class BrailleASCII {
  public static void main(String[] args){
    BrailleASCIITables bat = new BrailleASCIITables();
    if(args[0].equals("braille")){
      String s = "";
      char c;
      for(int i = 0; i < args[1].length(); i++){
        c = args[1].charAt(i);
        s += BrailleASCIITables.toBraille(c);
      }
      System.out.println(s);
    }
  }
}

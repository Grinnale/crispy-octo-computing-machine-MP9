import java.io.PrintWriter;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;


public class BrailleASCIITables {
  static InputStream toBraille;
  static InputStream toASCII;
  static InputStream toUnicode;

  public BrailleASCIITables(){
    try{
      File f = new File("Braille2ASCII.txt");
      String s = "";
      Scanner scan = new Scanner(f);
      while(scan.hasNextLine()){
        s += scan.nextLine() + "\n";
      }
      toASCII = new StringInputStream(s);
      scan.close();
    }
    catch(Exception e){
      System.out.println("File not found");
    }

    try{
      File f = new File("ASCII2Braille.txt");
      String s = "";
      Scanner scan = new Scanner(f);
      while(scan.hasNextLine()){
        s += scan.nextLine() + "\n";
      }
      toBraille = new StringInputStream(s);
      scan.close();
    }
    catch(Exception e){
      System.out.println("File not found");
    }

    try{
      File f = new File("Braille2Unicode.txt");
      String s = "";
      Scanner scan = new Scanner(f);
      while(scan.hasNextLine()){
        s += scan.nextLine() + "\n";
      }
      toUnicode = new StringInputStream(s);
      scan.close();
    }
    catch(Exception e){
      System.out.println("File not found");
    }
  }

  public static String toBraille(char c){
    try{
      BitTree bt = new BitTree(8);
      bt.load(toBraille);
      int n = c;
      String s = "";
      for(int i = 0; i < 8; i++){
        if(n % 2 == 0){
          s = "0" + s;
        }
        else{
          s = "1" + s;
          n--;
        }
        n = n/2;
      }
      System.out.println(s);
      return bt.get(s);
    }
    catch(Exception e){

    }
    return null;
  }

  public static String toASCII(String str){
    try{
      BitTree bt = new BitTree(6);
      bt.load(toASCII);
      String s = "";
      for(int i = 0; i < str.length(); i+=6){
        s += bt.get(str.substring(i, i+6));
      }
      return s;
    }
    catch(Exception e){

    }
    return null;
  }

  public static String toUnicode(String str){
    try{
      int i = Integer.decode("0x" + str);
      System.err.println(Character.toChars(i));
    }
    catch(Exception e){

    }
    return null;
  }
}

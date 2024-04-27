import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class BitTree {
  int strLen;
  BitTreeNode root;

  public BitTree(int n){
    this.strLen = n;
    root = new BitTreeNode();
  }

  public BitTreeNode iterate(String bits, boolean set) throws Exception{
    if(bits.length() != this.strLen){
      throw new Exception();
    }
    BitTreeNode cur = root;
    char c;
    for(int i = 0; i < strLen; i++){
      c = bits.charAt(i);
      if(cur.get(c) == null){
        if(set == false){
          throw new Exception();
        }
        cur = cur.birth(c);
      }
      else{
        cur = cur.get(c);
      }
    }
    return cur;
  }

  public void set(String bits, String value) throws Exception{
    BitTreeNode cur = this.iterate(bits, true);
    cur.set(value);
  }

  public String get(String bits) throws Exception{
    BitTreeNode cur = this.iterate(bits, false);
    return cur.getValue();
  }

  public void load(InputStream source) throws Exception{
    Scanner scan = new Scanner(source);
    String bits;
    String value;
    String next;
    while(scan.hasNextLine()){
      next = scan.nextLine();
      bits = next.substring(0, strLen);
      value = next.substring(strLen + 1, next.length());
      set(bits, value);
    }
    scan.close();
  }

  public void dump(PrintWriter pen) throws Exception{
    dumpHelper(pen, root, "");
  }

  public void dumpHelper(PrintWriter pen, BitTreeNode cur, String str) throws Exception{
    if(cur.get('0') != null){
      dumpHelper(pen, cur.get('0'), str + "0");
    }
    if(cur.get('1') != null){
      dumpHelper(pen, cur.get('1'), str + "1");
    }
    if(cur.getValue() != null){
      pen.println(str + "," + cur.getValue());
    }
  }
}

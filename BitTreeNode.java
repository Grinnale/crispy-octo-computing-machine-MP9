public class BitTreeNode {
  BitTreeNode left;
  BitTreeNode right;
  String value;

  public BitTreeNode(){
    this.left = null;
    this.right = null;
    this.value = null;
  }

  public BitTreeNode(String val){
    this.left = null;
    this.right = null;
    this.value = val;
  }

  public BitTreeNode birth(char c) throws Exception{
    if(c == '0'){
      this.left = new BitTreeNode();
      return this.left;
    }
    else if(c == '1'){
      this.right = new BitTreeNode();
      return this.right;
    }
    throw new Exception();
  }

  public BitTreeNode get(char c) throws Exception{
    if(c == '0'){
      return this.left;
    }
    else if(c == '1'){
      return this.right;
    }
    throw new Exception();
  }

  public void set(String val){
    this.value = val;
  }

  public String getValue(){
    return value;
  }
}

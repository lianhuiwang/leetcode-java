import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Demo {

  HashMap<String, Object> parse(String input) {
    int start = 0;
    StringBuilder temp = new StringBuilder();
    Deque kvStack = new ArrayDeque<Object>();

    while(start < input.length()) {
      char current = input.charAt(start);
      System.out.println("curr= "+ current);
      if (current == '=') {
        kvStack.push(temp.toString());
        temp = new StringBuilder();
      } else if (current == ',') {
        if (temp.length() > 0) {
          kvStack.push(temp.toString());
          temp = new StringBuilder();
        }
      } else if (current == '[') {
        kvStack.push("[");
      } else if (current == ']') {
        if (temp.length() > 0) {
          kvStack.push(temp.toString());
          temp = new StringBuilder();
        }
        HashMap<Object, Object> kvs2 = new HashMap<Object, Object>();
        while(!kvStack.isEmpty()) {
          Object tmp = kvStack.pop();
          if (tmp.equals("[")) {       
            kvStack.push(kvs2);
            break;
          } else {
            Object key = kvStack.pop();
            kvs2.put(key, tmp);
          }
        }
      } else {
        temp.append(input.charAt(start));
        if (start == input.length() -1) {
          kvStack.push(temp.toString());
        }
      }
      start ++;
    }
    
    HashMap<String, Object> kvs = new HashMap<String, Object>();
    while(!kvStack.isEmpty()) {
      Object value = kvStack.pop();
      String key = (String) kvStack.pop();
      kvs.put(key, value);
    }
    return kvs;
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String input ="key1=value1,key2=value2,key3=[key4=value4,key5=value5,key6=[key7=value7]],key8=value8";
    System.out.println(new Demo().parse(input));
  }

}

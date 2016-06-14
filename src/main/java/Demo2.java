import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class Demo2 {

  private class Element implements Comparable<Element> {
    int value;
    int arrIndex;
    int valueIndex;

    Element(int value, int arrIndex, int valueIndex) {
      this.value = value;
      this.arrIndex = arrIndex;
      this.valueIndex = valueIndex;
    }

    @Override
    public int compareTo(Element o) {
      if (value < o.value)
        return -1;
      if (value > o.value)
        return 1;
      return 0;
    }
  }

  int[] andMerge(int[][] arrays, int arrayLength) {
    PriorityQueue<Element> queue = new PriorityQueue<Element>(arrayLength);
    for (int i = 0; i < arrayLength; i++) {
      queue.offer(new Element(arrays[i][0], i, 0));
    }
    List<Integer> resultsList = new ArrayList<Integer>();
    Element element = null;
    Integer value = null;
    int count = 0;
    while ((element = queue.poll()) != null) {
      System.out.println(element.value + "\t");
      if (value == null) {
        value = element.value;
        count = 1;
      } else if (element.value != value) {
        value = element.value;
        count = 1;
      } else {
        count ++;
        if (count == arrayLength) {
          resultsList.add(value);
        }
      }
      if (element.valueIndex + 1 < arrays[element.arrIndex].length) {
        queue.offer(new Element(
            arrays[element.arrIndex][element.valueIndex + 1], element.arrIndex,
            element.valueIndex + 1));
      }
    }

    System.out.println("====results===");
    int[] results = new int[resultsList.size()];
    for (int i = 0; i < resultsList.size(); i++) {
      results[i] = resultsList.get(i);
      System.out.println(results[i]);
    }
    return results;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
 
    int len = 3;
    int[][] arrays= { { 1, 2, 3, 4 }, { 2, 3, 4, 5 }, { 4, 5, 6, 7, 8 }};
    System.out.println(new Demo2().andMerge(arrays, len));
  }

}

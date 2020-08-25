

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sort {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    int size = 10;
    NumberSort.test(
      size,
      NumberSort.generateRandomIntegerArray(size)
    );
  }
}

class NumberSort {

  public static void test(int size, List<Integer> input) {
    if (input.size() != size) {
      throw new IllegalArgumentException(String.format("데이터가 유효하지 않습니다. size[%d] input.length[%d] ", size, input.size()));
    }
    System.out.println(String.format("[NumberSort Input]\n"
        + "size : %d\n"
        + "input : %s\n",
      size, input));
    System.out.println(String.format("[NumberSort Output]\n%s",
      quickSort(input)
        .stream()
        .map(Object::toString)
        .collect(Collectors.joining(", "))
      )
    );
  }

  public static List<Integer> generateRandomIntegerArray(int size) throws NoSuchAlgorithmException {
    Set<Integer> set = new HashSet<>(size);
    SecureRandom s = SecureRandom.getInstanceStrong();
    while (set.size() < size) {
      set.add(s.nextInt());
    }
    return new ArrayList<>(set);
  }

  private static List<Integer> quickSort(List<Integer> target) {

    if (target.size() <= 1) {
      return target;
    }

    int pivot = target.get(0); //choosing the first element as the pivot

    //smallerSorted = quicksort [a | a <- xs, a <= x]
    List<Integer> smallerSorted = quickSort(
      target.stream()
        .skip(1) //removing pivot
        .filter(i -> i >= pivot) //filter the elements >= x
        .collect(Collectors.toList())
    ); //convert the stream back to List

    //biggerSorted = quicksort [a | a <- xs, a > x]
    List<Integer> biggerSorted = quickSort(
      target.stream()
        .skip(1) //removing pivot
        .filter(i -> i < pivot) //filter the elements < x
        .collect(Collectors.toList())); //convert the stream back to List

    //smallerSorted ++ [x] ++ biggerSorted 
    return Stream.concat(Stream.concat(smallerSorted.stream(), Stream.of(pivot)), biggerSorted.stream())
      .collect(Collectors.toList());
  }
}
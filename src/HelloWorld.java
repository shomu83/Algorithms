import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HelloWorld {

//    public static void addPi(ArrayList<? super Double> list) {
//        list.add(Math.PI);
//    }

//    public static void changeString(String str) {
//        str = "changed";
//    }
//
//    public static void changeArray(String[] arr) {
//        arr[0] = "changed arr1";
//        arr[1] = "changed arr2";
//    }

//    <T> void addToList(List<T> list) {
//
//        list.add("foo");
//    }

    public static void main(String[] args) {

        String test = "test1";

        String test2 = test;
        test = "test2";

        System.out.println(test);
        System.out.println(test2);

//        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//                .collect(Collectors.toList());
//
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Integer i = iterator.next();
//            if (i % 2 == 0) {
//                iterator.remove();
//            }
//        }
//
//        System.out.println(list);

//        Collection<String> collection;
//
//        collection = new PriorityQueue<>();
//
//        collection.add("foo");
//        collection.add("bar");
//        collection.add("baz");
//
//        collection.forEach(System.out::println);

//        String original = "original";
//        String[] originalArr = new String[] {"o1", "o2"};
//        changeString(original);
//        changeArray(originalArr);
//
//        System.out.println(original);
//        System.out.println(originalArr[0] + " " + originalArr[1]);
//
//        Set<Integer> set = new TreeSet<Integer>();
//        set.add(3);
//        set.add((int)3.0);
//        set.add(2);
//        set.add(2);
//        set.add(new Integer(2));
//        set.add(Integer.parseInt("2"));
//
//        System.out.println(set);



//        Parent child = new Child();
//        System.out.println(child.value + " & " + child.getValue());

//        Child child = new Child();

//        ArrayList<Double> list1 = new ArrayList<>();
//        ArrayList<Number> list2 = new ArrayList<>();
//
//        addPi(list1);
//        addPi(list2);
//
//        System.out.println(list1);
//        System.out.println(list2);
//
//        List<Integer> list = Stream.of(3,1,6,3,10).collect(Collectors.toList());
//
//        Integer result = list.stream()
//                .reduce(list.get(0), (a ,b) -> a > b ? a : b);
//
//        System.out.println(result);
    }
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class ArrayOfArrays implements Iterable<Integer> {

        ArrayList<ArrayList<Integer>> arrayLists;
        ArrayOfArraysIterator iterator;

        public ArrayOfArrays(ArrayList<ArrayList<Integer>> arrayLists) {
            this.arrayLists = arrayLists;
            this.iterator = new ArrayOfArraysIterator(arrayLists);
        }

        @Override
        public Iterator<Integer> iterator() {
            return iterator;
        }

        @Override
        public void forEach(Consumer<? super Integer> action) {
            while (iterator().hasNext()) {
                action.accept(iterator().next());
            }
        }

    static class ArrayOfArraysIterator implements Iterator<Integer> {
        int parentIndex = 0;
        int childIndex = -1;

        ArrayList<ArrayList<Integer>> arrayLists;
        public ArrayOfArraysIterator(ArrayList<ArrayList<Integer>> arrayLists) {
            this.arrayLists = arrayLists;
        }

        @Override
        public boolean hasNext() {

            int nextIndex = childIndex + 1;
            int parentIndex = this.parentIndex;
            while (parentIndex < arrayLists.size()) {

                if (nextIndex < arrayLists.get(parentIndex).size()) {
                    return true;
                } else {
                    parentIndex++;
                    nextIndex = 0;
                }
            }

            return false;
        }

        @Override
        public Integer next() {
            childIndex++;
            while (parentIndex < arrayLists.size()) {

                if (childIndex < arrayLists.get(parentIndex).size()) {
                    return arrayLists.get(parentIndex).get(childIndex);
                } else {
                    parentIndex++;
                    childIndex = 0;
                }
            }

            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            arrayLists.get(parentIndex).remove(childIndex);
            childIndex--;
            if (childIndex < 0)
                childIndex = arrayLists.get(parentIndex - 1).size() - 1;
        }

        public void reset() {
            parentIndex = 0;
            childIndex = -1;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1); arr2.add(2);arr2.add(3);arr2.add(4);arr2.add(5);arr2.add(6);arr2.add(7);
        arrayLists.add(arr1);
        arrayLists.add(arr2);

        ArrayOfArrays iterable = new ArrayOfArrays(arrayLists);
        System.out.println("Demonstrate iterable methods");
        iterable.forEach(System.out::println);
        for (int value : iterable) {
            System.out.println(value);
        }

        ArrayOfArraysIterator iterator = new ArrayOfArraysIterator(arrayLists);
        System.out.println("Demonstrate iterator methods");

        while (iterator.hasNext()) {
            int value = iterator.next();
            System.out.println(value);

            if (value == 2)
                iterator.remove();
        }

        System.out.println("After removing element 2");
        iterator.reset();
        while (iterator.hasNext()) {
            int value = iterator.next();
            System.out.println(value);
        }

        System.out.println("After removing all elements");
        iterator.reset();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        iterator.reset();
        while (iterator.hasNext()) {
            int value = iterator.next();
            System.out.println(value);
        }
    }
}

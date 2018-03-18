import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class MissingNumberFinder {

//    public void find() {
//
//        Integer low = -2^31, high = 2^31 - 1, offset = 2^20;
//        List<Integer> missingNumbers = new ArrayList<>();
//
//        Integer index = low;
//
//        BitSet bitSet = new BitSet();
//        while (index <= high) {
//            BitSet result = markUsedIntegers(bitSet, index, index + offset);
//            for (Integer index = low; index < index + offset; i++) {
//                if (result.get(i) == true)
//                    missingNumbers.add(i);
//            }
//            index = index + offset;
//        }
//
//        missingNumbers.stream().forEach(System.out::print);
//    }
//
//    private BitSet markUsedIntegers(BitSet bitSet, Integer low, Integer high) {
//
//        for (Integer item : list) {
//            if (item >= low && item <=high)
//                bitSet.setBit(item);
//        }
//
//        return bitSet;
//    }

}

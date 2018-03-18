import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tbhambure on 3/11/18.
 */
public class NonOverlappingIntervals {

    public static void main(String[] args) {
        // input:               [1,3] [2,4] [4,5] [5,6] [3,10]
        // Sorted O(nlogn):
        // end                  3      4     5      6      6
        // count                0      1     2      3      3
        // non-overlap count:   3
        // elements to remove:  5 - 3 = 2

        // integer array to fill the range
        //

        // [ [1,2] , [1,3] , [2,3]]
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,3));

//        Interval[] intervalArr = intervals.toArray(new Interval[0]); //convert List to Array
        Interval[] intervalArr = intervals.stream().toArray(Interval[]::new);

        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int result = nonOverlappingIntervals.eraseOverlapIntervals(intervalArr);

        System.out.println(result);

    }

    public int eraseOverlapIntervals(Interval[] intervals) {

        Arrays.sort(intervals, new IntervalComparator());

        int currentEnd = intervals[0].end;
        int totalNonOverlapping = 1;
        for(int i=1; i< intervals.length; i++) {
            if (intervals[i].start >= currentEnd) {
                totalNonOverlapping++;
                currentEnd = intervals[i].end;
            }
        }

        int totalOverlapping = intervals.length - totalNonOverlapping;
        return totalOverlapping;
    }
}

class IntervalComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.end - o2.end;
    }
}

class Interval {
    public int start;
    public int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

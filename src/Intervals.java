import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Intervals {

    /**
     * Adds an interval [from, to) into an internal structure.
     */
    void addInterval(int from, int to);

    /**
     * Returns a total length covered by the added intervals.
     * If several intervals intersect, the intersection should be counted only once.
     * Example:
     *
     * addInterval(3, 6)
     * addInterval(8, 9)
     * addInterval(1, 5)
     *
     * getTotalCoveredLength() -> 6
     *
     * i.e. [1,5) and [3,6) intersect and give a total covered interval [1,6) with a length of 5.
     *      [1,6) and [8,9) don't intersect, so the total covered length is a sum of both intervals, that is 5+1=6.
     *
     *             |__|__|                  (4,6) 3 
     *          |__|__|__|                  (3,6) 3 
     *                         |__|         (8,9) 1
     *    |__|__|__|__|                     (1,5) 4 - (5 - 3) = 2
     *    1  2  3  4  5  6  7  8  9

     (2,7)
     (4,8)
     (1,10)
     (14,15)
     *
     nlnn
     n*n
     */
    int getTotalCoveredLength();
}

class IntervalsImpl implements Intervals {

    public static void main(String[] args) {
        IntervalsImpl intervalsImpl = new IntervalsImpl();
        intervalsImpl.addInterval(2, 7);
        intervalsImpl.addInterval(4, 8);
        intervalsImpl.addInterval(1, 10);
        intervalsImpl.addInterval(14, 15);

        System.out.println(intervalsImpl.getTotalCoveredLength());
    }

    List<Interval> intervals = new ArrayList<>();

    class Interval implements Comparable<Interval> {
        public Interval(int from, int to) {
            this.from = from;
            this.to = to;
        }

        int from;
        int to;

        @Override
        public int compareTo(Interval o) {
            return to - o.to;
        }
    }

    @Override
    public void addInterval(int from, int to) {
        intervals.add(new Interval(from, to));
    }

    @Override
    public int getTotalCoveredLength() {
        int n = this.intervals.size();

        if (n == 0)
            return 0;

        Interval[] intervals = this.intervals.toArray(new Interval[n]);
        Arrays.sort(intervals);

        int length = 0;
        int currStart = intervals[0].from;

        for (int i = 0; i < n - 1; i++) {
            if (intervals[i].to > intervals[i+1].from) {
                currStart = Math.min(currStart, intervals[i+1].from);
            } else {
                length += intervals[i].to - currStart;
                currStart = intervals[i+1].from;
            }
        }

        length += intervals[n - 1].to - currStart;

        return length;
    }
}
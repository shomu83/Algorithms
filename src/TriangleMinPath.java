import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tbhambure on 3/18/18.
 */
class TriangleMinPath {

    public static void main(String[] args) {
        TriangleMinPath path = new TriangleMinPath();
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(3, 4));
        input.add(Arrays.asList(6, 5, 7));
        input.add(Arrays.asList(4, 1, 8 ,3));

        System.out.println(path.minimumTotal(input));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        //l.0 -> (l+1).0,1
        //1 -> 1,2
        //2 -> 2,3
        //

        Map<Integer, Map<Integer, Integer>> levelIndexMap = initializeMap(triangle.size()); //for memoization

        return minTotal(0, 0, triangle, levelIndexMap);
    }

    private int minTotal(int level, int index, List<List<Integer>> triangle, Map<Integer, Map<Integer, Integer>> levelIndexMap) {

        if(level == triangle.size())
            return 0;

        if (levelIndexMap.get(level).containsKey(index))
            return levelIndexMap.get(level).get(index);

        int minPath = Integer.MAX_VALUE;
        int firstPath = minTotal(level+1, index, triangle, levelIndexMap);
        memoize(level + 1, index, firstPath, levelIndexMap);
        int secondPath = minTotal(level+1, index + 1, triangle, levelIndexMap);
        memoize(level + 1, index + 1, secondPath, levelIndexMap);

        int minCurrPath = Math.min(firstPath, secondPath) + triangle.get(level).get(index);
        minPath = Math.min(minCurrPath, minPath);

        return minPath;
    }

    private void memoize(int level, int index, int value, Map<Integer, Map<Integer, Integer>> levelIndexMap) {
        if (level < levelIndexMap.size()) {
            Map<Integer, Integer> indexMap = levelIndexMap.get(level);
            if(index <= level) {
                indexMap.put(index, value);
            }
        }
    }

    private Map<Integer, Map<Integer, Integer>> initializeMap(int levels) {

        Map<Integer, Map<Integer, Integer>> levelIndexMap = new HashMap<>();
        for(int level = 0;level<levels;level++) {
            levelIndexMap.put(level, new HashMap<>());
        }

        return levelIndexMap;
    }
}
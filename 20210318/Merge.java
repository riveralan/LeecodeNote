import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> result = new ArrayList<>();
        for(int i = 0;i<intervals.length;i++){
            int start = intervals[i][0],end = intervals[i][1];
            if (result.size() == 0 || result.get(result.size() - 1)[1] < start) {
                result.add(intervals[i]);
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], end);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    //快排
    private void sore(int[][] intervals){

    }
}

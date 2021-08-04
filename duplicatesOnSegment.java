import java.util.HashMap;
import java.util.Collection;

class duplicatesOnSegment {
    public static void main(String[] args) {
        int[] input = {12, 12, 1, 0};
        
        long startTime = System.nanoTime();
        int count = calculate(input);
        long endTime = System.nanoTime();

        print(count, startTime, endTime);
    }

    public static int calculate(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            HashMap<Integer,Integer> countMap = new HashMap<Integer,Integer>();
            for(int j = i; j < arr.length; j++) {
                if (countMap.containsKey(arr[i])) {
                    countMap.replace(arr[i], countMap.get(arr[i]) + 1);
                } else {
                    countMap.put(arr[i], 1);
                }
            }
            boolean atLeastTwo = true;
            Collection<Integer> collection = countMap.values();
            Integer[] values = collection.toArray(new Integer[collection.size()]);
            for(int k = 0; k < values.length; k++) {
                if(values[k] < 2) {
                    atLeastTwo = false;
                    break;
                }
            }
            if (atLeastTwo) {
                count++;
            }
        }
        return count;
    }

    public static void print(int count, long startTime, long endTime) {
        System.out.println("count is " + count);
        System.out.println("took " + (endTime - startTime) + " nanoseconds");
    }
}

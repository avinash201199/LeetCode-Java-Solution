import java.util.Arrays;

public class MedianFinder {
    int[] values;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        values = new int[0];
    }

    public void addNum(int num) {
        int insertIndex = 0;
        for (int j = 0; j < values.length; j++) {
            if (values[j] >= num)
                insertIndex = j + 1;
        }
        System.out.printf("Inserting at index %d\n", insertIndex);
        int[] newValues = new int[values.length + 1];
        System.arraycopy(values, insertIndex, newValues, insertIndex + 1, values.length - (insertIndex));
        System.arraycopy(values, 0, newValues, 0, insertIndex);

        newValues[insertIndex] = num;
        values = newValues;
    }

    public double findMedian() {
        int size = values.length;

        if (size % 2 == 1)
            return values[((int) Math.floor(size / 2.0))];

        int rightIndex = (size / 2);
        int leftIndex = rightIndex - 1;
        return (values[leftIndex] + values[rightIndex]) / 2.0;
    }
}

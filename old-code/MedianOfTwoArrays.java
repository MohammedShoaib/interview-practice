import java.util.*;

public class MedianOfTwoArrays {

    public static int median_(int arr[], int n) {
        if (n%2==0)
            return (arr[n/2] + arr[n/2 - 1])/2;
        return arr[n/2];
    }

    public static int median(int[] arr1, int[] arr2, int n) {
        if (n <= 0)
            return -1;
        else if (n == 1)
            return (arr1[0] + arr2[0]) / 2;
        else if (n == 2)
            return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1]))/2;

        int a1 = median_(arr1, n);
        int a2 = median_(arr2, n);

        if (a1 == a2)
            return a1;
        else if (a1 < a2) {
            if (n%2 == 0) {
                return median(Arrays.copyOfRange(arr1, n/2 - 1, n), arr2, n - n/2 + 1);
            }
            return median(Arrays.copyOfRange(arr1, n/2, n), arr2, n - n/2);
        }

        if (n%2 == 0) {
            return median(Arrays.copyOfRange(arr2, n/2 - 1, n), arr1, n - n/2 + 1);
        }
        return median(Arrays.copyOfRange(arr2, n/2, n), arr1, n - n/2);

    }

    public static void main(String args[]) {
        int[] a1 = {13, 14, 16, 18, 20};
        int[] a2 = {8, 9, 10, 11, 12};
        System.out.println(median(a1, a2, 5));
    }
}

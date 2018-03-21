/*
* Making use of concept of merge sort.
* */

import java.util.*;

public class InversionCount {

    public static int getDecimal(String ip) { //001
        int n = ip.length();
        int res=0;
        int temp;
        for (int i=0; i<n; i++) {
            temp = Character.getNumericValue(ip.charAt(n-i-1));
            res += (Math.pow(2, i) * temp);
        }
        return (int)res;
    }

    public static void dispStrArray(String[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    public static void dispIntArray(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");

    }

    public static int merge(int[] arr, int l, int m, int u) {
        int i,j,k;
        int invCount = 0;
        i = l;
        j = m;
        k = u;
        while ((i <= m - 1) && (j <= u))
        {
            if (arr[i] <= arr[j])
            {
                i++;
            }
            else
            {
                j++;
                invCount = invCount + (m - i); //both the halves are already sorted so if arr[i]>arr[j] then arr[i] > every element to the right of i is also greater than j.
            }
        }
        return invCount;
    }

    public static int getInvCount(int[] arr, int l, int u) {
        int m, invCount = 0;
        if(l < u) {
            m = (l + u)/2;
            invCount = getInvCount(arr, l, m);
            invCount += getInvCount(arr, m+1, u);
            invCount += merge(arr, l, m+1, u);
        }
        return invCount;
    }

    public static int getInversionCount(int[] arr) {
        return getInvCount(arr, 0, arr.length - 1);
    }

    public static void main(String args[]) {
        int n;
        //Scanner in = new Scanner(System.in);
        //n = in.nextInt();
        n = 1;
        String[] ip = new String[n];
        int[] ip2 = new int[n];
        for (int i=0; i<n; i++) {
            //ip[i] = in.next();
            ip[i] = "001";
            ip2[i] = getDecimal(ip[i]);
        }
        dispIntArray(ip2);

        for (int i=0; i<n; i++) {
            int m = ip2[i];
            int arr[] = new int[(int)Math.pow(2, (ip[i].length()))];
            for(int j=0; j<arr.length; j++) {
                arr[j] = j ^ m;
            }
            dispIntArray(arr);
            System.out.println(getInversionCount(arr));
        }

    }
}

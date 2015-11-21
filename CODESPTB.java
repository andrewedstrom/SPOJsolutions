/**
 * Created by andrew on 9/19/15.
 */


import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        while (testCases > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            ArrayAndCount t = new ArrayAndCount(a, 0);
            t = divideAndCount(t);
            a = t.array;
            int count = t.count;
            System.out.println(count);
            testCases--;
        }
        in.close();
        System.exit(0);
    }

    private static ArrayAndCount divideAndCount(ArrayAndCount t) {
        int[] a = t.array;
        int count = 0;
        if (a.length == 1) {
            return t;
        }
        int m = a.length/2;
        ArrayAndCount lw = divideAndCount(new ArrayAndCount(Arrays.copyOfRange(a, 0, m), 0));
        ArrayAndCount rw = divideAndCount(new ArrayAndCount(Arrays.copyOfRange(a, m, a.length), 0));
        count += lw.count;
        count += rw.count;
        int[] l = lw.array;
        int[] r = rw.array;
        int[] f = new int[a.length];
        int i = 0, j = 0, k = 0;
        while(i < l.length && j < r.length) {
            if (l[i] > r[j]) {
                f[k] = r[j];
                j++;
                count += l.length - i;
            } else {
                f[k] = l[i];
                i++;
            }
            k++;
        }
        while (i < l.length) {
            f[k] = l[i];
            i++;
            k++;
        }

        while (j < r.length) {
            f[k] = r[j];
            j++;
            k++;
        }
        return new ArrayAndCount(f, count);
    }
}
class ArrayAndCount {
    int[] array;
    int count = 0;

    public ArrayAndCount(int[] a, int c) {
        array = a;
        count = c;
    }

}

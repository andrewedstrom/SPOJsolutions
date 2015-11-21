package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int l = in.nextInt();
        int m = in.nextInt();
        String str = "";
        char[] arr = new char[1000001];
        arr[0] = 'B';
        arr[1] = 'A';

        for (int i= 2; i<1000001; i++) {
            if (arr[i-1] =='B') {
                arr[i] = 'A';
            }
            else if ((i-l>=0) && (arr[i-l] == 'B')) {
                arr[i] ='A';
            }
            else if((i-k>=0) && (arr[i-k]=='B')) {
                arr[i]='A';
            }
            else{
                arr[i]='B';
            }
        }
        for (int i = 0; i<m; i++) {
            int tmp = in.nextInt();
            str += arr[tmp];
        }
        System.out.println(str);

        in.close();
    }
}

package com.demyanenko;


import java.util.Arrays;
import java.util.Random;


public class Main {

    private static int[] arr;

    public static void main(String[] args) {
        int length = 20;
        int[] arrFirst = new int[length]; //23:33
        int i = 0;
        while (i < length - 1) {
            i++;
            arrFirst[i] = new Random().nextInt(100);
        }
        int[] arrSecond = new int[]{1,5,0,4,-3,-3,6,8,3,0,2,2};



        String text = "Какойто текст, любой, - со знаками припинания!";
        String answer = isPalindrome(text) ? "Text is palindrome" : "Text is not palindrome";
        System.out.println(answer);
        System.out.println("namer of Vovels = " + numbersOfVowels(text));

        System.out.println(Arrays.toString(arrFirst));
        System.out.println(bubbleSort(arrFirst));
        System.out.println(selectSort(arrFirst));

        System.out.println(Arrays.toString(arrSecond));
        System.out.println(inputSort(arrSecond));

    }

    public static String inputSort (int[] arr) {
        if(null == arr) {
            return Arrays.toString(arr);
        }
        for (int i = 1; i < arr.length-1; i++) {
            int temp = arr[arr.length-1];

            int poss = binary(arr, 0, i, arr[arr.length-1]);
            int invertPoss = (-poss)-1;
            if (poss < 0) {
                System.arraycopy(arr,invertPoss,arr,invertPoss+1,arr.length-1-invertPoss);
                arr[invertPoss] = temp;
            }
            else {
                System.arraycopy(arr,poss,arr,poss+1,arr.length-1-poss);
                arr[poss] = temp;
            }
        }
        return Arrays.toString(arr);
    }
    public static String bubbleSort(int[] arr) {
        int temp;
        boolean doReturn = true;
        for (int k = 0; k < arr.length - 1; ++k) {
            for (int i = 0; i < arr.length - 1 - k; ++i) {
                if (arr[i] < arr[i + 1]) {
                    doReturn = false;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            if (doReturn) {
                return Arrays.toString(arr);
            }
        }
        return Arrays.toString(arr);
    }
    public static String selectSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - i; i++) {
            int indexMin = i;
            int indexMax = arr.length - 1 - i;
            for (int k = i; k < arr.length - i; k++) {
                if (arr[k] < arr[indexMin]) {
                    indexMin = k;
                }
                if (arr[k] > arr[indexMax]) {
                    indexMax = k;
                }
            }
            temp = arr[i];
            arr[i] = arr[indexMin];
            arr[indexMin] = temp;
            if (temp != arr[arr.length - 1 - i]) {
                temp = arr[arr.length - 1 - i];
                arr[arr.length - i - 1] = arr[indexMax];
                arr[indexMax] = temp;
            }
        }
        return Arrays.toString(arr);

    }
    public static boolean isPalindrome(String text) {
        char[] arrCh = text.replaceAll("\\p{Punct}| ", "").toLowerCase().toCharArray();
        for (int i = 0; i < arrCh.length / 2; i++) {
            //System.out.println("first " + arrCh[i] + " second " + arrCh[arrCh.length-i-1]);
            if (arrCh[i] != arrCh[arrCh.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
    public static int numbersOfVowels(String text) {
        char[] arrCh = text.toLowerCase().replaceAll("[^ёуеэоаыяиюaeiouy]", "").toCharArray();
        return arrCh.length;
    }

    private static int binary(int[] arr, int low, int high, int key) {
        if (null == arr) {
            return -1;
        }

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }

}





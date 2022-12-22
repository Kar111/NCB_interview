package com.example.ncb_tasks;

import java.util.stream.IntStream;

public class SimpleMethods {

    //Task1
    public  String getDuplicates(String input) {
        int count_array[] = new int[128];

        IntStream.range(0, input.length()).forEach(i -> count_array[(int)input.charAt(i)]++);

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < count_array.length; i ++) {
            if(count_array[i] > 1) {
                stringBuilder.append((char)i);
            }
        }
        return stringBuilder.toString();
    }

    //Task2
    public  int[] findMinMax(int[] array) {

        int result[] = new int[2];
        if(array.length == 0) {
            return result;
        }
        int max = array[0];
        int min = array[0];

        for(int i : array) {
            if(i > max) {
                max = i;
            } else if(i < min) {
                min = i;
            }
        }
        result[0] = min;
        result[1] = max;

        return result;
    }

    //Task3
    public int recursiveSum(int number) {
        if(0 == number) {
            return 0;
        }
        return number + recursiveSum(number - 1);
    }
}

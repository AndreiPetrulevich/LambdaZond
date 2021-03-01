package ru.geekbrains.lambdazond;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Integer[] list = {1, 2, 3, 4, 5};
        List<String> listOfWords = Arrays.asList("Abc", "a  ", "ah!", "haa", "arr", "auf");
        System.out.println(search(5, list));
        System.out.println(maximum(list));
        System.out.println(average(list));
        System.out.println(reduce(Integer.MAX_VALUE, Arrays.asList(list), (a, b) -> { return Integer.min(a,b); }));
        System.out.println(checkString(listOfWords));
        System.out.println(filter(Arrays.asList(list), (i) -> { return i > 3; }));


        String string = "XYZ";
        ArrayList<Character> target = new ArrayList();
        for (char symbol : string.toCharArray()) {
            target.add(symbol);
        }
        System.out.println(reduce("", target, (result, next) -> {
            return next + result;
        }));
    }

    public static <T> int search(T value, T[] list) {
        return firstIndexOf(list, (x) -> { return x == value; });
    }

    public static <T> int firstIndexOf(T[] list, Predicate<T> lambda) {
        for (int i = 0; i < list.length; i++) {
            T x = list[i];
            if (lambda.apply(x)) {
                return i;
            }
        }
        return -1;
    }

    public static int maximum(Integer[] list) {
        return reduce(Integer.MIN_VALUE, Arrays.asList(list), (a, b) -> { return Integer.max(a, b); });
    }

    public static <R,T> R reduce(R startValue, Iterable<T> list, ReduceValues<R, T> lambda) {
        R result = startValue;
        for (T value : list) {
            result = lambda.apply(result, value);
        }
        return result;
    }

    public static Double average(Integer[] list) {
        int sum = reduce(0, Arrays.asList(list), (a, b) -> { return a + b; });
        if (list.length != 0) {
            return Double.valueOf(sum)/Double.valueOf(list.length);
        } else {
            return 0.0;
        }
    }

    public static <T> List<T> filter(Iterable<T> list, Predicate<T> predicate){
        List<T> result = new ArrayList<>();
        for (T value : list) {
            if (predicate.apply(value)) {
                result.add(value);
            }
        }
        return result;
    }

    public static List<String> checkString(List<String> list){
        return filter(list, (s) -> { return s != null && s.length() == 3 && s.charAt(0) == 'a'; });
    }
}

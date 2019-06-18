package 公众号.Arrays_asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class T1 {
    public static void main(String[] args) {
        error1();
        error2();
        error3();
    }

    /**
     * 由于Arrays.ArrayList参数为可变长泛型，而基本类型是无法泛型化的，所以它把int[] arr数组当成了一个泛型对象，所以集合中最终只有一个元素arr。
     */
    public static void error1() {
        int[] arr = {1, 2, 3};
        List list = Arrays.asList(arr);
        System.out.println(list.size());
        System.out.println(list);
        System.out.println();

    }

    /**
     * 由于asList产生的集合元素是直接引用作为参数的数组，
     * 所以当外部【数组】或【集合】改变时，
     * 数组和集合会同步变化，
     * 这在平时我们编码时可能产生莫名的问题。
     */
    public static void error2() {
        String[] arr = {"欢迎", "关注", "java"};
        List list = Arrays.asList(arr);
        arr[1] = "爱上";
        list.set(2, "我");
        System.out.println(Arrays.toString(arr));
        System.out.println(list.toString());
        System.out.println();

    }

    /**
     * 由于asList产生的集合并没有重写add,remove等方法，
     * 所以它会调用父类AbstractList的方法，
     * 而父类的方法中抛出的却是异常信息。
     */
    public static void error3() {
        String[] arr = {"欢迎", "关注", "java"};
        List list = Arrays.asList(arr);
        list.add("新增");// 从这里就错了

        list.remove("关注");
        System.out.println(list.toString());
        System.out.println();

    }

    public static void useInSpring() {
        int[] a = {1, 2, 3};
//        List list = CollectionUtils.arrayToList(a);
    }

    public static void useInJava8() {
        int intArray[] = {1, 2, 3};
        List<Integer> iList = Arrays.stream(intArray).boxed().collect(Collectors.toList());

    }

    /**
     * 数组转ArrayList
     */
    public static void method1() {
        Integer intArray[] = {1, 2, 3};
        ArrayList<Integer> aList = new ArrayList<>();
        for (Integer i : intArray) {
            aList.add(i);
        }
    }

    public static void method2() {
        List<String > list = new ArrayList<>();
        Collections.addAll(list,"welcome","to","lz");
    }
    public static void method3(){
        useInJava8();
        //一个很棒的方法
    }
}
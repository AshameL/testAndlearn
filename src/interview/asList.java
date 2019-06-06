package interview;

import java.util.Arrays;
import java.util.List;

public class asList {
    public static void main(String[] args) {
        String[] array = new String[]{"zhang3","li4","wang5"};
        List<String> list = Arrays.asList(array);
        list.add("sun6");  // 这里是会报错的
        //解答：因为将数组转换的列表其实不是我们经常使用的arrayList，
        //  但只是数组中内部定义的一种数据结构类型，本质还是原数组而并非列表
        System.out.println(list.size());
    }
}

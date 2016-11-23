package persistent;

import java.util.*;

/**
 * Created by SF on 2016/5/4.
 */
public class ArraysAndCollections {
    public static void main(String []args){
        String 骚杰东 = "*-*";
        骚杰东方法(骚杰东);
        Random random = new Random(47);
        Integer[] arrays = new Integer[10];
        for (int i=0; i<10; i++){
            arrays[i] = random.nextInt(100);
        }

        Arrays.fill(arrays, 3, 6, 99);//在数组中指定位置填充一定的值
        System.out.println(Arrays.toString(arrays));

        Arrays.parallelSort(arrays);
        System.out.println(Arrays.toString(arrays));

//        System.out.println(Arrays.stream(arrays));//将数组转化为流  流操作

        /********************************* Collections *************************************/
        List<Integer> intlist = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
//        Collections.addAll(intlist); //此处没有实际意义
        Integer[] arrayIntger = {2,4,43};
        Collections.addAll(intlist, arrayIntger);//intlist 必须是实例化的对象，要是ArrayList或者LinkedList之类的具体实现
        for (int temp : intlist) {
            System.out.print(temp + "\t");
        }
        System.out.println();

        Set<Integer> intSet = new LinkedHashSet<>();
        intSet.add(random.nextInt());
        intSet.add(random.nextInt());
        intSet.add(random.nextInt());
        intSet.add(random.nextInt());
        Collections.addAll(intSet, arrayIntger);
        for (int temp: intSet){
            System.out.print(temp + "\t");
        }
    }

    public static void 骚杰东方法(String 参数){
        System.out.println("打印参数：" + 参数);
    }
}

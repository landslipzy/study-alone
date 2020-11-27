package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhongying
 * @description
 * @date 2020/11/17
 */
public class areaNameSort {
    public static void main(String[] args) {
        List<String> dsOrder = Arrays.asList(
        "成都市","绵阳市","自贡市","全部","攀枝花市","泸州市","全部","德阳市","广元市","遂宁市","内江市","乐山市","资阳市","宜宾市","南充市","达州市","雅安市","阿坝藏族羌族自治州","甘孜藏族自治州","凉山彝族自治州","广安市","巴中市","眉山市");
        List<String> target = Arrays.asList("泸州市","泸州市","全部","主城区","成都市","遂宁市");
        System.out.println(dsOrder.indexOf("全部"));
//        target.forEach(n-> System.out.print(n+" "));
//        setListOrder(dsOrder, target);
//        System.out.println();
//        target.forEach(n-> System.out.print(n+" "));
    }

    //平时排序可使用其中一种，下面是综合两个条件排序
    public static void setListOrder(List<String> orderRegulation, List<String> targetList) {
        //按照Posts的Id来排序
        Collections.sort(targetList, ((o1, o2) -> {
            int io1 = orderRegulation.indexOf(o1);
            int io2 = orderRegulation.indexOf(o2);

            if (io1 != -1) {
                io1 = orderRegulation.size() - io1;
            }
            if (io2 != -1) {
                io2 = orderRegulation.size() - io2;
            }

            return io2 - io1;
        }));

//        //按照Posts的age来排序
//        Collections.sort(targetList, ((o1, o2) -> {
//            int io1 = orderRegulation.indexOf(o1.getAge());
//            int io2 = orderRegulation.indexOf(o2.getAge());
//
//            if (io1 != -1) {
//                io1 = targetList.size() - io1;
//            }
//            if (io2 != -1) {
//                io2 = targetList.size() - io2;
//            }
//
//            return io2 - io1;
//        }));
    }
}

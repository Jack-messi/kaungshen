package com.kuang.test;

import com.kuang.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<User> list = Arrays.asList(
                new User("小明", 20, 3000),
                new User("小猴", 22, 4000),
                new User("小张", 24, 5000)
        );
        //list中age<21
        List<User> newlist = new ArrayList<>();
        for (User user : list) {
            if (user.getAge() < 21) {
                newlist.add(user);
            }
        }

        //list中salary>2000
        List<User> newlist2 = new ArrayList<>();
        for (User user : list) {
            if (user.getSalary() > 2000) {
                newlist2.add(user);
            }
        }

        //Stream
//        Predicate<User> predicate1 = user ->user.getAge()<21;
//        Predicate<User> predicate2 = user -> user.getSalary()>2000;
//
//        List<User> collect = list.stream()
//                .filter(predicate1)   //条件1
//                .filter(predicate2)   //条件2
//                .collect(Collectors.toList());//collect(Collectors.toList())创建一个新的集合
//
//        System.out.println(collect);


//        List<User> collect = list.stream()
//                .filter(user ->user.getAge()<21)   //条件1
//                .filter(user -> user.getSalary()>2000)   //条件2
//                .collect(Collectors.toList());//collect(Collectors.toList())创建一个新的集合
//
//        System.out.println(collect);


        Predicate<User> predicate1 = user -> user.getAge() < 21;
        Predicate<User> predicate2 = user -> user.getSalary() > 2000;
        List<User> collect = list.stream()
                .filter(predicate1.or(predicate2))   //条件1
                .collect(Collectors.toList());//collect(Collectors.toList())创建一个新的集合

        System.out.println(collect);


        //filter：过滤条件
        List<String> list1 = Arrays.asList("hello", "world", "java");
        list1.stream()
                .filter(str -> str.length() >= 5) //str指的是每一个字符串对象。筛选长度大于5的
                .forEach(str -> System.out.println(str));  //输出结果

        //limit : 使元素不超过规定的数量
        list1.stream()
                .limit(2)
                .forEach(str -> System.out.println(str));

        //sorted
        List<Integer> list2 = Arrays.asList(1, 6, 2, 4, 5, 3);
        list2.stream()
                .sorted()   //默认是进行升序排序，加上Comparator.reverseOrder()后反序
                .forEach(num -> System.out.println(num));

        //求最大值，最小值
        List<Integer> list3 = Arrays.asList(1, 6, 2, 4, 5, 3);
        System.out.println(list3.stream()
                .max(Integer::compareTo) //按照Integer的排序方式
                .get());

        //求最小值
        System.out.println(list3.stream()
                .min(Integer::compareTo)
                .get());

        //求总长度
        System.out.println(list3.stream()
                .count());

        //map:对集合中的元素进行特定的操作，
        //每个元素加10并且输出
        list3.stream()
                .map(num -> num + 10)
                .forEach(num -> System.out.println(num));

        //reduce:对集合中的元素进行特定操作，和map很像，区别在于，reduce会将所有的元素按照传入的逻辑进行处理，并且会把结果合并为一个值进行返回
        System.out.println(list3.stream()
                .reduce((sum, num) -> sum + num).get());

        //collection：把目标结合筛选后，生成新的集合
        List<Integer> collect1 = list3.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println(collect1);

    }
}

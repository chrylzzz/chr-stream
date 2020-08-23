package com.chryl.po;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Chr.yl on 2020/8/23.
 *
 * @author Chr.yl
 */
public class TestStream {
    static List<Apple> apples = new ArrayList<>();

    static {

        Apple apple1 = new Apple(1, "app-1", BigDecimal.ONE, 1);
        Apple apple2 = new Apple(1, "app-2", BigDecimal.TEN, 2);
        Apple apple3 = new Apple(3, "ban-3", BigDecimal.ZERO, 3);
        Apple apple4 = new Apple(4, "ban-4", BigDecimal.ONE, 4);
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);
    }

    public static void main(String[] args) {

        //分组 : id相同的分在一组
        Map<Integer, List<Apple>> collect = apples.stream().collect(Collectors.groupingBy(Apple::getId));
        System.out.println(collect);

        //List 转 Map : id为key , apple对象为value
        Map<Integer, Apple> appleMap = apples.stream().collect(Collectors.toMap(Apple::getId, app -> app, (k1, k2) -> k1));
        System.out.println(appleMap);

        //过滤 : 包含 ban 的
        List<Apple> banList = apples.stream().filter(a -> a.getName().contains("ban")).collect(Collectors.toList());
        System.out.println(banList);

        //求和
        BigDecimal reduce = apples.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(reduce);

        //最大和最小
//        Collectors.maxBy(Comparator.comparing(Apple::getNum));
        
        //去重


    }
}

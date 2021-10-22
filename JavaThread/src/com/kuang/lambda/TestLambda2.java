package com.kuang.lambda;

public class TestLambda2 {



    public static void main(String[] args) {

        //1、lambda表达式
        ILove love = (int a)-> {

                System.out.println("i love you--> " + a);

        };

        //简化2、参数类型
        love = (int a) -> {
            System.out.println("i love you--> " + a);

        };

        //简化3、简化括号
        love = a -> {
            System.out.println("i love you--> " + a);
        };

        //简化4：简化花括号
        love = a -> System.out.println("i love you--> " + a);

        love.love(520);


        /*
        * 总结：
        *   lambda表达式只能有一行代码的情况下才能简化成为一行，如果有多行，那么就用代码块包裹
        *   前提是接口为函数式接口
        *   多个参数也可以去掉参数类型，要去掉就都去掉，必须加上括号
        * */
    }
}

interface ILove {
    void love(int a);
}




package com.sec10.myreflect;


import java.lang.reflect.Field;

class My{
    @SuppressWarnings("unused")
    private String name = "홍길동";
    private int a =0;
}

public class a_ClassInfoTest {
    public static void main(String[] args) throws Exception {


        My m1 = new My();
        Class<?> cls = m1.getClass();
        Field field = cls.getDeclaredField("name");
        field.setAccessible(true);// private 멤버 접근


        //필드 값 변경
        field.set(m1,"정길동");

        System.out.println("변경된 값 : "+ field.getByte(m1));
        System.out.println("==============================");

        //필드 정보 가져오기
        field = cls.getDeclaredField("a");
        field.setAccessible(true);

        //필드 값 변경
        field.setInt(m1, 20);
        System.out.println("변경된 값: "+field.getInt(m1));

    }
}

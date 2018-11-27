/**
 * created by Zheng Jiateng on 2018/11/15.
 */
package com.jmall;

public class OverClass<T> { //  定义泛型类

    private T over;
    private T[] array;

    public T getOver() {
        return over;
    }

    public void setOver(T over) {
        this.over = over;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public static void main(String[] args) {
        // 实例化一个Boolean型的对象
        OverClass<Boolean> over1 = new OverClass<>();
        // 实例化一个Float型的对象
        OverClass<Float> over2 = new OverClass<>();
        over1.setOver(true);
        over2.setOver(12.3f);
        Boolean b = over1.getOver();
        float f = over2.getOver();
        System.out.println(b);
        System.out.println(f);
        System.out.println(over1.getClass().getDeclaredMethods());
    }
}

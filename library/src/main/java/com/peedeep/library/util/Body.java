package com.peedeep.library.util;

/**
 * Created by rick on 2019/3/30.
 * 提供某个方法所有信息工具类。
 */
public class Body<T, X, R> {

    public final boolean hasParam;      //有参数
    public final Class<T> paramType;    //参数类型
    public final T paramData;           //参数值
    public final boolean hasReturn;     //有返回
    public final Class<X> returnType;   //返回类型
    public final X returnData;          //返回值
    public final Func<X, R> func;       //钩子，将中间类型转换成最终类型

    public Body(boolean hasParam, Class<T> paramType, T paramData, boolean hasReturn, Class<X> returnType, X returnData, Func<X, R> func) {
        this.hasParam = hasParam;
        this.paramType = paramType;
        this.paramData = paramData;
        this.hasReturn = hasReturn;
        this.returnType = returnType;
        this.returnData = returnData;
        this.func = func;
    }

    /**
     * 处理有参数且有返回的方法
     * @param paramType 参数类型
     * @param paramData 参数值
     * @param returnType 返回类型
     * @param returnData 返回值
     * @param func 将中间类型转换成最终类型的函数的钩子
     * @param <T> 参数类型
     * @param <X> 中间类型
     * @param <R> 最终类型
     * @return 返回方法的所有信息载体
     */
    public static <T, X, R> Body<T, X, R> hasParamHasResult(Class<T> paramType, T paramData, Class<X> returnType, X returnData, Func<X, R> func) {
        return new Body<>(true, paramType, paramData, true, returnType, returnData, func);
    }

    /**
     * 处理无参数且无返回的方法
     * @param <T> 参数类型
     * @param <X> 中间类型
     * @param <R> 最终类型
     * @return 返回方法的所有信息载体
     */
    public static <T, X, R> Body<T, X, R> noParamNoResult() {
        return new Body<>(false, null, null, false, null, null, null);
    }

    /**
     * 处理有参数且无返回的方法
     * @param paramType 参数类型
     * @param paramData 参数值
     * @param <T> 参数类型
     * @param <X> 中间类型
     * @param <R> 最终类型
     * @return 返回方法的所有信息载体
     */
    public static <T, X, R> Body<T, X, R> hasParamNoResult(Class<T> paramType, T paramData) {
        return new Body<>(true, paramType, paramData, false, null, null, null);
    }

    /**
     * 处理无参数且有返回的方法
     * @param returnType 返回类型
     * @param returnData 返回值
     * @param func 将中间类型转换成最终类型的函数的钩子
     * @param <T> 参数类型
     * @param <X> 中间类型
     * @param <R> 最终类型
     * @return 返回方法的所有信息载体
     */
    public static <T, X, R> Body<T, X, R> noParamHasResult(Class<X> returnType, X returnData, Func<X, R> func) {
        return new Body<>(false, null, null, true, returnType, returnData, func);
    }

    /**
     * 获取body中的参数
     * @param body 方法的信息载体
     * @param <T> 参数类型
     * @param <X> 中间类型
     * @param <R> 最终类型
     * @return 返回参数值
     */
    public static <T, X, R> T mapParam(Body<T, X, R> body) {
        if (body.hasParam) {
            return Transition.switchOrNull(body.paramData, body.paramType);
        }
        return null;
    }

    /**
     * 通过body,返回中间类型
     * @param s 实现中间接口的返回值
     * @param body 方法信息的载体
     * @param <T> 中间类型
     * @param <X> 参数类型
     * @param <R> 最终类型
     * @param <S> 中间类型的值的类型
     * @return
     */
    public static <T, X, R, S> X mapReturn(S s, Body<T, X, R> body) {
        if (body.hasReturn) {
            return Transition.switchOrNull(s, body.returnType);
        }
        return null;
    }

}


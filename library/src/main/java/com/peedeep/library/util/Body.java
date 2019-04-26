package com.peedeep.library.util;

/**
 * Created by rick on 2019/3/30.
 * TODO
 */
public class Body<T, X, R> {

    public final boolean hasParam;
    public final Class<T> paramType;
    public final T paramData;
    public final boolean hasReturn;
    public final Class<X> returnType;
    public final X returnData;
    public final Func<X, R> func;

    public Body(boolean hasParam, Class<T> paramType, T paramData, boolean hasReturn, Class<X> returnType, X returnData, Func<X, R> func) {
        this.hasParam = hasParam;
        this.paramType = paramType;
        this.paramData = paramData;
        this.hasReturn = hasReturn;
        this.returnType = returnType;
        this.returnData = returnData;
        this.func = func;
    }

    public static <T, X, R> Body<T, X, R> hasParamHasResult(Class<T> paramType, T paramData, Class<X> returnType, X returnData, Func<X, R> func) {
        return new Body<>(true, paramType, paramData, true, returnType, returnData, func);
    }

    public static <T, X, R> Body<T, X, R> noParamNoResult() {
        return new Body<>(false, null, null, false, null, null, null);
    }

    public static <T, X, R> Body<T, X, R> hasParamNoResult(Class<T> paramType, T paramData) {
        return new Body<>(true, paramType, paramData, false, null, null, null);
    }

    public static <T, X, R> Body<T, X, R> noParamHasResult(Class<X> returnType, X returnData, Func<X, R> func) {
        return new Body<>(false, null, null, true, returnType, returnData, func);
    }

    public static <T, X, R> T mapParam(Body<T, X, R> body) {
        if (body.hasParam) {
            return Transition.switchOrNull(body.paramData, body.paramType);
        }
        return null;
    }

    public static <T, X, R, S> X mapReturn(S s, Body<T, X, R> body) {
        if (body.hasReturn) {
            return Transition.switchOrNull(s, body.returnType);
        }
        return null;
    }


}


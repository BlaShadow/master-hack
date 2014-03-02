package com.obrero.cmycountry.utils;

/**
 * Created with IntelliJ IDEA.
 * User: dragon
 * Date: 3/1/14
 * Time: 9:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class Converter {
    public static <T> T doConvert(Class<T> type, Object obj){
        return type.cast(obj) ;
    }
}
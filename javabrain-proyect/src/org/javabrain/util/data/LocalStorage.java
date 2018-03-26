package org.javabrain.util.data;

import java.util.HashMap;
import java.util.Map;

/***
 * @author Fernando García
 * @version 0.0.1
 */
public class LocalStorage {

    private static Map<Object,Object> dat = new HashMap<Object,Object>();

    public static Object getItem(Object key){
        return dat.get(key);
    }

    public static boolean setItem(Object key,Object data){
        try {
            dat.put(key,data);
            return true;
        }catch (Exception e){}
        return false;
    }

    public static boolean removeItem(Object key){
        try {
            dat.remove(key);
            return true;
        }catch (Exception e){}
        return false;
    }

    public static boolean clear(){
        try {
            dat.clear();
            return true;
        }catch (Exception e){}
        return false;
    }
}

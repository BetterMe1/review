package exercise.review.reflect.vo;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
负责自动vo处理操作
 */
public class BeanOperation {
    private BeanOperation(){}

    public static void setBeanValue(Object obj, String str) throws Exception{
        String [] result = str.split("\\|");
        for(String res : result){
            String[] tmp = res.split(":");
            String[] fields = tmp[0].split("\\.");
            Object currentObj = getObject(obj,fields[0]);
            setObjectValue(currentObj,fields[1],tmp[1]);
        }
    }

    private static Object getObject(Object obj, String attribute) throws Exception {
        String methodName = "get"+attribute.substring(0,1).toUpperCase()+attribute.substring(1);
        Field field = obj.getClass().getDeclaredField(attribute);
        if(field ==null){
            field = obj.getClass().getField(attribute);
        }
        if(field == null){
            return null;
        }
        Method method = obj.getClass().getMethod(methodName);
        return method.invoke(obj);
    }
    private static void setObjectValue(Object obj, String attribute,String value)throws Exception{
        String methodName = "set"+attribute.substring(0,1).toUpperCase()+attribute.substring(1);
        Field field = obj.getClass().getDeclaredField(attribute);
        if(field ==null){
            field = obj.getClass().getField(attribute);
        }
        if(field == null){
            return ;
        }
        Method method = obj.getClass().getMethod(methodName,field.getType());
        method.invoke(obj,value);
    }
}

package wang.chenguang.learn.QA;

import com.whyischen.basic.entity.User;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射调用对象方法
 */
public class 反射调用对象方法 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        user.setId(1L);
        user.setName("小明");
        user.setAge(18);

        Object obj = (Object) user;

        // 获取 User 的 getId 方法
        var methodGetId = obj.getClass().getMethod("getId");
        // 在 obj 对象调用该方法
        Long id = (Long) methodGetId.invoke(obj);
        System.err.println("id === " + id);
    }


}

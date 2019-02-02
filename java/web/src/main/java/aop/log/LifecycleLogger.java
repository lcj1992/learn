package aop.log;


/**
 * Desc: 生命周期日志记录器
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/2/9
 * Time: 下午8:29
 */
public class LifecycleLogger implements Cloneable {

   public void print(){
       System.out.println("ehe");
   }

    public static void main(String[] args) throws CloneNotSupportedException {
        LifecycleLogger logger = new LifecycleLogger();
        logger.clone();
    }
}

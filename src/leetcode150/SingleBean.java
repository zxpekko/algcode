package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:03 2024/9/11
 */
public class SingleBean {
    private SingleBean(){}
    private static SingleBean singleBean=new SingleBean();
    public static SingleBean getInstance(){
        return singleBean;
    }
}
class SingleBeans{
    private SingleBeans(){}
    private static SingleBeans singleBeans;
    public static SingleBeans getInstance(){
        synchronized (SingleBeans.class){
            if(singleBeans==null)
                singleBeans=new SingleBeans();
        }
        return singleBeans;
    }
}
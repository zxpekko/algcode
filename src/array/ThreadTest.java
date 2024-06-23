package array;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:38 2024/6/22
 */
public class ThreadTest {
    public static void main(String[] args) {
        new Thread(()->{
            for(int i=1;i<=3;i++){
                synchronized (ThreadTest.class){
                    System.out.println(i);
                }

            }
        }).start();
        new Thread(()->{
            System.out.println("A");
            System.out.println("B");
            System.out.println("C");
        }).start();
    }

}

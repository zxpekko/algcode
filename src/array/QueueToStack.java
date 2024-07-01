package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:13 2024/6/24
 */
public class QueueToStack {
    Queue<Integer> queue=new LinkedList<>();
    Queue<Integer> queue1=new LinkedList<>();
    Integer flag=0;
    public static void main(String[] args) {

    }
    public void queueToStackPush(Integer val){
        if(flag==0)
            queue.add(val);
        else
            queue1.add(val);
    }
    public int queueToStackPop(){

        return 0;
    }
//    public int chosepop()
}

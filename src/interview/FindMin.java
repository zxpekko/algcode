package interview;

/**
 * @Author:zxp
 * @Description:
 * @Date:18:40 2024/8/10
 */
public class FindMin {
    public static void main(String[] args) {
        int i = get(new int[]{0,1, 2, 3});
        System.out.println(i);
    }
    public static int get(int[] arr){
        int n=arr.length;
        boolean[] visited = new boolean[n];
        for(int num:arr){
            if(num>=0&&num<n)
                visited[num]=true;
        }
        for(int i=0;i<visited.length;i++){
            if(!visited[i])
                return i;
        }
        return n;
    }
}
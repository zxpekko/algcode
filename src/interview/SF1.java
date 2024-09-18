package interview;

import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:30 2024/9/7
 */
public class SF1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] cons = new int[6];
        for(int i=0;i<cons.length;i++)
            cons[i]=scanner.nextInt();
        int k=scanner.nextInt();
        int count = count(cons, k);
        System.out.println(count);
    }
    private static int size=3;
    public static int count(int[] constraints,int k){
        int count=0;
        int totalPossiblities=1<<(size*size*2);
        for(int i=0;i<totalPossiblities;i++){
            int[] matrix=new int[size*size];
            for(int j=0;j<size*size;j++){
                matrix[j]=(i>>(2*j))&3;
            }
            int[] rowXor=new int[size];
            int[] colXor=new int[size];
            for(int r=0;r<size;r++){
                rowXor[r]=matrix[r*size]^matrix[r*size+1]^matrix[r*size+2];
            }
            for(int c=0;c<size;c++){
                colXor[c]=matrix[c]^matrix[size+c]^matrix[2*size+c];
            }
            int satisfied=0;
            for(int r=0;r<size;r++){
                if(rowXor[r]==constraints[r]){
                    satisfied++;
                }
            }
            for(int c=0;c<size;c++){
                if(colXor[c]==constraints[size+c]){
                    satisfied++;
                }
            }
            if(satisfied>=k)
                count++;
        }
        return count;
    }
}

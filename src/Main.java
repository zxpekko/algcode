import java.util.*;

/**
 * @Author:zxp
 * @Description:2
 * /home/zhangshan test/./../testfile.txt
 * /home/zhangshan /usr/shared/lib/..//ld.so
 * @Date:19:38 2024/6/18
 */
public class Main {
//    public static void main(String[] args) {
//        Main main = new Main();
//        System.out.println(Main.minumMutationSteps("AACGT", "ACCGGT"));
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(simplifyPath("/home/zhangshan", "test/./../testfile.txt"));
//    }
public static void main(String[] args) {
    maxGold=0;
    int m=10,n=10;
    boolean[][] visited = new boolean[m][n];
//    dfs(grid,visited,0,0,0,false);
//    for(int i=0;i<m;i++){
//        for(int j=0;j<n;j++){
//            if(grid[])
//        }
//    }
}
    static  int maxGold=0;
    public static int minumMutationSteps(String seq1,String seq2){
        int m=seq1.length();
        int n=seq2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                else if(j==0){
                    dp[i][j]=i;
                }
                else if(seq1.charAt(i-1)==seq2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }
//    public static String simplifyPath(String path){
//        Deque<String> stack=new LinkedList<>();
//        Set<String> skip=new HashSet<>(Arrays.asList("..",".",""));
//        for(String dir:path.split("/")){
//            if(dir.equals("..")&&!stack.isEmpty()){
//                stack.pop();
//            }
//            else if(!skip.contains(dir)){
//                stack.push(dir);
//            }
//        }
//        StringBuilder result=new StringBuilder();
//        for(String dir:stack){
//            result.insert(0,"/"+dir);
//        }
//        return result.length()>0?result.toString():"/";
//    }
//    public static String simplifyPath(String cwd,String path){
//        StringBuilder sb = new StringBuilder();
//        if(!path.startsWith("/")){
//            sb.append(cwd);
//            if(!cwd.endsWith("/")){
//                sb.append("/");
//            }
//        }
//        for(String part:path.split("/")){
//            if(part.equals("..")){
//                int lastSlash=sb.lastIndexOf("/");
//                if(lastSlash!=-1){
//                    sb.delete(lastSlash,sb.length());
//                }
//            }
//            else if(!part.equals("")&&!part.equals(".")){
//                if(sb.length()>0&&!sb.toString().endsWith("/")){
//                    sb.append("/");
//                }
//                sb.append(part);
//            }
//        }
//        return sb.toString();
//    }
         public static String simplifyPath(String cwd,String path){
            if(path.startsWith("/")){
                return simplify(path);
            }
            else {
                return simplify(cwd+"/"+path);
            }
         }
         public static String simplify(String path){
            String[] components=path.split("/");
            Stack<String> stack=new Stack<>();
            for(String component:components){
                if(component.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }
                else if(!component.equals(".")&&!component.isEmpty()){
                    stack.push(component);
                }
            }
            StringBuilder simplifiedPath=new StringBuilder();
            for(String dir:stack){
                simplifiedPath.append("/").append(dir);
            }
            return simplifiedPath.length()>0?simplifiedPath.toString():"/";
         }
         public static void dfs(int[][] grid,boolean[][] visited,int x,int y,int currentGold,boolean usedSkill){
            int m=grid.length;
            int n=grid[0].length;
            if(x<0||x>=m||y<0||y>=n||grid[x][y]==-1||visited[x][y])
                return;
            visited[x][y]=true;
            currentGold+=grid[x][y];
            maxGold=Math.max(maxGold,currentGold);
            dfs(grid,visited,x+1,y,currentGold,usedSkill);
            dfs(grid,visited,x-1,y,currentGold,usedSkill);
            dfs(grid,visited,x,y+1,currentGold,usedSkill);
            dfs(grid,visited,x,y-1,currentGold,usedSkill);

    }
}

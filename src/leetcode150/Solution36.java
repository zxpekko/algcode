package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:18 2024/7/25
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.'){
                    for(int k=0;k<board.length;k++){
                        if(k==i)
                            continue;
                        if(board[k][j]==board[i][j])
                            return false;
                    }
                    for(int k=0;k<board[i].length;k++){
                        if(k==j)
                            continue;
                        if(board[i][k]==board[i][j])
                            return false;
                    }
                    int row=i/3;
                    int col=j/3;
                    for(int m=3*row;m<3*row+3;m++){
                        for(int n=3*col;n<3*col+3;n++){
                            if(m==i&&n==j)
                                continue;
                            if(board[m][n]==board[i][j])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

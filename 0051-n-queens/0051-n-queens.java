class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list= new ArrayList<>();
        // create a chess borad of '.'
        char[][] board = new char[n][n];
        // chess board of n x n is created fill it with '.'
        for(int i=0; i<n; i++){
            Arrays.fill(board[i],'.');
        }
        // create boolean arrays for safetly check
        int[] leftRow = new int[n];
        int[] upperDia = new int[2*n-1];
        int[] lowerDia = new int[2*n-1];

        solve(0,board,list,leftRow,upperDia,lowerDia,n);
        return list;

    }
    public void solve(int row, char[][] board, List<List<String>> list,int[] leftRow, int[] upperDia , int[] lowerDia,int n){
        if(row ==n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp.add(new String(board[i]));
            }
            list.add(temp);
            return;
        }
        for(int cols =0;cols<n;cols++){
            int upper=(n-1)+(cols-row);
            int lower= cols+row;
            if(leftRow[cols]==0 && upperDia[upper]==0 && lowerDia[lower]==0){
                board[row][cols]='Q';
                leftRow[cols]=1;
                upperDia[upper]=1;
                lowerDia[lower]=1;
                solve(row+1,board,list,leftRow,upperDia,lowerDia,n);
                board[row][cols]='.';
                leftRow[cols]=0;
                upperDia[upper]=0;
                lowerDia[lower]=0;

            }
        }
    }
}
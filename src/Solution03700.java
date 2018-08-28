public class Solution03700 {
    public void solveSudoku(char[][] board) {
        // 分析数独, 得到决策数组

        // 将原始数组和决策数据传入进行查找
    }
//
//    /**
//     *
//     * @param board
//     * @return
//     */
//    private boolean[][][] analysisSudoku(char[][] board) {
//        boolean[][][] result = new boolean[9][9][9];
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                for (int k = 0; k < 9; k++) {
//                    result[i][j][k] = true;
//                }
//            }
//        }
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] == '.') {
//                    continue;
//                }
//                int val = board[i][j]-48;
//                whenis(i,j,val, board, result);
//            }
//        }
//        return result;
//    }
//
//    private void findResult() {
//        // 找到决策数组中最少的决策点
//
//        // 循环决策
//
//        // 循环内: 修正决策数组
//
//        // 循环内: 再次调用解决函数
//
//    }
}

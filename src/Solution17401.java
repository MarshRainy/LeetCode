public class Solution17401 {
    /**
     * 反向的动态规划:
     * minHP[边界] = 0;
     * minHP[i][j] = (dungeon[i][j]>min(下,右))? 0: min(下,右)-dungeon[i][j];
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int iLength = dungeon.length;
        int jLength = dungeon[0].length;
        int[][] minHP = new int[iLength][jLength];
        for (int i = iLength - 1; i >= 0; i--) {
            for (int j = jLength - 1; j >= 0; j--) {
                int lastMinHP = 0;
                if (i + 1 < iLength) {
                    lastMinHP = minHP[i + 1][j];
                    if (j + 1 < jLength)
                        lastMinHP = lastMinHP < minHP[i][j + 1] ? lastMinHP : minHP[i][j + 1];
                } else if (j + 1 < jLength) {
                    lastMinHP = minHP[i][j + 1];
                }
                minHP[i][j] = (dungeon[i][j] > lastMinHP) ? 0 : lastMinHP - dungeon[i][j];
            }
        }
//        MTools.print2darray(dungeon);
//        MTools.print2darray(minHP);
        return minHP[0][0] + 1;
    }


    public static void main(String[] args) {
        int[][] dungeon = {{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}}; // 正确答案是3, 上面是5
        System.out.println(new Solution17401().calculateMinimumHP(dungeon));
    }
}

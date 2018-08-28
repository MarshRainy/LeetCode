public class Solution17400 {
    public int calculateMinimumHP(int[][] dungeon) {
        int iLength = dungeon.length;
        int jLength = dungeon[0].length;
        int[][] curHP = new int[iLength][jLength];
        int[][] maxHP = new int[iLength][jLength];
        curHP[0][0] = dungeon[0][0];
        maxHP[0][0] = dungeon[0][0];
        for (int i = 0; i < iLength; i++) {
            for (int j = 0; j < jLength; j++) {
                if (i == 0 && j == 0) continue;
                boolean upExist = (i - 1 >= 0);
                int upFromCurHP = 0;
                int upFromMaxHP = 0;
                if (upExist) {
                    upFromCurHP = curHP[i - 1][j] + dungeon[i][j];
                    upFromMaxHP = maxHP[i - 1][j] < upFromCurHP ? maxHP[i - 1][j] : upFromCurHP;
                }
                boolean leExist = (j - 1 >= 0);
                int leFromCurHP = 0;
                int leFromMaxHP = 0;
                if (leExist) {
                    leFromCurHP = curHP[i][j - 1] + dungeon[i][j];
                    leFromMaxHP = maxHP[i][j - 1] < leFromCurHP ? maxHP[i][j - 1] : leFromCurHP;
                }
                if ((upExist && !leExist) ||
                        (upExist && leExist && upFromMaxHP > leFromMaxHP) ||
                        (upExist && leExist && upFromMaxHP == leFromMaxHP && upFromCurHP > leFromCurHP)) {
                    curHP[i][j] = upFromCurHP;
                    maxHP[i][j] = upFromMaxHP;
                } else {
                    curHP[i][j] = leFromCurHP;
                    maxHP[i][j] = leFromMaxHP;
                }
            }
        }
        MTools.print2darray(dungeon);
        MTools.print2darray(curHP);
        MTools.print2darray(maxHP);
        int hp = maxHP[iLength - 1][jLength - 1];
        if (hp <= 0) return 1 - hp;
        else return 1;
    }




    public static void main(String[] args) {
        int[][] dungeon={{1,-3,3},{0,-2,0},{-3,-3,-3}}; // 正确答案是3, 上面是5
        System.out.println(new Solution17400().calculateMinimumHP(dungeon));
        /**
         * 错误分析:
         * 我认为, 每次取路上最大生命值大的是最优解
         * 但是路上最大生命大, 不代表最后一定大, 因为当前的值可能决定之后是否减少的更厉害.
         * 局部最优不是最终最优. 所以不能用动态规划解决. 至少正向的动态规划是不对的.
         */
    }
}

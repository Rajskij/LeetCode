class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] persons = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            persons[trust[i][0]]--;
            persons[trust[i][1]]++;
        }        

        for (int i = 1; i < persons.length; i++) {
            if (persons[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
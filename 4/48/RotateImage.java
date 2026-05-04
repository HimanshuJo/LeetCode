/*
https://leetcode.com/problems/rotate-image/description/?envType=daily-question&envId=2026-05-04
*/

class Solution {
    public void rotate(int[][] matrix) {
        int rows=matrix.length, columns=matrix[0].length;
        int[][]resultantMatrix=new int[rows][columns];
        int colTrvStartIdx=columns-1;
        for(int i=0; i<rows; ++i){
            int[] currentRow=matrix[i];
            int toTraverseIndex=0;
            for(int ii=0; ii<rows; ++ii){
                resultantMatrix[ii][colTrvStartIdx]=currentRow[toTraverseIndex++];
            }
            colTrvStartIdx--;
        }
        for(int i=0; i<rows; ++i){
            for(int j=0; j<columns; ++j){
                matrix[i][j]=resultantMatrix[i][j];
            }
        }
    }
}
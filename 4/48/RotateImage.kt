/*
https://leetcode.com/problems/rotate-image/description/?envType=daily-question&envId=2026-05-04
*/

class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val rows:Int=matrix.size
        val cols:Int=matrix[0].size
        val resultantMatrix=mutableListOf<IntArray>()
        var colTrvStartIdx:Int=cols-1
        for(i in 0 until rows){
            val newRow=IntArray(cols)
            resultantMatrix.add(newRow)
        }
        for(i in 0 until rows){
            val currentRow:IntArray=matrix[i]
            var toTraverseIndex:Int=0
            for(ii in 0 until rows){
                resultantMatrix[ii][colTrvStartIdx]=currentRow[toTraverseIndex++]
            }
            colTrvStartIdx--
        }
        for(i in 0 until rows){
            for(j in 0 until cols){
                matrix[i][j]=resultantMatrix[i][j]
            }
        }
    }
}
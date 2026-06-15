/*
https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=daily-question&envId=2026-06-15
*/

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
        val mutableList=mutableListOf<Int>()
        var tmpHead=head
        while(tmpHead!=null){
            val numberToBeAdded:Int=tmpHead.`val`
            mutableList.add(numberToBeAdded)
            tmpHead=tmpHead.next
        }
        var lengthOfNodes:Int=mutableList.size
        val middleIndex:Int=lengthOfNodes/2
        if(lengthOfNodes==1) return null
        mutableList.removeAt(middleIndex)
        lengthOfNodes=mutableList.size
        val resultantList=ListNode(mutableList[0])
        var tailForResultantList=resultantList
        var beginIndex:Int=1
        while(beginIndex<=lengthOfNodes-1){
            val currentNumber:Int=mutableList[beginIndex]
            val newNode=ListNode(currentNumber)
            tailForResultantList.next=newNode
            tailForResultantList=tailForResultantList.next
            beginIndex++
        }
        return resultantList;
    }
}
/*
https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=daily-question&envId=2026-06-15
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ArrayList<Integer>allNodes=new ArrayList<>();
        while(head!=null){
            allNodes.add(head.val);
            head=head.next;
        }
        int lengthOfNodes=allNodes.size(), middleIndex=lengthOfNodes/2;
        if(lengthOfNodes==1){
            return null;
        }
        allNodes.remove(middleIndex);
        lengthOfNodes=allNodes.size();
        ListNode resultantList=new ListNode(allNodes.get(0));
        ListNode tailForResultantList=resultantList;
        int beginIndex=1;
        while(beginIndex<=lengthOfNodes-1){
            ListNode newNode=new ListNode(allNodes.get(beginIndex));
            tailForResultantList.next=newNode;
            tailForResultantList=tailForResultantList.next;
            beginIndex++;
        }
        return resultantList;
    }
}
/*
https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=daily-question&envId=2026-06-15
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* deleteMiddle(ListNode* head) {
        vector<int>all;
        while(head!=nullptr){
            all.push_back(head->val);
            head=head->next;
        }
        int sz=all.size(), mid=sz/2;
        if(sz==1) return nullptr;
        all.erase(all.begin()+mid);
        sz=all.size();
        ListNode *res=new ListNode(all[0]);
        ListNode *tailForRes=res;
        int idx=1;
        while(idx<=sz-1){
            ListNode *nwNode=new ListNode(all[idx]);
            tailForRes->next=nwNode;
            tailForRes=tailForRes->next;
            idx++;
        }
        return res;
    }
};
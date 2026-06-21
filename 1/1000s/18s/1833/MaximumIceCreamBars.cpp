/*
https://leetcode.com/problems/maximum-ice-cream-bars/?envType=daily-question&envId=2026-06-21
*/

class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        sort(costs.begin(), costs.end());
        int sz=costs.size(), res=0, idx=0;
        while(true){
            if(coins==0||idx>=sz) break;
            if(coins-costs[idx]>=0){
                res++;
                coins-=costs[idx];
            }
            idx++;
        }
        return res;
    }
};
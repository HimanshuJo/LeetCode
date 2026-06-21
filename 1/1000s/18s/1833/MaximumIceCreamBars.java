/*
https://leetcode.com/problems/maximum-ice-cream-bars/?envType=daily-question&envId=2026-06-21
*/

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int lengthOfCosts=costs.length, resultantMaxIceCreams=0, beginIndex=0;
        while(true){
            if(coins==0||beginIndex>=lengthOfCosts) break;
            if(coins-costs[beginIndex]>=0){
                resultantMaxIceCreams++;
                coins-=costs[beginIndex];
            }
            beginIndex++;
        }
        return resultantMaxIceCreams;
    }
}
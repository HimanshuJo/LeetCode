/*
https://leetcode.com/problems/maximum-ice-cream-bars/?envType=daily-question&envId=2026-06-21
*/

class Solution {
    fun maxIceCream(costs: IntArray, coins: Int): Int {
        costs.sort()
        var coinsTracking:Int=coins
        val lengthOfCosts:Int=costs.size
        var resultantMaxIceCreams:Int=0
        var beginIndex:Int=0
        while(true){
            if(coinsTracking==0||beginIndex>=lengthOfCosts) break
            if(coinsTracking-costs[beginIndex]>=0){
                resultantMaxIceCreams++
                coinsTracking-=costs[beginIndex]
            }
            beginIndex++
        }
        return resultantMaxIceCreams
    }
}
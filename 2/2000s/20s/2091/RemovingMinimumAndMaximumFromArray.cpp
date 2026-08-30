/*
https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/?envType=daily-question&envId=2026-08-30
*/

class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        int sz=nums.size(), maxx=INT_MIN, minn=INT_MAX, countLForMax=0, countRForMax=0, fnCount=INT_MAX;
        int idxForMinn=-1;
        for(int i=0; i<sz; ++i){
            maxx=max(maxx, nums[i]);
            if(nums[i]<=minn){
                minn=min(minn, nums[i]);
                idxForMinn=i;
            }
        }
        for(int i=0; i<sz; ++i){
            if(nums[i]==maxx){
                countLForMax++;
                if(idxForMinn<=i){
                    fnCount=min(fnCount, countLForMax);
                }
                if(idxForMinn>i){
                    fnCount=min(fnCount, idxForMinn+1);
                    fnCount=min(fnCount, countLForMax+(sz-idxForMinn));
                }
                break;
            } else{
                countLForMax++;
            }
        }
        for(int i=sz-1; i>=0; --i){
            if(nums[i]==maxx){
                countRForMax++;
                if(idxForMinn>=i){
                    fnCount=min(fnCount, countRForMax);
                }
                if(idxForMinn<i){
                    fnCount=min(fnCount, sz-idxForMinn);
                    fnCount=min(fnCount, countRForMax+(idxForMinn+1));
                }
                break;
            } else{
                countRForMax++;
            }
        }
        return fnCount;
    }
};
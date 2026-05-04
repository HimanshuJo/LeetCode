/*
https://leetcode.com/problems/rotate-image/description/?envType=daily-question&envId=2026-05-04
*/

class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int rws=matrix.size(), cols=matrix[0].size();
        vector<vector<int>>res(rws, vector<int>(cols, 0));
        int colsStrtIdx=cols-1;
        for(int i=0; i<rws; ++i){
            vector<int>currw=matrix[i];
            int trvIdx=0;
            for(int ii=0; ii<rws; ++ii){
                res[ii][colsStrtIdx]=currw[trvIdx++];
            }
            colsStrtIdx--;
        }
        matrix=res;
    }
};
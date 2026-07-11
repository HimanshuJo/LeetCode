/*
https://leetcode.com/problems/count-the-number-of-complete-components/description/?envType=daily-question&envId=2026-07-11
*/

class Solution {
public:

    void dfs(vector<vector<int>>&gr, set<int>&seen, int &currNode, set<pair<int, int>>&curseen, vector<int>&curlst){
        curlst.push_back(currNode);
        seen.insert(currNode);
        for(auto &neighbor: gr[currNode]){
            if(seen.find(neighbor)==seen.end()){
                auto curpr1=make_pair(currNode, neighbor);
                auto curpr2=make_pair(neighbor, currNode);
                if(curseen.find(curpr1)==curseen.end()&&
                   curseen.find(curpr2)==curseen.end()){
                    curseen.insert(curpr1);
                    curseen.insert(curpr2);
                    dfs(gr, seen, neighbor, curseen, curlst);
                }
            }
        }
        return;
    }

    int countCompleteComponents(int n, vector<vector<int>>& edges) {
        int res=0;
        vector<vector<int>>gr(n);
        for(auto &edge: edges){
            gr[edge[0]].push_back(edge[1]);
            gr[edge[1]].push_back(edge[0]);
        }
        set<int>seen;
        for(int i=0; i<n; ++i){
            set<pair<int, int>>curseen;
            bool curflag=true;
            if(seen.find(i)==seen.end()){
                if(gr[i].size()==0){
                    seen.insert(i);
                } else{
                    vector<int>curlst;
                    dfs(gr, seen, i, curseen, curlst);
                    int fnNode=curlst.back();
                    vector<int>allRootsChs=gr[i];
                    allRootsChs.push_back(i);
                    sort(allRootsChs.begin(), allRootsChs.end());
                    vector<int>allFnNodesChs=gr[fnNode];
                    allFnNodesChs.push_back(fnNode);
                    sort(allFnNodesChs.begin(), allFnNodesChs.end());
                    if(allRootsChs!=allFnNodesChs){
                        curflag=false;
                    }
                    if(curflag){
                        for(auto &nei: gr[i]){
                            vector<int>nxtChsToChk=gr[nei];
                            nxtChsToChk.push_back(nei);
                            sort(nxtChsToChk.begin(), nxtChsToChk.end());
                            if(nxtChsToChk!=allRootsChs){
                                curflag=false;
                                break;
                            }
                        }
                    }
                }
                if(curflag) res++;
            }
        }
        return res;
    }
};
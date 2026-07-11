/*
https://leetcode.com/problems/count-the-number-of-complete-components/description/?envType=daily-question&envId=2026-07-11
*/

class Pair{

    public int first;

    public int second;

    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null || getClass()!=obj.getClass()) return false;

        Pair other=(Pair)obj;
        return first==other.first && second==other.second;
    }

    @Override
    public int hashCode(){
        return Objects.hash(first,second);
    }

}

class Solution {

    public static void depthFirstSearch_forNodes(ArrayList<ArrayList<Integer>>graph, 
                                                HashSet<Integer>seenNodes,
                                                int currentNode, 
                                                HashSet<Pair>currSeenPairNodes, 
                                                ArrayList<Integer>currentNodePath){

        currentNodePath.add(currentNode);
        seenNodes.add(currentNode);
        for(int i=0; i<graph.get(currentNode).size(); ++i){
            int currentNeighbor=graph.get(currentNode).get(i);
            if(!seenNodes.contains(currentNeighbor)){
                Pair firstPair=new Pair(currentNode, currentNeighbor);
                Pair secondPair=new Pair(currentNeighbor, currentNode);
                if(!currSeenPairNodes.contains(firstPair)&&
                   !currSeenPairNodes.contains(secondPair)){
                        currSeenPairNodes.add(firstPair);
                        currSeenPairNodes.add(secondPair);
                        depthFirstSearch_forNodes(graph, seenNodes, currentNeighbor, currSeenPairNodes, currentNodePath);
                   }
            }
        }
        return;
    }

    public int countCompleteComponents(int n, int[][] edges) {
        int finalCompConnComponents=0;
        ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
        for(int i=0; i<n; ++i){
            graph.add(new ArrayList<>());
        }
        for(int edge[]: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer>seenNodes=new HashSet<>();
        for(int i=0; i<n; ++i){
            HashSet<Pair>currSeenPairNodes=new HashSet<>();
            boolean isCurrentCompConnected=true;
            if(!seenNodes.contains(i)){
                if(graph.get(i).size()==0){
                    seenNodes.add(i);
                } else{
                    ArrayList<Integer>currentNodePath=new ArrayList<>();
                    depthFirstSearch_forNodes(graph, seenNodes, i, currSeenPairNodes, currentNodePath);
                    int finalNode=currentNodePath.get(currentNodePath.size()-1);
                    ArrayList<Integer>rootWithChildrenNodes=new ArrayList<>(graph.get(i));
                    rootWithChildrenNodes.add(i);
                    Collections.sort(rootWithChildrenNodes);
                    ArrayList<Integer>finalNodesWithChildren=new ArrayList<>(graph.get(finalNode));
                    finalNodesWithChildren.add(finalNode);
                    Collections.sort(finalNodesWithChildren);
                    if(!rootWithChildrenNodes.equals(finalNodesWithChildren)){
                        isCurrentCompConnected=false;
                    }
                    if(isCurrentCompConnected){
                        for(int j=0; j<graph.get(i).size(); ++j){
                            int nxtChild=graph.get(i).get(j);
                            ArrayList<Integer> nextChildrensToCheck=new ArrayList<>(graph.get(nxtChild));
                            nextChildrensToCheck.add(nxtChild);
                            Collections.sort(nextChildrensToCheck);
                            if(!nextChildrensToCheck.equals(rootWithChildrenNodes)){
                                isCurrentCompConnected=false;
                                break;
                            }
                        }
                    }
                }
                if(isCurrentCompConnected) finalCompConnComponents++;
            }
        }
        return finalCompConnComponents;
    }
}
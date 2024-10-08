import java.util.*;

/* toposort is used in DAG(Directed Acylic Graphs) only where vertex u always appear before vertex v*/


public class dfsToposort {
    public static void topoSort(int node,List<List<Integer>> adj,int[] vis,Stack<Integer> st){

        vis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]==-1){
                topoSort(it,adj,vis,st);
            }
        }
        st.push(node);
        return;
    }
    public static List<List<Integer>> createAdjList(int[][] edges,int n){
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            adj.get(u).add(v);

        }
        return adj;
    }
    public static void main(String[] args) {
        int edges[][]={{5,0},{5,2},{2,3},{4,0},{3,1},{4,1}};
        int n=edges.length;
       List<List<Integer>> adj= createAdjList(edges,n);

       int vis[]=new int[n];
       Arrays.fill(vis,-1);
        Stack<Integer> st=new Stack<>();
       for(int i=0;i<n;i++){
           if(vis[i]==-1){
               topoSort(i,adj,vis,st);
           }
       }
       while(!st.isEmpty()){
           System.out.print(st.pop() +" ");
       }
    }
}
      // TC=O(V+E)

import java.util.*;


public class bfsToposort {

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

        //create an indegree array and store the indegree of all nodes
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        //push all nodes with indegree 0 in queue
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        int topo[]=new int[n];
        int i=0;


        while(!q.isEmpty()){
            int top=q.poll();
            topo[i++]=top;

            for(int it:adj.get(top)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        for(int it:topo){
            System.out.print(it+" ");
        }
    }

}

class Solution {
    class Node {
        int to,val;
        public Node(int to,int val){
            this.to = to;
            this.val = val;
        }
    }
    public int reachableNodes(int[][] edges, int maxMoves, int n) {  
        int[] dis = new int[n];
        
        List<Node>[] vec = new List[n];
        
        for(int i=0;i<n;i++){
            vec[i] = new ArrayList<>();
            dis[i] = 123456789;
        }
        
        
        for(int[] arr:edges){
            vec[arr[0]].add(new Node(arr[1],arr[2]+1));
            vec[arr[1]].add(new Node(arr[0],arr[2]+1));
        }
        int tot = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(0);
        dis[0] = 0;
       
        //find shortest distance from source 0
        while(!Q.isEmpty()){
            int id = Q.poll();
            
            for(Node x:vec[id]){
                if(dis[x.to]>dis[id]+x.val){
                    dis[x.to] = dis[id] + x.val;
                    Q.offer(x.to);
                }
            }
        }
        
        // checking if current nodes are reachable with maxMoves
        for(int i=0;i<n;i++){
            if(dis[i]<=maxMoves) tot++;
        }
        
       //checking if newly created nodes can be reachable fwith maxMoves
        for(int[] arr : edges){
            int left = Math.max(0,maxMoves-dis[arr[0]]);
            int right = Math.max(0,maxMoves-dis[arr[1]]);
            
            tot += Math.min(arr[2],left+right);
            
        }
        
        return tot;
        
    }
}

class Solution {
    private int[] subDist;
    private int[] subCount;
    private int N;
    
    private Map<Integer, List<Integer>> nbs = new HashMap<>();
    private int[] res;
    
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N == 1) return new int[]{0};
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            nbs.putIfAbsent(u, new ArrayList<>());
            nbs.putIfAbsent(v, new ArrayList<>());
            nbs.get(u).add(v);
            nbs.get(v).add(u);
        }
        
        this.N = N;
        this.subDist = new int[N];
        this.subCount = new int[N];
        
        postOrder(0, -1);
        
        // alternatively we can reuse the space of subDist
        this.res = new int[N];
        res[0] = subDist[0];
        
        for (int next : nbs.get(0)) {
            preOrder(next, 0);
        }
        return res;
    }
    
    // updating subDist, subCount for each node by post-order traversal
    private void postOrder(int node, int parent) {
        for (int child : nbs.get(node)) {
            if (child == parent) continue;
            
            postOrder(child, node);  // after dfs call, subDist & subCount for nb is calculated
            subDist[node] += (subDist[child] + subCount[child]);
            subCount[node] += subCount[child];
        }
        subCount[node]++;
    }

    // calculate final result for eahc node by pre-Order traversal
    private void preOrder(int node, int parent) {
        // res[node] = subDist[node] + (res[parent] - subDist[node] - subCount[node]) + 
        //             (N - subCount[node]);
        res[node] =  (res[parent]  - subCount[node]) + (N - subCount[node]);
        for (int child : nbs.get(node)) {
            if (child == parent) continue;
            if (child != parent) preOrder(child, node);
        }
    }
}

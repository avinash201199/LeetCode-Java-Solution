class Solution {
    Pair par[][];
    int rank[][];
    public int[][] matrixRankTransform(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        par = new Pair[n][m];
        rank = new int[n][m];
        int ans[][] = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                par[i][j] = new Pair(i,j);
                rank[i][j] = 1;
            }
        }
        
        //row
        for(int i =0;i<n;i++){
            Map<Integer,Pair> map = new HashMap();
            for(int j =0;j<m;j++){
                if(map.get(matrix[i][j])!=null){
                    union(map.get(matrix[i][j]),par[i][j]);
                }else map.put(matrix[i][j],par[i][j]);
            }
        }
        
        //col
        for(int j =0;j<m;j++){
            Map<Integer,Pair> map = new HashMap();
            for(int i =0;i<n;i++){
                if(map.get(matrix[i][j])!=null){
                    union(map.get(matrix[i][j]),par[i][j]);
                }else map.put(matrix[i][j],par[i][j]);
            }
        }
        
        List<Pair> v[][] = new ArrayList[n][m];
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                v[i][j] = new ArrayList();
            }
        }
        
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                Pair x = find(par[i][j]);
                v[x.first][x.second].add(new Pair(i,j));
            }
        }
        TreeMap<Integer,List<List<Pair>>> map = new TreeMap(); // value versus all unions possible 
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                List<List<Pair>> list = map.getOrDefault(matrix[i][j] , new ArrayList());
                list.add(v[i][j]);
                map.put(matrix[i][j],list);
            }
        }
        
        int row[] = new int[n];
        int col[] = new int[m];
        
        for(int key : map.keySet()){
            List<List<Pair>> list = map.get(key);
            for(List<Pair> u : list){
                int x = 0;
                for(Pair a : u){
                    x = Math.max(x,Math.max(row[a.first],col[a.second])+1);
                }
                for(Pair a : u){
                    ans[a.first][a.second] = x;
                    row[a.first] = x;
                    col[a.second] = x;
                }
            }
            
        }
        return ans;
    }
    private Pair find(Pair a){
        Pair pair = par[a.first][a.second];
        if(pair.first==a.first&&pair.second==a.second) return pair;
        return par[a.first][a.second] = find(par[a.first][a.second]);
    }
    private void union(Pair a , Pair b){
        a = find(a);
        b = find(b);
        
        if(rank[a.first][a.second]>rank[b.first][b.second]){
            par[b.first][b.second] = a;
        }
        else if(rank[a.first][a.second]<rank[b.first][b.second]){
            par[a.first][a.second] = b;
        }else{
            par[a.first][a.second] = b;
            rank[b.first][b.second]++;
        }
    }
}
class Pair{
    int first;
    int second;
    
    public Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}

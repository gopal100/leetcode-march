/*
https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
1337. The K Weakest Rows in a Matrix

*/

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Data> list = new ArrayList<>();
        
        for(int i =0; i< mat.length; i++){
            int cnt = 0;
            for(int j =0; j< mat[i].length; j++){
                if(mat[i][j] == 1)
                    cnt++;
            }
            Data data = new Data(i, cnt);
            list.add(data);
        }
        
        Collections.sort(list, (a, b) -> {
            if(a.soldiers == b.soldiers)
                return a.row-b.row;
            else
                return a.soldiers - b.soldiers;
        });
        
        int[] result = new int[k];
        for(int i =0; i< k; i++){
            result[i] = list.get(i).row;
        }
        
        return result;
    }
}

class Data{
    public int soldiers;
    public int row;
    
    public Data(int row, int soldiers){
        this.soldiers = soldiers;
        this.row = row;
    }
}
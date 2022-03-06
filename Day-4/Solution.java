/*
https://leetcode.com/problems/champagne-tower/

Champagne Tower

*/

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        List<List<Double>> list = new ArrayList<>();
        
        for(int i =1; i< query_row+2; i++){
            List<Double> ls = new ArrayList<>(i);
            int j = i;
            while(j-->0){
                ls.add(0.0);
            }
            list.add(ls);
        }
        
        list.get(0).set(0, (double)poured);
        
        for(int i=0; i<query_row; i++){
            for(int j = 0; j<list.get(i).size(); j++){
                double temp = (list.get(i).get(j) -1)/2;
                if(temp> 0){
                    list.get(i+1).set(j, list.get(i+1).get(j)+temp);
                    list.get(i+1).set(j+1, list.get(i+1).get(j+1)+temp);
                }
                
            }
        }
        
        return list.get(query_row).get(query_glass) <= 1 ? list.get(query_row).get(query_glass) : 1.0;
    }
}
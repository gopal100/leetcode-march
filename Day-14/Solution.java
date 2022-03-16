/*
https://leetcode.com/problems/simplify-path/
71. Simplify Path
*/

class Solution {
    public String simplifyPath(String path) {
        List<String> list = new ArrayList<>();
        String result = "";
        for(int i =0; i< path.length(); i++){
            String res ="";
            
            while(i<path.length() && path.charAt(i) != '/'){
                res += path.charAt(i);
                i++;                
            }
            
            if(res.equals("..")){
                if(list.size() > 0)
                    list.remove(list.size()-1);
            }
            else if(res.equals(".")|| res.equals("")){
                
            }
            else{
                list.add(res);
            }
        }
        
        for(String s: list){
            result+= "/"+ s;
        }        
        
        if(result.equals(""))
            result = "/";
        return result;
    }
}
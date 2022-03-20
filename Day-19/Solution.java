/*
https://leetcode.com/problems/maximum-frequency-stack/
Maximum Frequency Stack
*/

class FreqStack {
    
    Map<Integer, Integer> map = null;
    Map<Integer, Stack<Integer>> stack= null;
    int maxFreq = 0;
    public FreqStack() {
        map = new HashMap<>();
        stack = new HashMap<>();
    }
    
    public void push(int val) {
        int freq =  map.getOrDefault(val, 0)+1;
        map.put(val, freq);
        maxFreq = Math.max(maxFreq, freq);
        if(stack.get(freq) == null){
            Stack<Integer> st = new Stack<>();
            st.push(val);
            stack.put(freq, st);
        }else{
            Stack<Integer> st = stack.get(freq);
            st.push(val);
            stack.put(freq, st);
        }
    }
    
    public int pop() {
        int freqToPop = maxFreq;
        Stack<Integer> st = stack.get(freqToPop);
        int ele = st.pop();
        if(st.isEmpty())
            maxFreq--;
        else
            stack.put(freqToPop, st);
        map.put(ele, map.get(ele)-1);
        return ele;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
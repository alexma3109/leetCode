class MinStack {
    private Stack<Integer> s1 = new Stack<Integer>();
    private Stack<Integer> s2 = new Stack<Integer>();
    public void push(int x) {
        s1.push(x);
        if(s2.isEmpty() || s2.peek() >= x){
            s2.push(x);
        }
    }

    public void pop() {
        if(!s1.isEmpty()){
            if(s1.peek() <= s2.peek()){
                s2.pop();
            }
            s1.pop();
        }
    }

    public int top() {
        if(!s1.isEmpty()){
            return s1.peek();
        }
        return -1;
    }

    public int getMin() {
        if(!s2.isEmpty()){
            return s2.peek();
        }
        return -1;
    }
}

class MyStack {
    private Queue<Integer> q;
    private int size;
    public MyStack() {
        size = 0;
        q = new LinkedList<Integer>();
    }
    // Push element x onto stack.
    public void push(int x) {
        q.offer(x);
        size++;
    }

    // Removes the element on top of the stack.
    public void pop() {
        int count = size - 1;
        while(count > 0){
            int temp = q.poll();
            q.offer(temp);
            count--;
        }
        q.poll();
        size--;
    }

    // Get the top element.
    public int top() {
        int count = size;
        int temp = 0;
        while(count > 0){
            temp = q.poll();
            q.offer(temp);
            count--;
        }
        return temp;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return size == 0;
    }
}
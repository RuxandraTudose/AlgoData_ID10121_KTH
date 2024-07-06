public class heap2 {
    Node root;

    public class Node {
        int size = 0;
        int priority;
        Node left, right;

        private Node(int p) {
            priority = p;
            left = null;
            right = null;
        }

        private void add(int pr) {
            size += 1;
            if (pr < priority) { 
                int temp = priority;
                priority = pr;
                pr = temp; // swaps values
            }
            //System.out.println("b");
            if (left == null) {
                left = new Node(pr);
                System.out.println("new left node" + pr);
                return;
            }
            if (right == null) {
                right = new Node(pr);
                System.out.println("new right node" + pr);
                return;
            }
            if(left.size < right.size) {
                left.add(pr);
            }
            else{
                right.add(pr);
            }
        }


        private Node remove() {
            size -= 1;
            if (right == null)
                return left;
            if (left == null)
                return right;
            if (left.priority < right.priority) {
                this.priority = left.priority;
                left = left.remove();
            }
            else {
                this.priority = right.priority;
                right = right.remove();
            }
            return this;
        }
    }

    public void queue(int pr) {
        if (root == null) {
            root = new Node(pr);
        }
        else {
            root.add(pr);
        }

    }

    public int dequeue() { 
        if (root == null) { // if root of heap is null
            return -1;
        }
        int prod = root.priority;
        root = root.remove();
        return prod;

    }

      public static void main(String[] args) throws Exception {
        heap2 heap = new heap2();
        heap.queue(6);
        heap.queue(56);
        heap.queue(34);
        heap.queue(12);
        heap.queue(4);
        heap.queue(6);

        int p = heap.dequeue();
        while (p != -1) {
            System.out.println(p);
            p = heap.dequeue();
        }
    }
}
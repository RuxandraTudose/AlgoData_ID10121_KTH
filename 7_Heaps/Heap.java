public class Heap {
    Node root;

    private class Node {
        int size = 0;
        int prio;
        Node left, right;

        private Node(int p) {
            prio = p;
            left = null;
            right = null;
        }

        private void add(int pr) {
            size += 1;
            if (pr < prio) {
                int temp = prio;
                prio = pr;
                pr = temp;
            }

            if (right != null) {
                if (left != null)
                    if (left.size < right.size)
                        left.add(pr);
                    else
                        right.add(pr);

                else {
                    left = new Node(pr);
                }
            } else
                right = new Node(pr);
        }

        private Node remove() {
            size -= 1;
            if (right == null)
                return left;
            if (left == null)
                return right;
            if (left.prio < right.prio) {
                this.prio = left.prio;
                left = left.remove();
            } else {
                this.prio = right.prio;
                right = right.remove();

            }
            return this;
        }

        public int push(int depth) {

            depth++;
            
            if (this.left == null || this.right == null)
                return depth;

            if (this.prio > this.left.prio) {
                int temp = this.prio;
                this.prio = this.left.prio;
                this.left.prio = temp;
                depth = this.left.push(depth);
            }
            
            if (this.prio > this.right.prio){
                int temp = this.prio;
                this.prio = this.right.prio;
                this.right.prio = temp;
                depth = this.right.push(depth);
            }

            return depth;
        }
    }

    public void add(int p) {
        if (root == null) {
            root = new Node(p);
        } else {
            root.add(p);
        }
    }

    public int remove() {
        if (root == null) {
            return -1;
        }
        int p = root.prio;
        root = root.remove();
        return p;
    }

    public int push(int incr) {

        if (root == null)
            return -1;
        root.prio += incr;
        int depth = 0;
        return root.push(depth);
    }

    public Heap () {
        root = null;
    }

    public void resetHeap() {
        root = null;
    }


    public static void main(String[] args) throws Exception {
        Heap heap = new Heap();
        /*heap.add(6);
        heap.add(14);
        heap.add(10);
        heap.add(12);
        heap.add(4);
        heap.add(17);
        heap.add(23);
        heap.add(25);*/

        heap.add(6);
        heap.add(14);
        heap.add(20);

        System.out.print(heap.push(38) + "? ");
        System.out.println();

        int p = heap.remove();
        while (p != -1) {
            System.out.println(p);
            p = heap.remove();
        }
    }
}


// low no high priority
// not sorted - dequeue - travers firnd the lowest - display it
/*
 * unsorted - o n add
 * o 1 remove
 * 
 * unsorted O n remove
 * o 1 add
 * 
 * //unsorted better one
 * more adds operation
 * 
 * -------- sorted tree -------
 * 
 * lg n for both enqueue deqeue
 * could become left right heavy
 * priority always the root - heap //diff way of sorting a tree
 * 
 * ------- complete tree
 * 
 */

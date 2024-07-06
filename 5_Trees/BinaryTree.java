import java.util.Iterator;
import java.util.Stack;

public class BinaryTree implements Iterable<Integer> {

    public class Node {

        public Integer key;
        public Integer value;
        public Node left;
        public Node right;

        public Node(Integer key, Integer value) { 
            this.key = key;
            this.value = value;
            this.left = this.right = null; 
        }

        private void add (Integer key , Integer value) { 
            if (this.key == key) {
                this.value = value ;
                return;
            }
            if (this.key > key) {
                if(this.left == null)
                    this.left = new Node(key, value);
                else
                    this.left.add(key, value);   
            }
            else {
                if(this.right == null)
                    this.right = new Node(key, value);
                else
                    this.right.add(key,value);    
            }
        }    

        public Integer lookup(Integer key) {
            
            if(this.key == key) {
                return this.value;
            }
            else {
                if(this.key > key)
                    if(this.left != null)
                        return this.left.lookup(key);
                if(this.key < key)
                    if(this.right != null)
                        return this.right.lookup(key);    
            }

            return null;
        }

        public void print() {
           
            if(left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if(right != null)
                 right.print();
            }
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public void add (Integer key, Integer value) {
        if(root == null) {
            root = new Node(key, value);
        }
        else {
            root.add(key,value);
        }
    }

    public Integer lookup (Integer key) {
    
        return root.lookup(key);
    }

    public void print() {

        root.print(); 
    }

    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }

    public class TreeIterator implements Iterator<Integer> {

        private Node next;
        private LinkedSimple<Node> stack = new LinkedSimple<Node>();

        public TreeIterator() {
            next = root;
            while(next.left != null) {
                stack.push(next);
                next = next.left;
            }
        }

        @Override
        public boolean hasNext() {
            return (next != null);   
        }

        @Override
        public Integer next() {
            Integer n = next.value;
            nextStep();
            return n;
        }

        public boolean isLeaf(Node n) {

            if(n.left == null && n.right == null)
                return true;
            else
                return false;    
        }

        public void nextStep() {
            if(next.right != null ) {
                next = next.right;
                while(next.left != null) {
                    stack.push(next);
                    next = next.left;
                }
                
                return;
            }

            if(isLeaf(next) == true) {
                try{
                    next = stack.pop();
                }catch(IllegalArgumentException e) {
                    next = null;
                }

                return;
            }

            if(next != null) {
                try{
                    next = stack.pop();
                }catch(IllegalArgumentException e) {
                    next = null;
                }
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } 

    public static void main(String[] args) { 
    
        BinaryTree tree = new BinaryTree();
        tree.add(5,105);
        tree.add(2,113);
        tree.add(7,107);
        tree.add(14,101);
        tree.add(8,20);
        tree.add(6,106);
        tree.add(3,103);

        for (int i : tree)
            System.out.println("next value " + i);

        tree.add(17,3);
        tree.add(13,17);
        tree.add(9,16);    

        System.out.println();

        for (int i : tree) {
            tree.add(25,9);  
            System.out.println("next value " + i);
        }
            
    }
}


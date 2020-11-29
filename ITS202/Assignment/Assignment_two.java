import java.util.*;

public class Assignment_two<Key extends Comparable<Key>, Value>{
    private Node root;              // root of BST

    private class Node{
        private Key key;            //sorted by key
        private Value val;          //associated data
        private Node left,right;    //left and right subtrees
        private int size;           //number of nodes in subtree

        public Node(Key key, Value val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    //Initializes an empty symbole table.
    public Assignment_two(){
        root = null;
    }

    //returns true if this symbol table is empty
    public boolean isEmpty(){
        if(size()==0) return true;
        return false;

    }

    //return the number of key-value paris in this symbol table
    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null) return 0;
        return x.size;
    }

    /*Inserts the specified key-value pair into the symbol table comparing the 
    key from root, overwriting the old value with the new value if the symbol 
    table contains the specified key.*/

    public void put(Key key, Value val){
        if(key == null) throw new IllegalArgumentException("first argument to put() is null");
        Node x,y=null,tem = new Node(key, val, 1);

        if (root == null) {
            root = tem;
            return;
        }

        
        //check if the key exist and replace the value and stop so that it does not increment the size
        if(check(root, key, val)) return;

        int com = key.compareTo(root.key);  

        //travers through tree and compareing key
        for(x=root; x!=null; x=increment(x, com)){
            y = x;
            //incrementing the size of main root
            y.size++;
            com = key.compareTo(x.key);
        }

        /*here we need y because after the termination of loop, 
        x is null and when inserting the tem node to x.left or 
        x.right it gives nullpointer exception*/ 
        if(com<0) y.left = tem;
        if(com>0) y.right = tem;

        //incrementing the size of subtree(need in select() method)
        y.size = 1 + size(y.left) + size(y.right);

    }

    //return true if the value key exist if false
    private boolean check(Node x, Key key, Value val){
        
        while(x!=null){
            int com = key.compareTo(x.key);
            if(com<0) x=x.left;
            else if(com>0) x=x.right;
            else{
                x.val = val;
                return true;
            }
        }
        return false;
    }

    //return the associate value of key if key exist else null
    public Value get(Key key){
        Node x;
        if(key == null ) throw new IllegalArgumentException("argument to get() is null");
        if(size()==0) throw new NoSuchElementException("called get() with empty symbol table");

        int com = key.compareTo(root.key);  

        for(x=root; x!=null; x=increment(x, com)){
            com = key.compareTo(x.key);
            if(com==0){
                return x.val;
            }
        }

        return null;
    }

    //return the smallest key from the tree
    public Key min(){
        if(isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return min(root).key;
    }

    //travers through the tree and return Node with smallest key
    private Node min(Node x){
        if(x.left == null) return x;
        for(x=x;x!=null;x=x.left){
            if(x.left == null) return x;
        }

        return x;
    }

    //returns the largest key in the symbol table less than or equal to given key.
    public Key floor(Key key){
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }

    /*travers through the tree return the Node whose key is less or equal 
    to given key but greatest key compare to other key in the tree. if the given key
    does not have floor key it will return null*/

    private Node floor(Node p, Key key){
        Node z=null,x,floor = min(p);

        int com = key.compareTo(p.key);

        for(x=p; x!=null; x=increment(x, com)){
            com = key.compareTo(x.key);
            
            //check if the key is greater or equal to key of x node
            if(com>=0){
                int cmp = floor.key.compareTo(x.key);
                //if the key of node x is greater than floor key then set floor to x
                if(cmp <= 0){
                    floor = x;
                    z = floor;
                }
            }
        }

        return z;
    }

    //return the key of a rank assoicated to it. rant range is from 0(include) to size(root)-1.
    public Key select(int rank){

        if(rank<0 || rank>=size()) throw new NoSuchElementException("rank out of limit");

        Node temp = select(root, rank);
        if(temp!=null) return temp.key;
        return null;
    }

     //return the Node associated to given rank else null
    private Node select(Node x, int rank){
        while(x!=null){
            int size = size(x.left);

            /*if the size of left node is greater then given rank 
            it means that the rank is at left so set x node to left node*/
            if(size > rank) x = x.left;

            /*if the given rank is greater than size of left node that means the
            key associate to rank is at right so set x to right node*/
            else if(size < rank){
                x = x.right;
                rank = rank - size - 1;
            }
            /*if the t is equal to rank return current node*/
            else return x;
        }
        return null;
    }

    //return all the key between lo and hi includeing both
    public Iterable<Key> keys(Key lo, Key hi){
        if(lo==null || hi==null) throw new IllegalArgumentException("argument to keys() is null");

        Queue<Key> queue_list = new LinkedList<Key>();
        keys(root, queue_list, lo, hi); 
        return queue_list;
    }

    //travers thought the tree and add key to the queue if the key>=lo && key<=hi
    private void keys(Node x, Queue<Key> queue_list, Key lo, Key hi){ 
        if (x == null) return;  
        
        Node node1 = x;  
        //travers through the tree until the Node is null
        while (node1 != null){  
      
            int cmp = node1.key.compareTo(hi);
            int cam = node1.key.compareTo(lo);

            /*if the left node is null set temp1 to right node of itself 
            add the key to key if key is in the range*/
            if (node1.left == null){   
                if (cmp <= 0 && cam >= 0)  queue_list.offer(node1.key);
                node1 = node1.right;

            /*if the left node of temp1 is not null assign temp1.left and initializes temp2*/
            }else{  
                Node node2 = node1.left;
                /*check if the right node of temp2 which is temp1.left.right is null && queal to 
                temp1 if not assign the right node of temp2 to itself(temp2)*/
                while (node2.right != null && node2.right != node1)  
                    node2 = node2.right;  
        
                /*in second while loop if the loop terminates due first condiction only or both 
                then enter here*/
                if (node2.right == null){  
                    node2.right = node1;  
                    node1 = node1.left; 
            
                /*if the temp2.right is equals to temp1 then set temp2.right to null and if the
                the key is in range add to queue and set temp1 to right node of itself*/
                }else{  
                    node2.right = null;    
                    if (cmp <= 0 && cam >= 0)  queue_list.offer(node1.key);  
                    node1 = node1.right;  
                }  
            }  
        }   
    }

    //use to traverse through tree using for loop
    private Node increment( Node x, int com){
        if(com<0) return x.left;
        if(com>0) return x.right;
        return null;
    }


    public static void main(String[] args){
        Assignment_two<String, Integer> obj = new Assignment_two<>();

        obj.put("ABDUL",1);
        System.out.println(obj.get("ABDUL"));

        obj.put("HRITHIK",2);
        obj.put("SAI",3);
        obj.put("SAMAL",6);
        System.out.println(obj.get("SAI"));

        obj.put("TASHI",4);
        System.out.println(obj.size());
        System.out.println(obj.min());
        System.out.println(obj.floor("HRITHIK"));
        System.out.println(obj.floor("HAHA"));
        System.out.println(obj.select(2));

        for (String s : obj.keys("ABDUL","TASHI"))
            System.out.print(s+" ");
        System.out.println();

        obj.put("CHIMI",5);
        obj.put("SAMAL",4);
        System.out.println(obj.get("SAMAL"));
        obj.put("NIMA",7);
        System.out.println(obj.size());
        System.out.println(obj.get("CHIMI"));
        System.out.println(obj.floor("CHIMA"));
        obj.put("SONAM",8);

        for (String s : obj.keys("ABDUL","TASHI"))
            System.out.print(s+" ");
        System.out.println();

    } 

}

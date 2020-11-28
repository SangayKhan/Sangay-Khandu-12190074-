import java.util.*;

public class Assignment_two<Key extends Comparable<Key>, Value>{
    private Node root;				// root of BST

    private class Node{				
        private Key key;            //sorted by key
        private Value val;         //associated data
        private Node left, right;   //left and right subtrees
        private int size;			//number of nodes in subtree

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
	table already contains the specified key.*/

    public void put(Key key, Value val){
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (root == null) {
            root = new Node(key, val, 1);
            return;
        }
 		//check if the key exist and replace the value and stop so that it does not increment the size
        if(value_replace(root, key, val)) return;

        Node node = null, x = root,z = new Node(key, val, 1);
        //travers through tree and compareing key
        while (x != null) {
            node = x;

            int com = key.compareTo(node.key);
            if      (com < 0){
            	//incrementing the size of main root
        		node.size++;
            	x=x.left;

            }
            if (com > 0){
            	//incrementing the size of main root
        		node.size++;
            	x=x.right;
            }
        }
        //inserting the Node
        int com = key.compareTo(node.key);
        if (com < 0) node.left  = z;
        else         node.right = z;
        //incrementing the size of subtree
        node.size = 1+size(node.left)+size(node.right);
    }

    //
    private boolean value_replace(Node x, Key key, Value val){
    	
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
    	if(key == null ) throw new IllegalArgumentException("argument to get() is null");
		if(size()==0) throw new NoSuchElementException("called get() with empty symbol table");

        Node x = root;
        while(x != null){
            int com = key.compareTo(x.key);
            if      (com < 0) x = x.left;
            else if (com > 0) x = x.right;
            else return x.val;
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

    private Node floor(Node x, Key key){
    	/*Node floor is the min node of the tree, we can compare key of floor
    	with other keys in tree to stor the floor key of given key*/
    	Node z=null,floor = min(x);

        while(x != null){
        	int com = key.compareTo(x.key);

        	/*no need to put extra condiction here as the given key should be greater 
        	or equal to floor key but it is small so just set x to x.left*/
            if(com < 0) x = x.left;

            /*at right node the keys are small than the given key but we need to store the key
            which is greater than other keys in tree and less than given key*/
            else if (com > 0){
            	int cmp = floor.key.compareTo(x.key);

            	//if the key of node x is greater than floor key then set floor to x
            	if(cmp<=0){
            		floor = x;
            		z = floor;
            	}
            	x = x.right; 
            }
            else return x;
        }
        //if there is no floor key then return null(z=null)
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
    		int t = size(x.left);

    		/*if the size of left node is greater then given rank 
    		it means that the rank is at left so set x node to left node*/
    		if(t>rank) x = x.left;

    		/*if the given rank is greater than size of left node that means the
    		key associate to rank is at right so set x to right node*/
    		else if(t<rank){
    			x = x.right;
    			rank = rank-t-1;
    		}

    		/*if the t is equal to rank return current node*/
    		else return x;
    	}
    	return null;

    }

    //return all the key between lo and hi includeing both
    public Iterable<Key> keys(Key lo, Key hi){
    	if(lo==null || hi==null) throw new IllegalArgumentException("argument to keys() is null");

    	Queue<Key> queue = new LinkedList<Key>();
    	keys(root, queue, lo, hi);	
		return queue;
    }

    //travers thought the tree and add key to the queue if the key>=lo && key<=hi
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi){ 
    	if (x == null) return;  
  		
    	Node temp1 = x;  
  		//travers through the tree until the Node is null
    	while (temp1 != null){  
	  
	  		int cmp = temp1.key.compareTo(hi);
	        int cam = temp1.key.compareTo(lo);

	        /*if the left node is null set temp1 to right node of itself 
	        add the key to key if key is in the range*/
	        if (temp1.left == null){   
	            if (cmp <= 0 && cam >= 0)  queue.offer(temp1.key);
	        	temp1 = temp1.right;

	        /*if the left node of temp1 is not null assign temp1.left and initializes temp2*/
	        }else{  
	            Node temp2 = temp1.left;
	            /*check if the right node of temp2 which is temp1.left.right is null && queal to 
	            temp1 if not assign the right node of temp2 to itself(temp2)*/
	            while (temp2.right != null && temp2.right != temp1)  
	                temp2 = temp2.right;  
	  	
	  			/*in second while loop if the loop terminates due first condiction only or both 
	  			then enter here*/
	            if (temp2.right == null){  
	                temp2.right = temp1;  
	                temp1 = temp1.left; 

	            /*if the temp2.right is equals to temp1 then set temp2.right to null and if the
	            the key is in range add to queue and set temp1 to right node of itself*/
	            }else{  
	                temp2.right = null;    
	                if (cmp <= 0 && cam >= 0)  queue.offer(temp1.key);  
	                temp1 = temp1.right;  
	            }  
	        }  
	    }   
    }

    public static void main(String[] args){ 
        
        Assignment_two<String, Integer> outer = new Assignment_two<String, Integer>();
        
       	outer.put("ABDUL",1);
       	System.out.println(outer.get("ABDUL"));

       	outer.put("HRITHIK",2);
       	outer.put("SAI",3);
		outer.put("SAMAL",6);
		System.out.println(outer.get("SAI"));

		outer.put("TASHI",4);
		System.out.println(outer.size());
		System.out.println(outer.min());
		System.out.println(outer.floor("HRITHIK"));
		System.out.println(outer.floor("HAHA"));
		System.out.println(outer.select(2));

		for (String s : outer.keys("ABDUL","TASHI"))
            System.out.print(s+" ");
        System.out.println();

        outer.put("CHIMI",5);
        outer.put("SAMAL",4);
        System.out.println(outer.get("SAMAL"));
        outer.put("NIMA",7);
        System.out.println(outer.size());
        System.out.println(outer.get("CHIMI"));
        System.out.println(outer.floor("CHIMI"));
        outer.put("SONAM",8);

        for (String s : outer.keys("ABDUL","TASHI"))
            System.out.print(s+" ");
        System.out.println();

    }

}

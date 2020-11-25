import java.util.NoSuchElementException;

public class try3<Key extends Comparable<Key>, Value>{
	private Node root;

	private class Node{
		private Key key;
		private Value val;
		private Node left, right;
		private int size;

		public Node(Key key, Value val, int size){
			this.key = key;
			this.val = val;
			this.size = size;
		}
	}

	public int size(){
        return size(root);
    }

    private int size(Node x){
        if (x == null) return 0;
        else return x.size;
    }


	public void put(Key key, Value val){
		int com;
		if (key == null) throw new IllegalArgumentException("first argument to put() is null");
		if(root == null) root = new Node(key, val, 1);

		com = key.compareTo(root.key);
		if(com<0) left_put(root, key, val);
		else if(com>0) right_put(root, key, val);
		else root.val = val;
	}

	private void left_put(Node x, Key key, Value val){

		if(x.left == null) x.left = new Node(key, val,++root.size);
		else if(x.left != null){

			for(x=x; x!=null; x=x.left){
				if(x.val == null) delete(x, x.key);

				if(key == x.key){
					x.val = val;
					return;
				}

				if(x.left == null){
					x.left = new Node(key, val,++root.size);
					break;

				}
			}
		}
	}

	private void right_put(Node x, Key key, Value val){

		if(x.right == null) x.right = new Node(key, val,++root.size);
		else if(x.right != null){

			for(x=x; x!=null; x=x.right){
				if(x.val == null) delete(x, x.key);

				if(key == x.key){
					x.val = val;
					return;
				}

				if(x.left == null){
					x.left = new Node(key, val,++root.size);
					break;

				}
			}
		}
	}

	public Value get(Key key){
		if(key == null ) throw new IllegalArgumentException("argument to get() is null");
		if(size()==0) throw new NoSuchElementException("called get() with empty symbol table");
		return get(root, key);
		
	}

	private Value get(Node x, Key key) {
    	int com;
        com = key.compareTo(x.key);
		if(com<0) return left_get(x, key);
		else if(com>0) return right_get(x, key);
		
		return x.val;
        
    }

    private Value left_get(Node x, Key key){

    	for(x=x;x!=null;x=x.left){
    		if(x.left==null && x.key!=key) return null;
    		if(x.key==key) return x.val;
    	}
    	return null;
    }

    private Value right_get(Node x, Key key){

    	for(x=x;x!=null;x=x.right){
    		if(x.right==null && x.key!=key) return null;
    		if(x.key==key) return x.val;
    	}
    	return null; 
    }

    public Key min(){
    	if(size()==0) throw new NoSuchElementException("called min() with empty symbol table");
    	return min(root).key;
    }

    private Node min(Node x){
    	if(x.left == null) return x;
    	for(x=x;x!=null;x=x.left){
    		if(x.left == null) return x;
    	}

    	return x;
    }

    public void delete(Key key) {
        if(key == null) throw new IllegalArgumentException("argument to delete() is null");
        if(size()==0) throw new NoSuchElementException("called delete() with empty symbol table");
        delete(root, key);
    }

    private void delete(Node x, Key key) {
    	int com;
    	Node tem = null,y;
    	com = key.compareTo(x.key);
    	if(com<0) left_delete(x, key);
    	else if(com>0) right_delete(x, key);

    }

    private void left_delete(Node x, Key key){
    	Node tem = null,y;
        for (y = x; y!=null && (y.key != key); y=y.left) {
                tem = y;
            }

        if(y == null) return;
        tem.left = y.left;
    }

    private void right_delete(Node x, Key key){
    	Node tem = null,y;
        for (y = x; y!=null && (y.key != key); y=y.right) {
                tem = y;
            }

        if(y == null) return;
        tem.right = y.right;
    }




	public static void main(String[] args){
		try3<String, Integer> outer = new try3<>();
		//try3.Node inner = outer.new Node("Sangay Khandu.",12190074);

		outer.put("b",12190075);
		outer.put("a",12190074);
		outer.put("",12190070);
		outer.put("P",null);
		//outer.put("A",12190010);
		

		System.out.println(outer.size());

		System.out.println(outer.get(""));
		System.out.println(outer.get("b"));
		System.out.println(outer.get("a"));
		System.out.println(outer.get("P"));
		System.out.println(outer.get("x"));

		System.out.println(outer.min());

	}

}

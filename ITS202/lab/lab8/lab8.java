import java.util.*;

public class lab8<Key, Value>{
	private static final int INIT_CAPACITY = 4;

	private int n=0;
	private int m;
	private SequentialSearchST<Key, Value>[] st;

	public lab8(int m){
		this.m = m;
	 	st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
	 	for(int i=0;i<m;i++) st[i] = new SequentialSearchST<Key, Value>();
	 //this.(INIT_CAPACITY);
	}

	public void resize(int chains){
		this.m = chains;
	}

	

	public int size(){
		return n;
	}

	public boolean isEmpty(){
		if(n==0) return true;
		return false;
	}

	public boolean contains(Key key){
		if (get(key)!=null) return true;
		return false;
	}

	public void put(Key key, Value val){
		if(key==null) throw new IllegalArgumentException("first argument to put() is null");
		int mod = (int)key%m;
		st[mod].put(key, val);
		for(int i=0;i<m;i++){
			n += st[i].size();
		}
	}

	public Value get(Key key){
		int mod = (int)key%m; Value val = null;
		for(int i=0;i<m;i++){
			if(mod==i){
				val = st[i].get(key);
			}
		}

		return val;
	}

	public void delete(Key key){
		if(key==null) throw new IllegalArgumentException("arrgumen to delete is null");
		if(size()==0) throw new NoSuchElementException("method called before hash table 0");
		int mod = (int)key%m;

		for(int i=0;i<m;i++){
			if(mod==i){
				st[i].delete(key);
			}
		}
	}

	public Iterable<Key> key(){
		Queue<Key> queue = new LinkedList<Key>();
		for(int i=0;i<m;i++){
			queue.offer(st[i].keys());
		}

		return queue;
	}

	public static void main(String[] args) {
		lab8<String, Integer> obj = new lab8<String, Integer>(5);

		obj.put("A",5);
		obj.put("B",7);
		obj.put("C",8);
		obj.put("D",9);
		//obj.put(null,6);
		System.out.println(obj.size());
		System.out.println(obj.isEmpty());
		System.out.println(obj.contains("A"));
		System.out.println(obj.get("A"));
		obj.delete("A");
		System.out.println(obj.get("A"));
		System.out.println(obj.get("B"));
		System.out.println(obj.get("C"));
	}

}

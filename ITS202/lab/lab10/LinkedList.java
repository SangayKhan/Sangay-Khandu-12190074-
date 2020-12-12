import java.util.*;
public class LinkedList<Key> {

    int size;
    Node head;

    public LinkedList() {
        size = 0;
        head = null;
    }

    //node class
    class Node{
        Key key;
        Node next;

        public Node(Key key, Node next){
            this.key = key;
            this.next = next;
        }

    }

    public int size() {
        return size;
    }

    public void put(Key key) {

        Node newest = new Node(key, null);

        if (head == null) {
            head = newest;
            size ++;
        }
        else if (head.next==null || head.next!=null) {
                for (Node x = head; x!=null; x=x.next) {
                    if (key == x.key) return;       
                } 
                newest.next = head;
                head = newest;
                size++;       
        }
        
    }

    public Iterable<Key> keys()  {
        ArrayList<Key> queue = new ArrayList<Key>();
        for (Node x = head; x != null; x = x.next)
            queue.add(x.key);
        return queue;
    }
    
}


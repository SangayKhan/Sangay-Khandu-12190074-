import java.util.NoSuchElementException;

public class lab1 {
    private final int V;                  // number of vertices in this digraph
    private int E;                        // number of edges in this digraph
    private LinkedList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;               // indegree[v] = indegree of vertex v
    
    public lab1(int V) {
    	this.V = V;
    	this.E = 0;

        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for(int i=0;i<V;i++) adj[i] = new LinkedList<Integer>();
    }    
            
    public int V() {
       return V;
    }
    
    public int E() {
        for(int i=0;i<V;i++){
            E +=adj[i].size();
        }
        return E;
    }

    private void validateVertex(int v) {
    	if(v<0 || v>=V) throw new IllegalArgumentException("Vertex value cannot be <0 or >= V");
    }
    
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].put(w);
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v].keys();
    }
   
/*    public lab1 reverse() {
        
    }
    
    public String toString() {

    }*/

    public static void main(String[] args) {

        lab1 obj = new lab1(5);
        obj.addEdge(1,3);
        obj.addEdge(1,4);
        obj.addEdge(1,2);
        obj.addEdge(1,0);

        obj.addEdge(4,0);
        obj.addEdge(4,3);
        obj.addEdge(4,2);
        //obj.addEdge(4,4);

        int vertex = 1;
        for(int i: obj.adj(vertex))
            System.out.println(vertex+" -> "+i);

        System.out.println(obj.E());

    }

}

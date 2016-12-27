//Jose Mora 
//5-25-16
import java.util.*;
public class Graph<E> implements Cloneable {
	
	private E[] vertexList;
	private LinkedList<EdgeNode>[] edges;
	private int numEdges[];

		
	@SuppressWarnings("unchecked")
	public Graph(int n) { //default constructor
		edges = (LinkedList<EdgeNode>[]) new LinkedList[n];
		for(int i = 0; i < n; i++) {
			edges[i] = new LinkedList();
		}
		vertexList = (E[]) new Object[n];
		numEdges = new int[n];
	}
	
	public void addEdge(int source, int target) { //add new link
			((LinkedList<EdgeNode>)edges[source]).addLast(new EdgeNode(target));
			numEdges[source]++;
	}
	
	public E getLabel(int vertex) { //return label for vertex 
		return vertexList[vertex];
	}
	
	public boolean isEdge(int source, int target) { //checks to see if edge exists between two vertexes 
		Iterator<EdgeNode> i = ((LinkedList<EdgeNode>)edges[source]).iterator();	
		while(i.hasNext()) {
			if(target == i.next().getvnum()){
				return true;
			}
		}
		return false;
	}
	
	public void removeEdge(int source, int target){ //remove edge between two vertexes 
		Iterator<EdgeNode> i = ((LinkedList<EdgeNode>)edges[source]).iterator();
			if(target == i.next().getvnum()){
			((LinkedList<EdgeNode>)edges[source]).remove();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Graph<E> clone() { //clones graphs 
		Graph<E> clone;
		try{
			clone = (Graph<E>) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("Cannot be cloned");		
		}
		clone.edges = edges.clone();
		clone.vertexList = vertexList.clone();
		return clone;
	}
	public void setLabel(int vertex, E newLabel) { //set label on vertex 
		  vertexList[vertex] = newLabel;
	}
	
	public int size(){ //get number of vertexes 
		return vertexList.length;
		}	

	public int[] neighbors(int vertex) { //see all vertexes that are neighbors of current vertex 
		int[] neighbors = new int[this.edges[vertex].size()];
		for(int i = 0; i < this.edges[vertex].size(); i++) {
			neighbors[i] = this.edges[vertex].get(i).getvnum();
		}
		return neighbors;
	}
	

	public boolean isPath(int source, int target ){ //check to see if vertex has path to other vertexes 
		boolean[] hasProcessed = new boolean[vertexList.length];	
		ArrayQueue q = new ArrayQueue(vertexList.length);
		
		hasProcessed[source] = true;
		q.enqueue(source);
		
		while(q.isEmpty() == false){
			int dequeue = (int) q.dequeue();
			int[] neighbor = this.neighbors(dequeue);
			for(int i= 0; i < neighbor.length; i++){
				if(hasProcessed[neighbor[i]] == false){
					System.out.println(neighbor[i]);
					hasProcessed[neighbor[i]] = true;
					q.enqueue(neighbor[i]);
				}
			}
		}
		return hasProcessed[target];
		
	}
	
	@SuppressWarnings("unchecked")
	public int getVertex(E index) //get the vertex relative to the index passed in 
	{
		for(int i = 0; i < vertexList.length; i++)
		{
			if(index.equals((E)vertexList[i])) {
				return i;
			}
		}
		return -1;
	}
}//class


//Jose Mora
//5-25-16
public class EdgeNode {
	private int vertexNum;
	
	public EdgeNode(int vnum) { //create new edge node 
		vertexNum = vnum;
	}
	
	public void setvnum(int vnum) {//set the vertex number 
		vertexNum = vnum;
	}
	
	public int getvnum() { //return the vertex number 
		return vertexNum;
	}
	
	public boolean equals(Object obj) { //equals method 
		EdgeNode test = (EdgeNode) obj;
		
		if(test.getvnum() == this.getvnum()){
			return true;
		}
		return false;
	}

}

package Arion;
import edu.uncc.cs.bridges.*;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GraphVisualizer gv = new GraphVisualizer();//graph object
		
		
		Bridge.init(0, "1263295191349", gv, "arion");
		
		
		Vertex HelloWorld = new Vertex("HelloWorld", gv);//first vertex

		HelloWorld.setColor("red");
		
		HelloWorld.setSize(15);

		Vertex GoodByeWorld = new Vertex("GoodByeWorld", gv);
		
		HelloWorld.createEdge(GoodByeWorld);
		
		HelloWorld.getEdge(GoodByeWorld).setColor("yellow");
		
		Vertex HolaWorld = new Vertex("HolaWorld",gv);
		
		HolaWorld.setColor("blue");
		
		HolaWorld.setSize(12);

		HelloWorld.createEdge(HolaWorld);
		
		GoodByeWorld.createEdge(HolaWorld);

		
		

		
		Bridge.complete();

	}

}

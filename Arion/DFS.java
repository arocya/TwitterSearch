package Arion;

import edu.uncc.cs.bridges.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class DFS //don't want to mark as visited until vertex has been added to the results
{
	public static void main (String []args)
	{
		GraphVisualizer gv = new GraphVisualizer();
		
		// Assignment, API key, visualizer, username
	    Bridge.init(0, "1263295191349", gv, "arion");
	    
	    Deque<Vertex> frontier = new ArrayDeque<>();
		Map<String, Vertex> visited = new HashMap<>();

		// Any actual user on Twitter
		String name = "twitter.com/BlockheadTD"; 
		Vertex joey = new Vertex(name, gv);
		
		frontier.addFirst(joey);
		
		for (int expands=0; expands < 10 && !frontier.isEmpty(); expands++)
		{
			Vertex source = frontier.removeFirst();
			visited.put(name, joey);//mark  

			for (String friend_name : Bridge.getAssociations(source.getIdentifier(), 50))
			{
				Vertex target = visited.get(friend_name);// target get friend name of visited 
				if (target == null)
				{
					target = new Vertex(friend_name, gv);//  target null new vertex

					frontier.addFirst(target);
				}
				
				visited.put(friend_name, target);
				target = frontier.removeFirst();
				source.createEdge(target);   

			}
			

				
		}


		
		
		
	}

}

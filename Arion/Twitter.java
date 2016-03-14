package Arion;

import edu.uncc.cs.bridges.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;



public class Twitter {

	public static void main(String[] args) {
		GraphVisualizer gv = new GraphVisualizer();

		// Assignment, API key, visualizer, username
		Bridge.init(0, "1263295191349", gv, "arion");
		
		
		//deque allows to take from front and back
		//used here as a queue can also be used as stack
		
		Deque<Vertex> frontier = new ArrayDeque<>();
		
		//hash map haven't learned yet!!!  using to mark as visited
		Map<String, Vertex> visited = new HashMap<>();

		// Any actual user on Twitter
		String name = "twitter.com/Joey";
		//joey will be the first vertex added
		
		Vertex joey = new Vertex(name, gv);

		frontier.add(joey);//adds joey to the queue of vertex    //queue        /////////////////here
		visited.put(name, joey);//visisted is for the new hashmap    //mark  
		

		for (int expands=0; expands < 10 && !frontier.isEmpty(); expands++) //for neighbors
		{//<10 and while queue is not empty
			Vertex source = frontier.pop();//source = to dequeue/pop from front of queue  //book step 2
			//Vertex crazy = frontier.pop();
			
			for (String friend_name : Bridge.getAssociations(source.getIdentifier(), 50)) 
			{//for each friend name of the the source 

				Vertex target = visited.get(friend_name);// target get friend name of visited 
				if (target == null) 
				{
					target = new Vertex(friend_name, gv);//  target null new vertex
					visited.put(friend_name, target);  // mark visited and put in hash map   //////////////here
					frontier.add(target);				// queue neighbor
				}
				source.createEdge(target);  //creates edge from source to target book step 3 

			}
			frontier.remove(source);  //remove the source vertex from the queue
		}

		Bridge.complete();
	}

}
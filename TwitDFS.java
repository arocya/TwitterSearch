package Arion;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import edu.uncc.cs.bridges.*;


/*
 * This class hard codes a user on twitter and depth first searches
 * the users friends.  The expansion of the search is limited to 10,
 * but this can be changed just takes longer to compute.  The vertices 
 * and the edges in the depth first search appear blue and the alternate 
 * routes appear in red.  
 * 
 * This is the link:  http://bridges-cs.herokuapp.com/assignments/0/arion?apikey=1263295191349
 * 
 */

public class TwitDFS {

	public static void main(String[] args) {
		GraphVisualizer gv = new GraphVisualizer();//new graph visualizer
		

		// Assignment, API key, visualizer, username
		Bridge.init(0, "1263295191349", gv, "arion");

	    Stack<Vertex> stack = new Stack<Vertex>();//stack used for the search
		
		Map<String, Vertex> visited = new HashMap<>();//hashmap used to mark what has been visited 
		

		// Any actual user on Twitter
		String name = "twitter.com/Joey"; 
		Vertex joey = new Vertex(name, gv);//first vertex for the user
		
		joey.setColor("blue");//setting the vertex blue and enlarging it
		joey.setSize(20);
		
		Vertex friend = new Vertex(name, gv);
		String fName = "";						//global variables used for information outside the loop
		
		stack.push(joey);// push on the first vertex
		
		visited.put(name, joey);// mark as visited
		
		//this is where you can expand the search
		//I wanted a large search and used a 
		//while(!stack.isEmpty()) 
		//this took a long time to generate the graph
		//and although the graph worked it was hard to see
		//what was happening in the graph
		
		
		
		//this expands the graph up to 10 friends of the hard coded user
		for (int expands=0; expands < 10 && !stack.isEmpty(); expands++) 
		
		{
			Vertex source = stack.pop();// pops first vertex off stack
			
			//for each used to trace each friend of the current twitter user/vertex
			for (String friend_name : Bridge.getAssociations(source.getIdentifier(), 50)) 
			{
				Vertex target = visited.get(friend_name);//create a new vertex
								
				if (target == null)//if friend not in hash map
				{
					//here i created vertex for the path not taken 
					//by the search just for visual aspect
					
					
					target = new Vertex(friend_name, gv);
					target.setColor("red");
					
					visited.put(friend_name, target);
					stack.push(target);
					                                            //creates the vertex and marks vertex and edge red
					source.createEdge(target);
					source.getEdge(target).setColor("red");
					
					friend = target;
					fName = friend_name;//global variables used here to take the top of stack out of loop
				}				
			}			
			friend = new Vertex(fName, gv);
			friend.setColor("blue");                 //here I set the top of stack vertex to blue
													//and the edge to blue.  
			source.createEdge(friend);
			source.getEdge(friend).setColor("blue");			
		}

		Bridge.complete();
	}

}
import java.io.*;
import java.util.*;


//Complexity O(V+E) V is the number of vertices and E is the number of edges
void BFS(int s){
    //create an array of visited nodes
    boolean visited[] = new boolean[numOfVertices];

    //Create a queue for BFS;
    LinkedList<Integer> queue = new LinkedList<Integer>();

    visited[s] = true;
    queue.add(s);

    while(queue.size() != 0){
        s = queue.poll();
        System.out.print(s + " ");

        Iterator<Integer> i = adjacencyList[s].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if (!visited[n]){
                visited[n] = true;
                queue.add(n);
            }
        }

    }
}
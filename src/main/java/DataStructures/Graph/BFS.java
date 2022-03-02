package DataStructures.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    public static void main(String[] args){
        // take input from user
        Scanner sc = new Scanner(System.in);
        // take the input edges from the user
        int verticesCount = sc.nextInt();
        int edgesCount = sc.nextInt();
        // create a adjacency matrix and store that
        int[][] adjacencyMatrix = new int[verticesCount][verticesCount];
        for(int edge = 0; edge < edgesCount; edge++){
            int xCoordinate = sc.nextInt();
            int yCoordinate = sc.nextInt();
            adjacencyMatrix[xCoordinate][yCoordinate] = 1;
            adjacencyMatrix[yCoordinate][xCoordinate] = 1;
        }
        // print the adjacencyMatrix in DFS
        printBFS(adjacencyMatrix, verticesCount, new boolean[verticesCount]);
    }

    private static void printBFS(int[][] adjMatrix, int vertexCount, boolean[] visited){
        // create a queue
        Queue<Integer> pendingNodes = new LinkedList<>();
        // put the source into queue
        pendingNodes.add(0);
        // iterate the queue check empty
           while(!pendingNodes.isEmpty()){
               // get the nodes from the queue
               int currentVertex = pendingNodes.peek();
               // make that source as visited
               visited[currentVertex] = true;
               // print the source vertex
               System.out.print(currentVertex + " ");
               // remove the source
               pendingNodes.remove();
               // iterate the neighbours
               for(int neighbour = 0; neighbour < vertexCount; neighbour++){
                   // if it is neighbour and visited
                   if(visited[neighbour] != true && adjMatrix[currentVertex][neighbour] == 1){
                       // queue.add(neighbour)
                       pendingNodes.add(neighbour);
                   }
               }
           }
    }
}

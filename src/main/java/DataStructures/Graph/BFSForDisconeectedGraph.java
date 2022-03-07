package DataStructures.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSForDisconeectedGraph {

    public static void main(String[] args) {
        // take input from user
        Scanner sc = new Scanner(System.in);
        // take the input edges from the user
        int verticesCount = sc.nextInt();
        int edgesCount = sc.nextInt();
        // create a adjacency matrix and store that
        int[][] adjacencyMatrix = new int[verticesCount][verticesCount];
        for (int edge = 0; edge < edgesCount; edge++) {
            int xCoordinate = sc.nextInt();
            int yCoordinate = sc.nextInt();
            adjacencyMatrix[xCoordinate][yCoordinate] = 1;
            adjacencyMatrix[yCoordinate][xCoordinate] = 1;
        }
        // print the adjacencyMatrix in DFS
        printBFS(adjacencyMatrix, verticesCount, new boolean[verticesCount]);
    }

    private static void printBFS(int[][] adjMatrix, int vertexCount, boolean[] visited) {
        // create a queue for holding the values
        Queue<Integer> pendingVertices = new LinkedList<>();
        // as the source may not only be 0 as it is a disconnected graph
        for (int source = 0; source < vertexCount; source++) {
            // if the source is unvisited
            if (visited[source] == false) {
                // insert the source of the queue
                pendingVertices.add(source);
                // iterate the queue until empty
                while (!pendingVertices.isEmpty()) {
                    // get the current vertex from the queue
                    int currentVertex = pendingVertices.remove();
                    // mark the current vertex as visited
                    visited[currentVertex] = true;
                    // print the current vertex
                    System.out.print(currentVertex + " ");
                    // iterate the neighbours
                    for (int neighbour = 0; neighbour < vertexCount; neighbour++) {
                        // if the vertex is a neighbour and unvisited
                        if (visited[neighbour] == false && adjMatrix[currentVertex][neighbour] == 1) {
                            // then add that to the queue
                            pendingVertices.add(neighbour);
                        }
                    }
                }
            }
        }
    }
}

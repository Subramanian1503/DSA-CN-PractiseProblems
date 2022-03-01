package DataStructures.Graph;

import java.util.Scanner;

public class DFS {

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
        printDFS(verticesCount, 0, adjacencyMatrix, new boolean[verticesCount]);
    }

    private static void printDFS(int verticesCount,
                                 int vertexSource,
                                 int[][] adjMatrix,
                                 boolean[] visited){
        // print the vertx source
        System.out.print(vertexSource +" ");
        // mark source as visited
        visited[vertexSource] = true;
        // iterate the vertices
        for(int vertices = 0; vertices < verticesCount; vertices++){
            // check if the vertices is neighbour
            if(!visited[vertices] && adjMatrix[vertexSource][vertices] == 1){
                // if yes print DFS of the neighbour as source
                printDFS(verticesCount, vertices, adjMatrix, visited);
            }
            // if not go for next vertices
        }
    }
}

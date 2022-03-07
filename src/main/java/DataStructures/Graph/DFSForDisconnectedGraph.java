package DataStructures.Graph;

import java.util.Scanner;

public class DFSForDisconnectedGraph {

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
        printDFSForDisconnectedGraph(adjacencyMatrix, new boolean[verticesCount]);
    }

    private static void printDFSForDisconnectedGraph(int[][] adjMatrix, boolean[] visited) {
        // iterate the source
        for (int source = 0; source < adjMatrix.length; source++) {
            // check if the source is visited
            if (visited[source] == false) {
                // call printDFS with source
                printDFS(adjMatrix, visited, source);
            }
        }
    }

    private static void printDFS(int[][] adjMatrix, boolean[] visited, int source) {
        // print source
        System.out.println(source);
        // mark source as visited
        visited[source] = true;
        // find neighbours
        for (int i = 0; i < adjMatrix.length; i++) {
            // check if it is neighbour and not visited
            if (visited[i] == false && adjMatrix[source][i] == 1) {
                // print the vertices with neighbour as source
                printDFS(adjMatrix, visited, i);
            }
        }
    }
}

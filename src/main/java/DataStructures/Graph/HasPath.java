package DataStructures.Graph;

import java.util.Scanner;

public class HasPath {

//    Problem statement: Given an undirected graph G(V, E) and two vertices v1 and
//    v2(as integers), check if there exists any path between them or not. Print true or
//false. V is the number of vertices present in graph G, and vertices are numbered
//    from 0 to V-1. E is the number of edges present in graph G

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
        int source = sc.nextInt();
        int destination = sc.nextInt();
        // print the adjacencyMatrix in DFS
        System.out.println(hasPath(adjacencyMatrix, new boolean[verticesCount], source, destination));
    }

    private static boolean hasPath(int[][] adjMatrix, boolean[] visited, int source, int destination){
        // check if source is equal to destination
        if(source == destination) {
            // if true, return true
            return true;
        }
        visited[source] = true;
        // check if the neighbour has path to destination
        for(int neighbour = 0 ; neighbour < adjMatrix.length; neighbour++){
            // if yes, return true
            if(adjMatrix[source][neighbour] == 1 && visited[neighbour] == false){
                if(hasPath(adjMatrix, visited, neighbour, destination) == true){
                    return true;
                }
            }
        }
        // return false
        return false;
    }
}

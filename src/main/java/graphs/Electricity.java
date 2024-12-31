package graphs;

import java.util.*;

/**
 * Author: Alexis Englebert
 * Context: You are operating a power plant in the new city of Louvain-La-Neuve,
 * but lack plans for the city's electrical network.
 * Your goal is to minimize the cost of electrical wires ensuring the city is connected with just one wire.
 *
 * The method 'minimumSpanningTreeCost' is designed to find the minimum cost to connect all cities in a given electrical network.
 * The network is represented as a graph where the nodes are the buildings, the edges are the possible connections
 * and their associated cost.
 *
 * Example:
 * Given a network with three buildings (nodes) and the cost of wires (edges) between them:
 * 0 - 1 (5), 1 - 2 (10), 0 - 2 (20)
 * The minimum cost to connect all the buildings is 15 (5 + 10).
 *
 * Note: The method assumes that the input graph is connected and the input is valid.
 */
public class Electricity {

    /**
     * @param n       The number of buildings (nodes) in the network.
     * @param edges   A 2D array where each row represents an edge in the form [building1, building2, cost].
     *                The edges are undirected so (building2, building1, cost) is equivalent to (building1, building2, cost).
     * @return       The minimum cost to connect all cities.
     */
    public static int minimumSpanningCost(int n, int [][] edges) {
        //TODO
        //Begin strip
        int mincost=0;
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        UF uf= new UF(n);
        for(int[] edge:edges){
            mincost+=uf.union(edge[0],edge[1],edge[2]);
        }
        return mincost;
        
    }
    public static class UF{
        private static int[] id;

        public UF(int n){
            id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i]=i;
            }
        }

        public static int find(int p){
            while(p!=id[p]) p = id[p];
            return p;
        }
        //Union who returns 0 if the nodes were already merged
        // returns cost if the nodes are merged
        public int union(int p, int q, int cost){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootQ == rootP) return 0;
            id[p]=rootP;
            id[rootP]=rootP;
            id[rootQ]=rootP;
            id[q]=rootP;
            return cost;
        }
    }//endstrip

}

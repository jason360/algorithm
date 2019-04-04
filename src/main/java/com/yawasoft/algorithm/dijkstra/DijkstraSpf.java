package com.yawasoft.algorithm.dijkstra;

import java.util.*;

/**
 * <p>Given a graph and a source vertex in graph, find shortest paths from source to all vertices in the given graph.</p>
 * <p>
 * Let the node at which we are starting be called the initial node. Let the distance of node Y be the distance from the initial node to Y. Dijkstra's algorithm will assign some initial distance values and will try to improve them step by step.
 * <ul>
 * <li>Mark all nodes unvisited. Create a set of all the unvisited nodes called the unvisited set.
 * <li>Assign to every node a tentative distance value: set it to zero for our initial node and to infinity for all other nodes. Set the initial node as current.
 * <li>For the current node, consider all of its unvisited neighbours and calculate their tentative distances through the current node. Compare the newly calculated tentative distance to the current assigned value and assign the smaller one. For example, if the current node A is marked with a distance of 6, and the edge connecting it with a neighbour B has length 2, then the distance to B through A will be 6 + 2 = 8. If B was previously marked with a distance greater than 8 then change it to 8. Otherwise, keep the current value.
 * <li>When we are done considering all of the unvisited neighbours of the current node, mark the current node as visited and remove it from the unvisited set. A visited node will never be checked again.
 * <li>If the destination node has been marked visited (when planning a route between two specific nodes) or if the smallest tentative distance among the nodes in the unvisited set is infinity (when planning a complete traversal; occurs when there is no connection between the initial node and remaining unvisited nodes), then stop. The algorithm has finished.
 * <li>Otherwise, select the unvisited node that is marked with the smallest tentative distance, set it as the new "current node", and go back to step 3.
 * </ul>When planning a route, it is actually not necessary to wait until the destination node is "visited" as above: the algorithm can stop once the destination node has the smallest tentative distance among all "unvisited" nodes (and thus could be selected as the next "current").
 * </p>
 */
public class DijkstraSpf {

    /**
     * PriorityQueue (with Fibonacci heap) improves running time efficiency from O(|V|^2) to O(|E| + |V|log|V|);
     * If only spf between source and destination vertex is needed, the calculation can be ended when the destination node is added to <code>visited</code>;
     * The shortest path can be recorded if needed at the step where <code>newWeight</code> is assigned.
     *
     * @param graph
     * @param source
     * @return
     */
    public Map<Node,Integer> spf(Graph graph, Node source){
        Map<Node,Integer> ret = new HashMap<>();
        graph.getAllNodes().forEach(n -> ret.put(n, Integer.MAX_VALUE));

        Set<Node> visited = new HashSet<>();

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(source, source, 0));

        int size = ret.keySet().size();
        while(visited.size() < size){
            Edge e = pq.remove();
            visited.add(e.getEnd());
            ret.put(e.getEnd(), e.getWeight());
            graph.getAdjacencyList(e.getEnd()).forEach(ae -> {
                Node adjacency = ae.getEnd();
                if(!visited.contains(adjacency)){
                    int newWeight = e.getWeight() + ae.getWeight();
                    if(newWeight < ret.get(adjacency)){
                        ret.put(adjacency, newWeight);
                    }
                    pq.add(new Edge(source, adjacency, ret.get(adjacency)));
                }
            });
        }

        return ret;
    }

}

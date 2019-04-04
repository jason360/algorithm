package com.yawasoft.algorithm.dijkstra;

import java.util.*;

/**
 * Use <code>(Map<String,List<Node>>)</code> to represent the graph as adjacency list.
 */
public class Graph {

    final Map<Node, List<Edge>> nodes = new HashMap<>();

    public void addNode(Node n){
        nodes.putIfAbsent(n, new ArrayList<Edge>());
    }

    public void removeNode(Node n){
        nodes.remove(n);
        nodes.forEach((k,v) -> {
            removeEdgeFromList(v, n);
        });
    }

    public void addEdge(Node n1, Node n2, int weight){
        nodes.get(n1).add(new Edge(n1, n2, weight));
        nodes.get(n2).add(new Edge(n2, n1, weight));
    }

    public void removeEdge(Node n1, Node n2){
        List<Edge> o1Edges = nodes.get(n1);
        if(null != o1Edges){
            removeEdgeFromList(o1Edges, n2);
        }
        List<Edge> o2Edges = nodes.get(n2);
        if(null != o2Edges){
            removeEdgeFromList(o2Edges, n1);
        }
    }

    public Set<Node> getAllNodes(){
        return nodes.keySet();
    }

    public List<Edge> getAdjacencyList(Node n){
        return nodes.get(n);
    }

    private void removeEdgeFromList(List<Edge> adjacencyList, Node n){
        Iterator<Edge> itr = adjacencyList.iterator();
        while(itr.hasNext()){
            Edge e = itr.next();
            if(e.getStart().equals(n) || e.getEnd().equals(n)){
                itr.remove();
            }
        }
    }
}

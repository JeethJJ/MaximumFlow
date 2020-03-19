//reference - https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/graphtheory/networkflow/examples/FordFulkersonExample.java
//depth first search
package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class FlowBase {
    static final long INF = Long.MAX_VALUE;
    public ArrayList<Edges>[] edges;        // list of all edges
    public int source;
    public int sink;
    public int noOfNodes;
    public int visitedToken;
    public int[] visited;
    public long maxFlow;
    public ArrayList<Edges>[][] path;        // list of all edges


    public FlowBase(int source,int sink,int noOfNodes) {
        this.source = source;
        this.sink = sink;
        this.noOfNodes = noOfNodes;
        createList(noOfNodes);
    }

    public void createList(int nodes) {
        edges = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++){
            edges[i] = new ArrayList<Edges>();
        }
    }

    public List<Edges>[] getGraph() {
//        solve();
        return edges;
    }

    public void alterCapacityEdge(Edges e, int capacity) {
        for (List<Edges> ed : edges){
            for(Edges eee : ed){
                if(eee.equals(e)){
                    eee.setCapacity(capacity);
                }
            }
        }
    }

    public void addEdge(int start, int end, long capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Edge capacity should be greater than 0");
        }
        Edges e1 = new Edges(start, end, capacity);
        Edges e2 = new Edges(end, start, 0);
        e1.residualEdge = e2;
        e2.residualEdge = e1;
        edges[start].add(e1);
        edges[end].add(e2);
    }

    public long getMaxFlow() {
        System.out.println("Path & flow in that path\n");
        System.out.print("Source node "+source+" -> ");
        for (List<Edges> edges11 : edges){
            for (Edges e : edges11){
                e.setFlow(0);
            }
        }
        maxFlow=0;
        visited = new int[noOfNodes];
        visitedToken = 1;
        solve();
        return maxFlow;
    }

    public void solve() {
        for (long f = dfs(source, INF); f!= 0; f = dfs(source, INF)) {
            System.out.println("Flow in path = " + f +"\n");
            visitedToken++;
            maxFlow += f;
            System.out.print("Source node "+source+" -> ");
        }
    }

    private long dfs(int node, long flow) {
        if (node == sink){
            return flow;
        }
        visited[node] = visitedToken;
        List<Edges> edgeCheck = edges[node];
        for (Edges edge : edgeCheck) {
            if (edge.leftCapacity() > 0 && visited[edge.getEnd()] != visitedToken) {
                if(edge.getEnd()==sink){
                    System.out.println("Sink node " +edge.getEnd());
                }else {
                    System.out.print("Node " +edge.getEnd() + " -> ");
                }
                long bottleNeck = dfs(edge.getEnd(), min(flow, edge.leftCapacity()));
                if (bottleNeck > 0) {
                    edge.addFlow(bottleNeck);
                    return bottleNeck;
                }
            }
        }
        //System.out.println("!!! This path won't continue!! All possible paths taken !!!");
        return 0;
    }
}

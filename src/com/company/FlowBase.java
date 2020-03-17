package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class FlowBase {
    static final long INF = Long.MAX_VALUE;
    public static List<Edges>[] edges;        // list of all edges
    public int source;
    public int sink;
    public int visitedToken = 1;
    public int[] visited;
    public long maxFlow;

    public FlowBase(int source,int sink,int noOfNodes) {
        this.source = source;
        this.sink = sink;
        createList(noOfNodes);
        visited = new int[noOfNodes];
    }

    public void createList(int nodes) {
        edges = new List[nodes];
        for (int i = 0; i < nodes; i++){
            edges[i] = new ArrayList<Edges>();
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

    public List<Edges>[] getGraph() {
        solve();
        return edges;
    }

    public long getMaxFlow() {
        solve();
        return maxFlow;
    }

    public void solve() {
        for (long f = dfs(source, INF); f!= 0; f = dfs(source, INF)) {
            visitedToken++;
            maxFlow += f;
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
                long bottleNeck = dfs(edge.getEnd(), min(flow, edge.leftCapacity()));
                if (bottleNeck > 0) {
                    edge.addFlow(bottleNeck);
                    return bottleNeck;
                }
            }
        }
        return 0;
    }
}

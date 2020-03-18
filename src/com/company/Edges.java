package com.company;

public class Edges {
    private int start;
    private int end;
    public Edges residualEdge;
    private long flow;
    private final long capacity;

    public Edges(int start, int end, long capacity) {
        this.start = start;
        this.end = end;
        this.capacity = capacity;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public long getFlow() {
        return flow;
    }

    public void setFlow(long flow) {
        this.flow = flow;
    }

    public long getCapacity() {
        return capacity;
    }

    public boolean isResidual() {
        return capacity == 0;
    }

    public long leftCapacity() {
        return capacity - flow;
    }

    public void addFlow(long bottleNeck) {
        flow += bottleNeck;
        residualEdge.flow -= bottleNeck;
    }

    public String toString(int s, int t) {
        String u = (start == s) ? "source" : ((start == t) ? "sink" : String.valueOf(start));
        String v = (end == s) ? "source" : ((end == t) ? "sink" : String.valueOf(end));
        return String.format(
                "Edge %6s -> %6s | flow = %3d | capacity = %3d | Is residual - %s",
                u, v, flow, capacity, isResidual());
    }
}
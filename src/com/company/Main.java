package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class Main {


    public static void main(String[] args) {
//        int n = 6;
//        int s = 0;
//        int t = 5;
//
//        FlowBase fb = new FlowBase(s,t,n);
//
//        fb.addEdge(s, 1, 10);
//        fb.addEdge(s, 2, 8);
//        fb.addEdge(1, 2, 5);
//        fb.addEdge(2, 1, 4);
//        fb.addEdge(1, 3, 5);
//        fb.addEdge(3, 2, 7);
//        fb.addEdge(2, 4, 10);
//        fb.addEdge(4, 3, 10);
//        fb.addEdge(3, 4, 6);
//        fb.addEdge(3, t, 3);
//        fb.addEdge(4, t, 14);

//        int n = 12;
//        int s = n-2;
//        int t = n-1;

//        FlowBase fb = new FlowBase(s,t,n);

//        // Edges from source
//        fb.addEdge(s, 0, 10);
//        fb.addEdge(s, 1, 5);
//        fb.addEdge(s, 2, 10);
//
//        // Middle edges
//        fb.addEdge(0, 3, 10);
//        fb.addEdge(1, 2, 10);
//        fb.addEdge(2, 5, 15);
//        fb.addEdge(3, 1, 2);
//        fb.addEdge(3, 6, 15);
//        fb.addEdge(4, 1, 15);
//        fb.addEdge(4, 3, 3);
//        fb.addEdge(5, 4, 4);
//        fb.addEdge(5, 8, 10);
//        fb.addEdge(6, 7, 10);
//        fb.addEdge(7, 4, 10);
//        fb.addEdge(7, 5, 7);
//
//        // Edges to sink
//        fb.addEdge(6, t, 15);
//        fb.addEdge(8, t, 10);

        int n = 8;
        int s = 0;
        int t = 7;

        FlowBase fb = new FlowBase(s,t,n);

        // Edges from source
        fb.addEdge(s, 1, 10);
        fb.addEdge(s, 2, 5);
        fb.addEdge(s, 3, 15);

        // Middle edges
        fb.addEdge(1, 4, 9);
        fb.addEdge(1, 2, 4);
        fb.addEdge(1, 5, 15);
        fb.addEdge(2, 5, 8);
        fb.addEdge(2, 3, 4);
        fb.addEdge(3, 6, 16);
        fb.addEdge(6, 2, 6);
        fb.addEdge(5, 6, 15);
        fb.addEdge(4, 5, 15);

        // Edges to sink
        fb.addEdge(4, t, 10);
        fb.addEdge(5, t, 10);
        fb.addEdge(6, t, 10);




        System.out.println("!!! This path won't continue!! All possible paths taken !!!\n\nMaximum flow = "+fb.getMaxFlow());
    }
}

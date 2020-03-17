package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class Main {


    public static void main(String[] args) {
        int n = 6;
        int s = 0;
        int t = 5;
        FlowBase fb = new FlowBase(s,t,n);

        // Edges from source
        fb.addEdge(s, 1, 10);
        fb.addEdge(s, 2, 8);
        fb.addEdge(1, 2, 5);

        // Middle edges
        fb.addEdge(2, 1, 4);
        fb.addEdge(1, 3, 5);
        fb.addEdge(3, 2, 7);
        fb.addEdge(2, 4, 10);
        fb.addEdge(4, 3, 10);
        fb.addEdge(3, 4, 6);
        fb.addEdge(3, t, 3);
        fb.addEdge(4, t, 14);
//        fb.addEdge(5, 8, 10);
//        fb.addEdge(6, 7, 10);
//        fb.addEdge(7, 4, 10);
//        fb.addEdge(7, 5, 7);
//
//        // Edges to sink
//        fb.addEdge(6, t, 15);
//        fb.addEdge(8, t, 10);

//        System.out.println(fb.edges.length);
//        for (List<Edges> l: fb.edges){
//            for (Edges e:l) {
//                System.out.println(e.getStart()+"  "+ e.getEnd()+"  "+ e.getCapacity());
//            }
//        }
        System.out.println(fb.getMaxFlow());
    }
}

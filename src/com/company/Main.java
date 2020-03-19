//reference - https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/graphtheory/networkflow/examples/FordFulkersonExample.java
//depth first search
package com.company;

import java.util.List;
import java.util.Scanner;

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

//        int n = 8;
//        int s = 0;
//        int t = 7;
//
//        FlowBase fb = new FlowBase(s,t,n);
//
//        // Edges from source
//        fb.addEdge(s, 1, 10);
//        fb.addEdge(s, 2, 5);
//        fb.addEdge(s, 3, 15);
//
//        // Middle edges
//        fb.addEdge(1, 4, 9);
//        fb.addEdge(1, 2, 4);
//        fb.addEdge(1, 5, 15);
//        fb.addEdge(2, 5, 8);
//        fb.addEdge(2, 3, 4);
//        fb.addEdge(3, 6, 16);
//        fb.addEdge(6, 2, 6);
//        fb.addEdge(5, 6, 15);
//        fb.addEdge(4, 5, 15);
//
//        // Edges to sink
//        fb.addEdge(4, t, 10);
//        fb.addEdge(5, t, 10);
//        fb.addEdge(6, t, 10);

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome !! \nCreate a graph to continue ...");
        int n ;
        do {
            n = Validator.intVal("Enter number of nodes including source and sink :");
            if (n< 2) {
                System.out.println("Input not suitable, please consider the valid range");
            }
        } while (n<2);

        int s ;
        do {
            s = Validator.intVal("Enter the number of source node :");
            if (s< 0 || s>n-1) {
                System.out.println("Input not suitable, please consider the valid range");
            }
        } while (s<0 || s>n-1);

        int t ;
        do {
            t = Validator.intVal("Enter the number of sink node :");
            if (t< 0 || t>n-1) {
                System.out.println("Input not suitable, please consider the valid range");
            }
        } while (t<0 || t>n-1);

        FlowBase fb = new FlowBase(s,t,n);
//        // Edges from source
//        fb.addEdge(s, 1, 10);
//        fb.addEdge(s, 2, 5);
//        fb.addEdge(s, 3, 15);
//
//        // Middle edges
//        fb.addEdge(1, 4, 9);
//        fb.addEdge(1, 2, 4);
//        fb.addEdge(1, 5, 15);
//        fb.addEdge(2, 5, 8);
//        fb.addEdge(2, 3, 4);
//        fb.addEdge(3, 6, 16);
//        fb.addEdge(6, 2, 6);
//        fb.addEdge(5, 6, 15);
//        fb.addEdge(4, 5, 15);
//
//        // Edges to sink
//        fb.addEdge(4, t, 10);
//        fb.addEdge(5, t, 10);
//        fb.addEdge(6, t, 10);
        int status=0;
        while(status!=5){
            System.out.print("\n1.Add edge \n2.Delete edge \n3.Edit edge \n4.Get maximum flow \n5.Exit \n:");
            status = sc.nextInt();

            switch (status){
                case 1 :
                    int start ;
                    do {
                        start = Validator.intVal("Enter the number of start node :");
                        if (start< 0 || start>n-1) {
                            System.out.println("Input not suitable, please consider the valid range");
                        }
                    } while (start<0 || start>n-1);

                    int end ;
                    do {
                        end = Validator.intVal("Enter the number of end node :");
                        if (end< 0 || end >n-1) {
                            System.out.println("Input not suitable, please consider the valid range");
                        }
                    } while (end< 0 || end >n-1);


                    int capacity ;
                    do {
                        capacity = Validator.intVal("Enter the capacity of the edge :");
                        if (capacity< 0) {
                            System.out.println("Input not suitable, please consider the valid range");
                        }
                    } while (capacity<0 );

                    fb.addEdge(start,end,capacity);
                    break;

                case 2 :
                    int delstart ;
                    do {
                        delstart = Validator.intVal("Enter the number of start node :");
                        if (delstart< 0 || delstart >n-1) {
                            System.out.println("Input not suitable, please consider the valid range");
                        }
                    } while (delstart< 0 || delstart >n-1);

                    int delend ;
                    do {
                        delend = Validator.intVal("Enter the number of end node :");
                        if (delend< 0 || delend >n-1 ) {
                            System.out.println("Input not suitable, please consider the valid range");
                        }
                    } while (delend< 0 || delend >n-1);

                    boolean deleted = false;
                    List<Edges>[] allEdges = fb.getGraph();
                    for (List<Edges> edges : allEdges){
                        for (Edges e : edges){
                            if(e.getStart()==delstart && e.getEnd()==delend){
                                fb.alterCapacityEdge(e,0);
                                deleted=true;
                                System.out.println("Successfully deleted!!");
                            }
                        }
                    }
                    if(!deleted){
                        System.out.println("No such node found!!");
                    }
                    break;

                case 3 :
                    int altstart ;
                    do {
                        altstart = Validator.intVal("Enter the number of start node :");
                        if (altstart< 0 || altstart >n-1) {
                            System.out.println("Input not suitable, please consider the valid range");
                        }
                    } while (altstart< 0 || altstart >n-1);

                    int altend ;
                    do {
                        altend = Validator.intVal("Enter the number of end node :");
                        if (altend< 0 || altend >n-1 ) {
                            System.out.println("Input not suitable, please consider the valid range");
                        }
                    } while (altend< 0 || altend >n-1);

                    boolean altered = false;
                    List<Edges>[] allEgdesAlt = fb.getGraph();
                    for (List<Edges> edges2 : allEgdesAlt){
                        for (Edges e2 : edges2){
                            if(e2.getStart()==altstart && e2.getEnd()==altend){
                                System.out.print("Enter the new capacity :");
                                int cap = sc.nextInt();
                                fb.alterCapacityEdge(e2,cap);
                                altered=true;
                                System.out.println("Successfully edited!!");
                            }
                        }
                    }
                    if(!altered){
                        System.out.println("No such node found!!");
                    }
                    break;
                case 4:
                    System.out.println("!!! This path won't continue!! All possible paths taken or no possible paths available!!!\n\nMaximum flow = "+fb.getMaxFlow());
                    List<Edges>[] resultGraph = fb.getGraph();

                    // Displays all edges part of the resulting residual graph.
                    System.out.println("\nDetails of flow network ");
                    System.out.println("------------------------");
                    for (List<Edges> edges : resultGraph){
                        for (Edges e : edges){
                            System.out.println(e.toString(s, t));
                        }
                    }
                    break;
            }
        }
    }
}

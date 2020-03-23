package com.company;

import java.util.ArrayList;
import java.util.Random;

public class DoublingHypothesis {
    public static void main(String[] args) {
        int startNodes ;
        int startEdges ;
        int finalNodesCount;
        int finalEdgesCount;
        int datasetsCount ;
        Random rand = new Random();
        ArrayList<Double> times = new ArrayList<>();

        do {
            startNodes = Validator.intVal("Enter the starting amount of nodes (greater than 5) :");
            if (startNodes< 6) {
                System.out.println("Input not suitable, please consider the valid range");
            }
        } while (startNodes<6);
        do {
            startEdges = Validator.intVal("Enter the starting amount of edges (greater than "+startNodes+") :");
            if (startEdges< startNodes+1) {
                System.out.println("Input not suitable, please consider the valid range");
            }
        } while (startEdges<startNodes+1);
        finalNodesCount=startNodes;
        finalEdgesCount=startEdges;

        do {
            datasetsCount = Validator.intVal("How many iterations would you like to check :");
            if (datasetsCount< 1) {
                System.out.println("Input not suitable, please consider the valid range");
            }
        } while (datasetsCount<1);

        for(int iterator = 0; iterator<datasetsCount;iterator++,startNodes=startNodes*2,startEdges=startEdges*2){
            FlowBase fb = new FlowBase(1,startNodes-1,startNodes);

            for(int edgeIterator = 0;edgeIterator<startEdges-6;edgeIterator++) {
                int start = rand.nextInt(startNodes);
                int end = rand.nextInt(startNodes);
                while (end == start) {
                    end = rand.nextInt(startNodes);
                }
                int capacity = rand.nextInt(startNodes * 10)+1;
                fb.addEdge(start, end, capacity);
            }
            fb.addEdge(1,4 ,rand.nextInt(startNodes * 10)+1);
            fb.addEdge(1,2, rand.nextInt(startNodes * 10)+1);
            fb.addEdge(1,3 ,rand.nextInt(startNodes * 10)+1);
            fb.addEdge(4,startNodes-1 , rand.nextInt(startNodes * 10)+1);
            fb.addEdge(3,startNodes-1 , rand.nextInt(startNodes * 10)+1);
            fb.addEdge(2,startNodes-1 , rand.nextInt(startNodes * 10)+1);
            if(startEdges>20){
                fb.addEdge(1,4 ,rand.nextInt(startNodes * 10)+1);
                fb.addEdge(1,5, rand.nextInt(startNodes * 10)+1);
                fb.addEdge(1, 2,rand.nextInt(startNodes * 10)+1);
                fb.addEdge(2,4 ,rand.nextInt(startNodes * 10)+1);
                fb.addEdge(1,5, rand.nextInt(startNodes * 10)+1);
                fb.addEdge(1, 2,rand.nextInt(startNodes * 10)+1);
                fb.addEdge(4,startNodes-1 , rand.nextInt(startNodes * 10)+1);
                fb.addEdge(5,startNodes-1 , rand.nextInt(startNodes * 10)+1);
                fb.addEdge(3,startNodes-1 , rand.nextInt(startNodes * 10)+1);
            }

            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            System.out.println("Dataset "+(iterator+1));
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            long startTime = System.nanoTime();
            System.out.println("!!! This path won't continue!! All possible paths taken or no possible paths available!!!\n\nMaximum flow = "+fb.getMaxFlow());
            long endTime = System.nanoTime();
            double timeSpent = endTime - startTime;
            times.add(timeSpent/ 1_000_000_000);
        }
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        int i=1;
        for(double l: times){
            System.out.println("Dataset "+i+"\n   Number of nodes - "+finalNodesCount+"\n   Number of edges - "+finalEdgesCount+"\n   Time taken to calculate maximum flow - "+ l+"s");
            i++;
            finalNodesCount=finalNodesCount*2;
            finalEdgesCount=finalEdgesCount*2;
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uaic.main;
import org.jgrapht.Graph;
import org.jgrapht.alg.spanning.*;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
/**
 *
 * @author vital
 */
public class Solution {
    private City city;
    private Graph<Intersection, DefaultWeightedEdge> graph =  
                new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
    public Solution() {
    }

    public Solution(City city) {
        this.city = city;
    }
    
    public void Prim(){
        
        for(Intersection intersection : city.getCityMap().keySet())
            graph.addVertex(intersection);
        
        for(Intersection intersection : city.getCityMap().keySet()){
            for(Street street : city.getCityMap().get(intersection)){
                if(graph.getEdge(street.getIntersectionDown(), street.getIntersectionUp())==null){
                    graph.addEdge(street.getIntersectionDown(), street.getIntersectionUp());
                    graph.setEdgeWeight(street.getIntersectionDown(), street.getIntersectionUp(), street.getLength());
                }
            }
        }
        
       
        int cost=0;
        System.out.println("\nSolution:");
        for(DefaultWeightedEdge e: new PrimMinimumSpanningTree<>(graph).getSpanningTree()) { 
            System.out.println(e);
            cost+=graph.getEdgeWeight(e);
        }
        System.out.println("Cost: " + cost);
        
    }
    
}

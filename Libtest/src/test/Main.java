package test;

import graph_metods.Dinic;
import graph_metods.FordFalkerson;
import graph_metods.Graph;
import graph_metods.PreFlow;
import graph_metods.TransitionMatrix2;


public class Main {

	public static void main(String[] args) {
		TransitionMatrix2 graph = new TransitionMatrix2();
		FordFalkerson ff = new FordFalkerson();
		Dinic di = new Dinic();
		/*
		 * Проверочная функция организует граф, представляющий некоторую
		 * сеть из 5 узлов (исток - вершина № 0, сток - вершина № 4)
		 */
		di.init(5, 20);
		di.addEdge(0, 1, 20);	// *  0  1  2  3  4
		di.addEdge(0, 2, 30);	// 0  * 20 30 10  *
		di.addEdge(0, 3, 10);	// 1  *  * 40  * 30
								// 2  *  *  * 10 20
		di.addEdge(1, 2, 40);	// 3  *  *  *  * 20
		di.addEdge(1, 4, 30);	// 4  *  *  *  *  *
								
		di.addEdge(2, 3, 10);	
		di.addEdge(2, 4, 20);	
		
		di.addEdge(3, 4, 20);
		
		//System.out.println("Maximum flow = " + di.dinic(0, 4)); //60
		
		/*
		 * Проверочная функция организует граф, представляющий некоторую
		 * сеть из 5 узлов (исток - вершина № 0, сток - вершина № 4)
		 */
		Graph net = new Graph(5, 0, 4);

		net.addArc(0, 1, 20);	// *  0  1  2  3  4
		net.addArc(0, 2, 30);	// 0  * 20 30 10  *
		net.addArc(0, 3, 10);	// 1  *  * 40  * 30
								// 2  *  *  * 10 20
		net.addArc(1, 2, 40);	// 3  *  *  *  * 20
		net.addArc(1, 4, 30);	// 4  *  *  *  *  *
								
		net.addArc(2, 3, 10);	
		net.addArc(2, 4, 20);	
		
		net.addArc(3, 4, 20);

		PreFlow pf = new PreFlow(net);
		net.printNet();
		//System.out.println("Maximum flow = " + di.dinic(0, 4)); //60
		//System.out.println("Maximum flow = " + pf.maxFlow()); //60
		graph.init(5);
		/*
		 * Проверочная функция организует граф, представляющий некоторую
		 * сеть из 5 узлов (исток - вершина № 1, сток - вершина № 5)
		 */
		graph.addEdge(1, 2, 20);	// *  1  2  3  4  5
		graph.addEdge(1, 3, 30);	// 1  * 20 30 10  *
		graph.addEdge(1, 4, 10);	// 2  *  * 40  * 30
									// 3  *  *  * 10 20
		graph.addEdge(2, 3, 40);	// 4  *  *  *  * 20
		graph.addEdge(2, 5, 30);	// 5  *  *  *  *  *
								
		graph.addEdge(3, 4, 10);	
		graph.addEdge(3, 5, 20);	
		
		graph.addEdge(4, 5, 20);
		

		System.out.println("Maximum flow PreFlow = " + pf.maxFlow()); //60
		System.out.println("Maximum flow Dinic = " + di.dinic(0, 4)); //60	
		System.out.println("Maximum flow FordFulkerson = " + ff.networkFlow(1, 5)); //60
		//System.out.println(ff.networkFlow(1, 5)); //60
		
		graph.init(8);
		
		graph.addEdge(1, 2, 6);
		graph.addEdge(1, 3, 6);
		
		graph.addEdge(2, 4, 4);
		graph.addEdge(2, 5, 2);
		
		graph.addEdge(3, 2, 5);
		graph.addEdge(3, 5, 9);
		
		graph.addEdge(4, 6, 4);
		graph.addEdge(4, 7, 2);
		
		graph.addEdge(5, 4, 8);
		graph.addEdge(5, 7, 7);
		
		graph.addEdge(6, 8, 7);
		
		graph.addEdge(7, 6, 11);
		graph.addEdge(7, 8, 4);
		
		System.out.println(ff.networkFlow(1, 8)); //11

		
		graph.init(6);
		
		graph.addEdge(1, 2, 4);
		graph.addEdge(1, 3, 2);
		
		graph.addEdge(2, 3, 2);
		graph.addEdge(2, 4, 2);
		
		graph.addEdge(3, 5, 4);
		
		graph.addEdge(4, 5, 1);
		graph.addEdge(4, 6, 2);
		
		graph.addEdge(5, 6, 4);
		
		
		System.out.println(ff.networkFlow(1, 6));
		
		graph.init(8);
		
		graph.addEdge(1, 2, 32);
		graph.addEdge(1, 3, 95);
		graph.addEdge(1, 4, 75);
		graph.addEdge(1, 5, 57);
		
		graph.addEdge(2, 3, 5);
		graph.addEdge(2, 5, 23);
		graph.addEdge(2, 8, 16);
		
		graph.addEdge(3, 4, 18);
		graph.addEdge(3, 6, 6);
		
		graph.addEdge(4, 5, 24);
		graph.addEdge(4, 6, 9);
		
		graph.addEdge(5, 7, 20);
		graph.addEdge(5, 8, 94);
		
		graph.addEdge(6, 5, 11);
		graph.addEdge(6, 7, 7);
		
		graph.addEdge(7, 8, 81);
		
		System.out.println(ff.networkFlow(1, 8));
	}

}


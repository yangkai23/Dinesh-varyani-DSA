package dsa.graphs;

import java.util.*;
public class AdjacencyMatrix {
	int ar[][];
	int v,e;
	
	public AdjacencyMatrix(int nodes) {
		ar=new int[nodes][nodes];
		
		v=nodes;
		e=0;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number of nodes");
		int nodes =sc.nextInt();
		AdjacencyMatrix am=new AdjacencyMatrix(nodes);
		am.addEdge(0, 1);
		am.addEdge(0, 2);
		am.addEdge(4, 3);
		am.addEdge(5,6);
//		System.out.println(am);
//		am.dfs();
		sc.close();
	}
//	public void dfs() {
//		int count=0;
//		for(int i=0;i<v;i++) {
//			if(!b[i]) {
//				System.out.println("inside  "+b[i]);
//				System.out.println("A    "+i+" ");
//				dfs(count,i);
//				count++;
//			}
//		}
//		System.out.println("No ofcomponents: "+count );
//	}
//	
//	 void dfs(int count, int k) {
//		 System.out.println("B      "+k+" ");
//			b[k]=true;
//			display();
//			System.out.println(b[k]);
//			comindex[k]=count;
//			for(int w:ar[k]) 
//			{System.out.println("hi");
//				if(!b[w]) {
//					System.out.println("w   "+w);
//					dfs(count,w);
//				}
//			}
//	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(v+"  vertices and "+e+" edges"+"\n");
		for(int i=0;i<v;i++) {
			sb.append(i+":    ");
			for (int is : ar[i]) {
				sb.append(is+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	private  void addEdge(int i, int j) {
		ar[i][j]=1;
		ar[j][i]=1;
		e++;
	}
}

package dsa.graphs;
import java.util.*;
public class AdjacencyList {
	private LinkedList<Integer> ar[];
	private int v,e;
	int comindex[];
	boolean b[];
	@SuppressWarnings("unchecked")
	public AdjacencyList(int nodes) {
		ar=new LinkedList[nodes];
		b=new boolean[nodes];
		comindex=new int[nodes];
		v=nodes;
		e=0;
		for(int i=0;i<nodes;i++) {
			ar[i]=new LinkedList<Integer>();
		}
	}
	public static void main(String[] args) {
		AdjacencyList al=new AdjacencyList(7);
		al.addEdge(0, 1);
		al.addEdge(0, 2);
		al.addEdge(4, 3);
		al.addEdge(5,6);
		//		al.bfs(0);
		//		al.dfs(0);
		al.dfs();
		//		System.out.println(al);
	}

	public void bfs(int n) {//Breadth First Search
		boolean seen[]=new boolean[v];
		Queue<Integer> list=new LinkedList<Integer>();
		list.add(n);
		seen[n]=true;
		while(!list.isEmpty()) {
			int r=list.poll();
			System.out.print(r+" ");
			for(int x:ar[r]) {
				if(!seen[x]) {
					seen[x]=true;
					list.add(x);
				}
			}
		}
	}
	public void dfs(int n) {
		boolean b[]=new boolean[v];
		Stack<Integer> st=new Stack<Integer>();
		st.push(n);
		while(!st.isEmpty()) {
			int x=st.pop();
			if(!b[x]) {
				b[x]=true;
				System.out.print(x+" ");
				for(int s:ar[x]) {
					if(!b[s])
						st.push(s);
				}
			}
		}
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(v+" vertices and "+e+" edges"+"\n");
		for(int i=0;i<v;i++) {
			sb.append(i+":    ");
			for (int is : ar[i]) {
				sb.append(is+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	private void addEdge(int i, int j) {
		ar[i].add(j);
		ar[j].add(i);
		e++;
	}
	public void dfs() {
		int count=0;
		for(int i=0;i<v;i++) {
			if(!b[i]) {
				dfs(count,i);
				count++;
			}
		}
		System.out.println("No ofcomponents: "+count );
	}

	void dfs(int count, int k) {
		b[k]=true;
		comindex[k]=count;
		for(int w:ar[k]) 
		{
			if(!b[w]) {
				dfs(count,w);
			}
		}
	}
}

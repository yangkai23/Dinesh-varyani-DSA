package dsa.matrix;
import java.util.*;
public class SimilarRectangles {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<List<Long>> sides=new LinkedList<List<Long>>();
		System.out.println("enter num of rows");
		int size =sc.nextInt();
		for(int i=0;i<size;i++) {
			sides.add(new LinkedList<Long>());
		}
		System.out.println("enter number of columns");
		int rowentity=sc.nextInt();
		System.out.println("enter "+size*rowentity+" elements");
		for(int i=0;i<sides.size();i++) {
			for (int j = 0; j < rowentity; j++) {
				sides.get(i).add(sc.nextLong());
			}
		}
		
		System.out.println(getSimilarRectangleCount(sides));
		sc.close();
	}
	private static int getSimilarRectangleCount(List<List<Long>> sides) {
		int count=0,i=0,j=i+1;
		while (i<sides.size()&&j<sides.size()) {
			if(sides.get(i).get(0)*sides.get(j).get(1)==sides.get(i).get(1)*sides.get(j).get(0)) {
				count++;
			}
			j++;
			if(j==sides.size()) {
				i++;
				j=i+1;
			}
		}
		return count;
	}


}

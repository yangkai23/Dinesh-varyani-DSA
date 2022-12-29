package dsa.Arrays;
import java.util.Scanner;
public class MaxSumSubArray {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<ar.length;i++) {
			ar[i]=sc.nextInt();
		}
		int max=getMax(ar);
		System.out.println(max);
		sc.close();
	}
	private static int getMax(int[] ar) {
		int currentmax=ar[0];
		int maxofnow=ar[0];
		for(int i=1;i<ar.length;i++) {
			currentmax=currentmax+ar[i];
			if(currentmax<ar[i])
				currentmax=ar[i];
			if(maxofnow<currentmax)
				maxofnow=currentmax;
		}
		return maxofnow;
	}
}

package dsa.Arrays;
import java.util.*;
public class MinMaxArray {
	public static void main(String[] args) {
		Scanner sc=new  Scanner(System.in);
		System.out.println("size");
		int n=sc.nextInt();
		int ar[]=new int[n];
		System.out.println("elements");
		for(int i=0;i<ar.length;i++) {
			ar[i]=sc.nextInt();
		}
		System.out.println(Arrays.toString(minMaxAr(ar)));
		sc.close();
	}
	private static int[] minMaxAr(int[] ar) {
		int maxindex=ar.length-1;
		int minindex=0;
		int max=ar[maxindex]+1;
		for(int i=0;i<ar.length;i++) {
			if(i%2==0) {
				ar[i]=ar[i]+(ar[maxindex]%max)*max;
				maxindex--;
			}
			else {
				ar[i]=ar[i]+(ar[minindex]%max)*max;
				minindex++;
			}
		}
		for(int i=0;i<ar.length;i++) {
			ar[i]=ar[i]/max;
		}
		return ar;
	}
}

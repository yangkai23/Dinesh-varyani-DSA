package dsa.numerical;
import java.util.Scanner;
public class FibanocciBottomUp {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int result=getNthFibanocciNum(n);
		System.out.println(result);
		sc.close();
	}
	private static int getNthFibanocciNum(int n) {
		int ar[]=new int[n+1];
		ar[1]=0;
		ar[2]=1;
		for(int i=3;i<ar.length;i++) {
			ar[i]=ar[i-1]+ar[i-2];
		}
		return ar[n];
	}
}

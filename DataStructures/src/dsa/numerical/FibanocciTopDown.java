package dsa.numerical;
import java.util.Scanner;
public class FibanocciTopDown {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int result=getNthFibanocciNum(n);
	System.out.println(result);
	sc.close();
}
private static int getNthFibanocciNum(int n) {
	if(n==1)
		return 0;
	if(n==2)
		return 1;
	int a=getNthFibanocciNum(n-1);
	int  b=getNthFibanocciNum(n-2);
	int k=a+b;
	return k;
}
}

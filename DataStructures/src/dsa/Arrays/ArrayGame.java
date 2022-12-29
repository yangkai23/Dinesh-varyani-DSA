package dsa.Arrays;

import java.util.Scanner;

public class ArrayGame {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter game length");
		int len=sc.nextInt();
		int ar[]=new int[len];
		System.out.println("enter elements");
		for(int i=0;i<len;i++) {
			ar[i]=sc.nextInt();
		}
		System.out.println("enter leap");
		int leap=sc.nextInt();
		if(getGameResult(ar,leap))
			System.out.println("player won the game");
		else
			System.out.println("player lost the game");
		sc.close();
	}

	public static boolean getGameResult(int[] ar, int leap) {
		int player=0;
		for(int i=player;i<ar.length-1;i++) {
			System.out.println("i   "+i);
			if(ar[i+1]==0) {
				player=i+1;
				System.out.println("1  "+player);
			continue;	
			}
			if(i+leap>=ar.length)
				return true;
			else if(ar[i+leap]==0) {
				player=i+leap;
				System.out.println("2 "+player);
				if(i>0) {
					if(ar[i+1]==1&&ar[i-1]==0)
						player=i-1;
					}	
			}
			else
				return false;
			if(player>=ar.length)
				return true;
		}
		return true;
	}
}

package hiber;

import java.util.Scanner;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
			System.out.print(n);
		System.out.println();
		int temp=1;
		for(int i=0;i<n;i++){
			for(int j=0;j<n-1;j++){
			//	System.out.println("Amit");
				if(j==n-2)
					System.out.print(temp++);
				System.out.print(n);
			}
			System.out.println();
		}

	}

}

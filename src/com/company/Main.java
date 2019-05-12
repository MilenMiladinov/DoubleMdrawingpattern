package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    while(true){
	        Scanner s = new Scanner(System.in);
	        System.out.println("Enter an odd number more than 2, enter 0 to exit:");
	        int n = s.nextInt();
	        //condition for evaluation of allowed numbers
			if(n >= 3 && n < 10000 && n%2 != 0){
				//Defining the variables needed
				String emptyChar = "-";
				String letterChar = "*";
				String rowChars;
				List<String> rows = new ArrayList<>();
				String charSeq = "";

				//creating the base row
				String emptyRow = "";
				for(int i = 0; i <= n*5-1; i++){
					emptyRow += emptyChar;
				}

				//creating the sequence of the characters for drawing the M
				for(int i=0; i<n ; i++){
					charSeq += letterChar;
				}

				//substituting the string for each row to build all of the 2 left-to-right facing legs
				for(int i = n; i >= 0; i--){
					rowChars = emptyRow.substring(0,i)+charSeq+emptyRow.substring(i+n);;
					rows.add(rowChars);
					rows.set(n-i, rows.get(n-i).substring(0, i+n*2) + charSeq + rows.get(n-i).substring(i+n*3));
				}
				//substituting the string for each row to build all of the 2 right-to-left facing legs
				for(int i = 0; i <= n; i++){
					rows.set(i, rows.get(i).substring(0, i+n) + charSeq + rows.get(i).substring(i+n*2));
					rows.set(i, rows.get(i).substring(0, i+n*3) + charSeq + rows.get(i).substring(i+n*4));
					//mirroring the row so that the logo doubles
					rows.set(i, rows.get(i) + rows.get(i));
					System.out.println(rows.get(i));
				}
			}
			else if(n==0){
				System.out.println("Exiting program!");
				break;
			}
        }
    }
}

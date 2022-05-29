package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;
import java.io.IOException;

public class Program {

	public static void main(String[] args) throws IOException {

		if (args.length != 2) {
			System.err.println("Wrong usage");
		}

		char whiteChar = args[0].charAt(0);
		char blackChar = args[1].charAt(0);

		int array2D[][] = Logic.makeArrayFromBMP(whiteChar, blackChar);

		for (int i = 0; i < array2D.length; ++i) {
			for (int j = 0; j < array2D[i].length; ++j) {
				System.out.print((char)array2D[i][j]);
			}
			System.out.printf("\n");
		}
	}
}
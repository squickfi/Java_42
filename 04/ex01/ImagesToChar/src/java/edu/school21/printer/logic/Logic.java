package edu.school21.printer.logic;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Color;

public class Logic {

	public static int[][] makeArrayFromBMP(char whiteChar, char blackChar) throws IOException {

		BufferedImage image = ImageIO.read(Logic.class.getResource("/resources/it.bmp"));

		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();
		int array2D[][] = new int[imageHeight][imageWidth];

		for (int i = 0; i < imageHeight; ++i) {

			for (int j = 0; j < imageWidth; ++j) {

				int color = image.getRGB(j, i);
				if (color == Color.BLACK.getRGB()) {
					array2D[i][j] = blackChar;
				}
				else {
					array2D[i][j] = whiteChar;
				}
			}
		}
		return array2D;
	}
}
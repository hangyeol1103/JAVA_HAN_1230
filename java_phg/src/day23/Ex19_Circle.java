package day23;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex19_Circle {

	public static void main(String[] args) {
		
		try (FileWriter fw = new FileWriter("test.txt", true)) {
		    fw.write(97);
		    fw.write(65);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
	}
}

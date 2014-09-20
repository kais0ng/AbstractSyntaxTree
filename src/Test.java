import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import Util.ProcessDealer;
import AbstractSyntaxTree.Generator.Generator;

public class Test {
	private final static File Bison = new File("externProcess/ASTGenerator.exe");
	
	public static void main(String[] args) throws Exception {
		String inputFile = "files\\input.txt";
		String bisonOutputFile = "files\\bisonOutput.txt";
		String errorOutputFile = "files\\error.txt";
		Process bison = new ProcessDealer(Bison, new FileInputStream(inputFile), 
				new FileOutputStream(bisonOutputFile), new FileOutputStream(errorOutputFile)).run();
		System.out.println("===============");
		bison.waitFor();
		System.out.println("========");
		Generator generator = new Generator(bisonOutputFile);
		generator.Generate().Print(0);
		
	}
}

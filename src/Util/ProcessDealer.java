package Util;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class ProcessDealer {
	private File program;
	private InputStream input;
	private OutputStream output;	
	private OutputStream error;
	public ProcessDealer(File program, InputStream input, OutputStream output,
			OutputStream error) {
		if(program == null)
			throw new NullPointerException();
		this.program = program;
		this.input = input;
		this.output = output;
		this.error = error;
	}
	public Process run(){
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(program.getAbsolutePath());
			new Thread(new StreamCopy(input, process.getOutputStream())).start();
			new Thread(new StreamCopy(process.getInputStream(), output)).start();
			new Thread(new StreamCopy(process.getErrorStream(), error)).start();
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return process;
	}
	
}

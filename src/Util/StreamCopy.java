package Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class StreamCopy implements Runnable{
	
	private InputStream inputStream;
	private OutputStream outputStream;
	
	public StreamCopy(InputStream inputStream, OutputStream outputStream) {
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}
	@Override
	public void run() {
		int bufferSize = 1024, byteRead=0;
		byte[] bytes = new byte[bufferSize];
		try {
			while((byteRead=inputStream.read(bytes)) != -1){
				outputStream.write(bytes, 0, byteRead);
			}
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}finally{
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			}
			
		}
		
	}
//	public static void main(String[] args) throws FileNotFoundException {
//		FileInputStream fis  = new FileInputStream("C:\\Users\\kai.song\\Desktop\\source.txt");
//		FileOutputStream  fos = new FileOutputStream("C:\\Users\\kai.song\\Desktop\\copy.txt");
//		new StreamCopy(fis, fos).run();
//		System.out.println("copy done.....");
//	}
}

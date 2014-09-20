package AbstractSyntaxTree.Generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MicroProcesser {

	private File micro;
	private List<String> microList;
	private List<String> microValueList;

	public MicroProcesser() {

	}

	public MicroProcesser(File micro) {
		this.micro = micro;
	}

	public void process() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(micro)));

		microList = new ArrayList<String>();
		microValueList = new ArrayList<String>();

		String line;
		while ((line = br.readLine()) != null) {
			if (line.startsWith("#define")) {
				String[] para = line.split(" \t");
				if (para.length < 3)
					continue;
				StringBuffer sb = new StringBuffer();
				for (int index = 2; index < para.length; ++index)
					sb.append(para[index] + " ");
				sb.delete(sb.length() - 1, sb.length());
				microList.add(para[1]);
				microValueList.add(sb.toString());
			}
		}

		br.close();
	}

	public List<String> getMicroList() {
		return microList;
	}

	public List<String> getMicroValueList() {
		return microValueList;
	}
}

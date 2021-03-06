package myFileReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class MyFileReader {

	private JFileChooser fc = new JFileChooser();
	FileInputStream inputStream = null;
	Scanner sc = null;

	public void openFile() {
		try {
			fc.showOpenDialog(null);
			inputStream = new FileInputStream(fc.getSelectedFile());
			sc = new Scanner(inputStream, "UTF-8");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR opening file.");
		}
	}

	public void openFile(String path) {
		try {
			
			inputStream = new FileInputStream(path);
			sc = new Scanner(inputStream, "UTF-8");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR opening file.");
		}
	}
	
	public String readTitle() {
		StringBuffer sb = new StringBuffer();
		sb.append(sc.nextLine());
		//Removes head of description.
		int i = 3;
		while(i != 0){
			if(sb.charAt(0) == '|'){
				i--;
			}
			sb.delete(0, 1);
			
		}
		//Removes tail of description
		sb.delete(sb.indexOf("/"), sb.length());
		
		return sb.toString();
	}

	public String readFullFile() {
		StringBuffer sb = new StringBuffer();
		while (sc.hasNextLine()) {
			sb.append(sc.nextLine());

		}

		return sb.toString();
	}
	
	public char[] readFullIntoChar(){
		return readFullFile().toCharArray();
	}

	public String readLine() {
		return sc.nextLine();
	}


}

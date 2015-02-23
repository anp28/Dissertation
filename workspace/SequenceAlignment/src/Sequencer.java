public class Sequencer {

	String sequence1;
	String sequence2;
	MyFileReader fr = new MyFileReader();
	MyFileReader fr2 = new MyFileReader();
	MyAligner ma = new MyAligner();

	String s1Title, s2Title;

	public Sequencer() {

		fr.openFile("C:\\Users\\Andy\\Desktop\\Dissertation\\EbolaStrands\\KM233042.1.txt");
		// fr.openFile();
		fr.readTitle();
		sequence1 = fr.readFullFile();

		fr2.openFile("C:\\Users\\Andy\\Desktop\\Dissertation\\EbolaStrands\\KM233115.1.txt");
		// fr2.openFile();
		fr2.readTitle();
		sequence2 = fr2.readFullFile();

		long start, end;
		start = System.nanoTime();
/*
		// Using own
		String[] aligned = ma.align(sequence1, sequence2);
		end = System.nanoTime();
		System.out.println((end - start) + " : own");*/
/*
		// Needleman
		NeedlemanWunsch nw = new NeedlemanWunsch();
		start = System.nanoTime();
		nw.run(sequence1, sequence2);
		end = System.nanoTime();
		System.out.println((end - start) + " : Needleman");*/

		// SmithWaterman
		SmithWaterman sw = new SmithWaterman();
		start = System.nanoTime();
		sw.run(sequence1, sequence2);
		end = System.nanoTime();
		System.out.println((end - start) + " : Needleman");

		// Write the two sequences to file
		/*
		 * try { BufferedWriter writer = new BufferedWriter(new
		 * FileWriter("comparrison.txt"));
		 * 
		 * for (int x = 60; x < aligned[0].length() || x < aligned[1].length();
		 * x++) {
		 * 
		 * writer.write(aligned[0].substring((x-60), x));
		 * 
		 * writer.newLine();
		 * 
		 * writer.write(aligned[1].substring((x-60), x));
		 * 
		 * writer.newLine(); writer.newLine(); x+=60;
		 * 
		 * }
		 * 
		 * writer.close(); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

	}

}
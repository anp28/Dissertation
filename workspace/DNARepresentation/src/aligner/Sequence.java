package aligner;
public class Sequence {

	String sequence1 = null;
	String sequence2 = null;
	String sequence1Title = null;
	String sequence2Title = null;
	SequencerAligner sa = new SequencerAligner();
	String[] methods = {"Own","Needleman","SmithWaterman"};
	
	public void setSequence1(String s) {
		sequence1 = s;
	}
	
	public String[] getMethods(){
		return methods;
	}

	public String getSequence1() {
		return sequence1;
	}

	public void setSequence2(String s) {
		sequence2 = s;
	}

	public String getSequence2() {
		return sequence2;
	}

	public String setSequence1Title(String st) {
		return sequence1Title = st;
	}

	public String getSequence1Title() {
		return sequence1Title;
	}

	public String setSequence2Title(String st) {
		return sequence2Title = st;
	}

	public String getSequence2Title() {
		return sequence2Title;
	}
	
	public void getAlignmentMethods(){
		
	}
	
	public void alignSequences(String method){
		switch (method){
		case "Own" :
			sa.ownHack(sequence1, sequence2);
			break;
		case "Needleman" :
			sa.Needleman(sequence1, sequence2);
			break;
		case "SmithWaterman" :
			sa.SmithWaterman(sequence1, sequence2);
			break;
		}
	}

}



import com.softsynth.jsyn.*;

public class pianoLogic {

	String s = "TTTTGTGTGCGAATAACTATGAGGAAGA";

	int noteLength = 200;

	SawtoothOscillatorBL osc;
	LineOut lineOut;
	
	public static void main(String[] args){
		
		pianoLogic pl = new pianoLogic();
		
	}

	public pianoLogic() {
		//MyFileReader fr = new MyFileReader();

		// Start JSyn synthesizer.
		Synth.startEngine(0);
		// Create some unit generators.
		osc = new SawtoothOscillatorBL();
		lineOut = new LineOut();

		// Connect oscillator to both left and right channels of output.
		osc.output.connect(0, lineOut.input, 0);
		osc.output.connect(0, lineOut.input, 1);

		// Start the unit generators so they make sound.
		try {
			do {

			//	s = fr.readLine();
				System.out.print(s);
				osc.start();
				lineOut.start();
				for (int i = 0; i < s.length(); i++) {

					char c = s.charAt(i);

					if (c != ' ') {
						getHz(Character.getNumericValue(c));
					} else {
						osc.frequency.set(0);
						Synth.sleepForTicks(noteLength);
					}

				}

				 //Stop units and delete them to reclaim their resources.
				osc.stop();
				lineOut.stop();
				 osc.delete();
				 lineOut.delete();
			} while (s != null);
		} catch (Exception e) {
			System.exit(0);
		}

		// Stop JSyn synthesizer.
		Synth.stopEngine();

	}

	public void getHz(int note) {
		// conversion to piano
		 //f, frequency n, note number
		 //f(n) = 2(n-49/12) * 440

		int hertz = (note * 20);
		playNote(hertz);

	}

	public void playNote(double hertz) {

		// Set the frequency of the oscillator to 200 Hz.
		osc.frequency.set(hertz);
		osc.amplitude.set(0.1);

		// Sleep for awhile so we can hear the sound.
		Synth.sleepForTicks(noteLength);

	}

}
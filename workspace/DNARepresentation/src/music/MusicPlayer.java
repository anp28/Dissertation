package music;

import com.softsynth.jsyn.LineOut;
import com.softsynth.jsyn.SawtoothOscillatorBL;
import com.softsynth.jsyn.Synth;

public class MusicPlayer {

	double[] pianoNotes = { 27.5, 30.868, 32.703, 36.708, 41.203, 43.654, 48.999 };

	double volume = 0.1;

	SawtoothOscillatorBL osc;
	LineOut lineOut;

	public void play(boolean repeat, char[] notes, int[] noteLength, int[] octive) {

		Synth.startEngine(0);

		osc = new SawtoothOscillatorBL();

		lineOut = new LineOut();

		osc.output.connect(0, lineOut.input, 0);
		osc.output.connect(0, lineOut.input, 1);
		osc.start();
		lineOut.start();
		
		try {
			int n = 0;
			for (int o = 0; o < notes.length; o++) {
				char c = notes[o];
				
				switch (c) {
				case 'A':
					playNote('C', octive[o], noteLength[n]*100);
					break;
				case 'G':
					playNote('D', octive[o], noteLength[n]*100);
					break;
				case 'C':
					playNote('E', octive[o], noteLength[n]*100);
					break;
				case 'T':
					playNote('F', octive[o], noteLength[n]*100);
					break;
				}
				n++;
				if(n >= noteLength.length && notes.length > o){
					n = 0;
				}
				
				if (notes.length -1 == o && repeat) {
					o = 0;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		osc.stop();
		lineOut.stop();
		osc.delete();
		lineOut.delete();
		Synth.stopEngine();

	}

	public void playNote(char note, int octive, int noteLength) {
		double noteToPlay = 0;
		switch (note) {
		case 'A':
			noteToPlay = pianoNotes[0] * octive;
			break;
		case 'B':
			noteToPlay = pianoNotes[1] * octive;
			break;
		case 'C':
			noteToPlay = pianoNotes[2] * octive;
			break;
		case 'D':
			noteToPlay = pianoNotes[3] * octive;
			break;
		case 'E':
			noteToPlay = pianoNotes[4] * octive;
			break;
		case 'F':
			noteToPlay = pianoNotes[5] * octive;
			break;
		case 'G':
			noteToPlay = pianoNotes[6] * octive;
			break;
		default:
			noteToPlay = 0;
			break;
		}

		osc.frequency.set(noteToPlay);
		osc.amplitude.set(volume);

		Synth.sleepForTicks(noteLength);

		osc.frequency.set(0);
		osc.amplitude.set(volume);

		Synth.sleepForTicks(50);
	}

	public void stop(){
		osc.stop();
		lineOut.stop();
		osc.delete();
		lineOut.delete();
		Synth.stopEngine();
	}

}
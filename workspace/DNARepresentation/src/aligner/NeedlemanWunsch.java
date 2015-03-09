package aligner;
public class NeedlemanWunsch {
        char[] mSeqA;
        char[] mSeqB;
        int[][] mD;
        int mScore;
        String s1, s2;
        
        void init() {
             
                mD = new int[mSeqA.length + 1][mSeqB.length + 1];
                for (int i = 0; i <= mSeqA.length; i++) {
                        for (int j = 0; j <= mSeqB.length; j++) {
                                if (i == 0) {
                                        mD[i][j] = -j;
                                } else if (j == 0) {
                                        mD[i][j] = -i;
                                } else {
                                        mD[i][j] = 0;
                                }
                        }
                }
        }
        
        void process() {
                for (int i = 1; i <= mSeqA.length; i++) {
                        for (int j = 1; j <= mSeqB.length; j++) {
                                int scoreDiag = mD[i-1][j-1] + weight(i, j);
                                int scoreLeft = mD[i][j-1] - 1;
                                int scoreUp = mD[i-1][j] - 1;
                                mD[i][j] = Math.max(Math.max(scoreDiag, scoreLeft), scoreUp);
                        }
                }
        }
        
        void backtrack() {
        	   String mAlignmentSeqA = "";
               String mAlignmentSeqB = "";
               
                int i = mSeqA.length;
                int j = mSeqB.length;
                mScore = mD[i][j];
                while (i > 0 && j > 0) {                        
                        if (mD[i][j] == mD[i-1][j-1] + weight(i, j)) {                          
                                mAlignmentSeqA += mSeqA[i-1];
                                mAlignmentSeqB += mSeqB[j-1];
                                i--;
                                j--;                            
                                continue;
                        } else if (mD[i][j] == mD[i][j-1] - 1) {
                                mAlignmentSeqA += "-";
                                mAlignmentSeqB += mSeqB[j-1];
                                j--;
                                continue;
                        } else {
                                mAlignmentSeqA += mSeqA[i-1];
                                mAlignmentSeqB += "-";
                                i--;
                                continue;
                        }
                }
                s1 = new StringBuffer(mAlignmentSeqA).reverse().toString();
                s1 = new StringBuffer(mAlignmentSeqB).reverse().toString();
        }
        
        private int weight(int i, int j) {
                if (mSeqA[i - 1] == mSeqB[j - 1]) {
                        return 1;
                } else {
                        return -1;
                }
        }
        
        public void run(String sequence1, String sequence2) {               
        		s1 = sequence1;
        		s2 = sequence2;
        		mSeqA = s1.toCharArray();
        		mSeqB = s2.toCharArray();
                init();
                process();
                backtrack();
        }
}
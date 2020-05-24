package ConwaysGameOfLife;

public class Cell {

	private boolean status;
	private int id;
	static int number = 0;
	public Cell(boolean sStatus) {
		status = sStatus;
		id = number++;
	}
	
	public boolean isActive() {
		return status;
	}
	
	public void update(int pI, int pJ, boolean[][] pMa) {
		boolean result;
		int totA = 0;
		int[] iNumbers = {pI-1, pI, pI+1};
		int[] jNumbers = {pJ-1, pJ, pJ+1};
		
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {
				if (iNumbers[i] != pI || jNumbers[j] != pJ) {
					if (iNumbers[i] != -1 && jNumbers[j] != -1 && iNumbers[i] != Main.getMyMain().maxI && jNumbers[j] != Main.getMyMain().maxJ) {
						if (pMa[iNumbers[i]][jNumbers[j]]) {
							totA++;
						}
					}
				}
			}
		}
		
		if(status) {
			if(totA == 2 || totA == 3) {
				result = true;
			} else {
				result = false;
			}
		} else {
			if (totA == 3) {
				result = true;
			} else {
				result = false;
			}
		}
		status = result;
	}
}

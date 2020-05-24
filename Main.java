package ConwaysGameOfLife;

import java.io.IOException;

public class Main {
	private static Main myMain;
	private Cell[][] matrix;
	public final int maxI;
	public final int maxJ;
	private int iterationNmbr = 0;
	
	private Main(int maxI, int maxJ) {
		this.maxI = maxI;
		this.maxJ = maxJ;
		matrix = new Cell[maxI][maxJ];
	}
	
	public static Main getMyMain() {
		return myMain;
	}
	
	public static void main(String[] args) {
		myMain = new Main(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		myMain.start();
	}
	
	public void start() {
		kontsolaGarbitu();
		for (int i = 0; i<maxI;i++) {
			for (int j = 0; j<maxJ;j++) {
				matrix[i][j] = new Cell(Math.random() > 0.7);
			}
		}
		print();
		update();
	}
	
	public void update() {
		kontsolaGarbitu();
		boolean[][] bMatrix = matrixToBoolean();
		for (int i = 0; i<maxI;i++) {
			for (int j = 0; j<maxJ;j++) {
				matrix[i][j].update(i, j, bMatrix);
			}
		}
		print();
		System.out.println(iterationNmbr++);
		update();
	}
	
	private boolean[][] matrixToBoolean() {
		boolean[][] emaitza = new boolean[maxI][maxJ];
		
		for (int i = 0; i<maxI;i++) {
			for (int j = 0; j<maxJ;j++) {
				emaitza[i][j] = matrix[i][j].isActive();
			}
		}		
		return emaitza;
		
	}
	
	public void print() {
		for (int i = 0; i<maxI;i++) {
			System.out.print("|");
			for (int j = 0; j<maxJ;j++) {
				if (matrix[i][j].isActive()) {
					System.out.print("o");
				} else {
					System.out.print(" ");
				}				
			}
			System.out.println("|");
		}
	}
	
	public  void kontsolaGarbitu() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			else {
			    Runtime.getRuntime().exec("clear");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

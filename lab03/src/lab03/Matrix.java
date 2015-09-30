package lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Matrix {
	private String fileName;
	private double[][] result;
	private double[][] matrix1;
	private double[][] matrix2;

	public Matrix(String fileName) throws Exception {

		if (fileName == null)
			throw new Exception("Is necessary has a file name or path");

		this.fileName = fileName;

	}

	public String getFilePath() {
		return fileName;
	}

	public void setFilePath(String fileName2) {
		this.fileName = fileName2;
	}

	public void buildMatriX() throws FileNotFoundException {

		Scanner in = new Scanner(new File(fileName));
		String num = null;
		String[] val = null;
		Integer m1size = 0, m2size = 0, mResult = 0;
		int count = 0, linham1 = 0, linham2 = 0;

		// abrindo o arquivo linha por linha
		while (in.hasNext()) {
			num = new String(in.nextLine());
			num = num.replace(",", "");

			// criando as matrizes para serem preenchidas
			if (count == 0) {
				val = num.split(" ");
				// resgatando os tamanhos
				m1size = Integer.parseInt(val[0]);
				m2size = Integer.parseInt(val[1]);
				mResult = Integer.parseInt(val[2]);
				// criando as matrizes
				matrix1 = new double[m1size][m1size + 2];
				matrix2 = new double[m2size][m2size + 2];
				result = new double[mResult][mResult + 2];

			}
			count++;
			val = num.split(" ");
			// colocando os numeros na matriz 1
			if (count < (m1size + 3) && (count >= 3)) {

				for (int i = 0; i < val.length; i++) {

					matrix1[linham1][i] = Double.parseDouble(val[i]);

				}
				linham1++;
				// colocando os numeros na matriz 2
			} else if (count > (m1size + 3)) {

				for (int i = 0; i < val.length; i++) {

					matrix2[linham2][i] = Double.parseDouble(val[i]);

				}
				linham2++;

			}
		}

	}

	public void multiply() {

	}

	@Override
	public String toString() {
		// output da matrix final
		String mresult = "";
		for (int i = 0; i < result.length; i++) {

			for (int j = 0; j < result[i].length - 1; j++) {

				mresult += result[i][j] + " ";

			}
			mresult += "\n";
		}
		return mresult;

	}

	public static void main(String[] args) throws Exception {

		Matrix max = new Matrix("matrix.txt ");

		max.buildMatriX();
		max.multiply();
		System.out.println(max.toString());

	}

}

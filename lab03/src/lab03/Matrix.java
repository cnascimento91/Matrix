package lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matrix {
	private String fileName;
    private int m1C;
    private int m2R;
    private int m1Rm2C;
	private double[][] result;
	private double[][] matrix1;
	private double[][] matrix2;
/**
 * 
 * @param fileName
 * @throws Exception
 */
	public Matrix(String fileName) throws Exception {

		if (fileName == null)
			throw new Exception("Is necessary has a file name or path");

		this.fileName = fileName;

	}
/**
 * 
 * @return
 */
	public String getFilePath() {
		return fileName;
	}
/**
 * 
 * @param fileName2
 * @throws Exception
 */
	public void setFilePath(String fileName2) throws Exception {
		if (fileName == null)
			throw new Exception("Is necessary has a file name or path");
		this.fileName = fileName2;
	}

	public void buildMatriX() throws FileNotFoundException {

		Scanner in = new Scanner(new File(fileName));
		String num = null;
		String[] val = null;
		int count = 0, linham1 = 0, linham2 = 0;

		// abrindo o arquivo linha por linha
		while (in.hasNext()) {
			num = new String(in.nextLine());
			num = num.replace(",", "");

			// criando as matrizes para serem preenchidas
			if (count == 0) {
				setDimention(num);

			}
			count++;
			val = num.split(" ");
			// colocando os numeros na matriz 1
			if (count < (m1C + 3) && (count >= 3)) {

				for (int i = 0; i < val.length; i++) {

					matrix1[linham1][i] = Double.parseDouble(val[i]);

				}
				linham1++;
			// colocando os numeros na matriz 2
			} else if (count > (m1C + 3)) {

				for (int i = 0; i < val.length; i++) {

					matrix2[linham2][i] = Double.parseDouble(val[i]);

				}
				linham2++;

			}
           
		}

	}

	private void setDimention(String num) {
		String[] val;
		val = num.split(" ");
		// resgatando os tamanhos
		m1C = Integer.parseInt(val[0]);
		m1Rm2C = Integer.parseInt(val[1]);
		m2R = Integer.parseInt(val[2]);
		
		// criando as matrizes
		matrix1 = new double[m1C][m1Rm2C];
		matrix2 = new double[m1Rm2C][m2R];
		result = new double[m1C][m2R];
	}

	public void multiply() {
        for (int i = 0; i < m1C; i++){
            for (int j = 0; j < m2R; j++){
                for (int l = 0; l < m1Rm2C; l++){
                   result[i][j] +=  matrix1[i][l] * matrix2[l][j];
                }
            }
        }
	}

	@Override
	public String toString() {
		// output da matrix final
		String mresult = "";
		for (int i = 0; i < result.length; i++) {

			for (int j = 0; j < result[i].length; j++) {

				mresult += result[i][j] + " ";

			}
			mresult += "\n";
		}
		return mresult;

	}

	public static void main(String[] args) throws Exception {

		Matrix max = new Matrix("matrix.txt");

		max.buildMatriX();
		max.multiply();
		System.out.println(max.toString());

	}

}

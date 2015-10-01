package lab03;
/**
 * Ana Godoy and Cesar Augusto Ribeiro do Nascimento
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matrix
{
    private String fileName;
    private int m1R; // number of rows of matrix 1
    private int m2C; // number of columns of matrix 2
    private int m1Cm2R; // number of columns of matrix 1 and rows of matrix 2
    private double[][] result; // matrix result
    private double[][] matrix1; // matrix 1
    private double[][] matrix2; // matrix 2

    /**
     *
     * @param fileName name of the file which the matrixes will be read
     * @throws Exception
     */
    public Matrix( String fileName ) throws Exception
    {

        if ( fileName == null )
        {
            throw new Exception("Is necessary has a file name or path");
        }

        this.fileName = fileName;

    }

    /**
     *
     * @return
     */
    public String getFilePath()
    {
        return fileName;
    }

    /**
     *
     * @param fileName2 name of the file which the matrixes will be read
     * @throws Exception
     */
    public void setFilePath( String fileName2 ) throws Exception
    {
        if ( fileName == null )
        {
            throw new Exception("Is necessary has a file name or path");
        }
        this.fileName = fileName2;
    }

    /**
     *
     * @throws FileNotFoundException
     */
    public void buildMatriX() throws FileNotFoundException, Exception
    {

        Scanner in = new Scanner(new File(fileName));
        String num = null;
        String[] val = null;
        int count = 0, row1 = 0, row2 = 0;

        // reading the file line per line
        while ( in.hasNext() )
        {
            num = new String(in.nextLine());
            num = num.replace(",", "");

            // initializing the matrixes to be filled
            if ( count == 0 )
            {
                setDimention(num);
            }
            count++;
            val = num.split(" ");
            // filling out the matrix 1 by file
            if ( count < ( m1R + 3 ) && ( count >= 3 ) )
            {
                if ( val.length !=  m1Cm2R)
                {
                    throw new Exception("The matrix is not compatible with the dimensions");
                }

                for ( int i = 0; i < val.length; i++ )
                {

                    matrix1[row1][i] = Double.parseDouble(val[i]);

                }
                row1++;
                // filling out the matrix 2 by file
            }
            else if ( count > ( m1R + 3 ) )
            {
                if ( val.length !=  m2C)
                {
                    throw new Exception("The matrix is not compatible with the dimensions");
                }

                for ( int i = 0; i < val.length; i++ )
                {

                    matrix2[row2][i] = Double.parseDouble(val[i]);

                }
                row2++;

            }
        }

        if ( row1 !=  m1R)
        {
            throw new Exception("The matrix is not compatible with the dimensions");
        }

        if ( row2 !=  m1Cm2R)
        {
            throw new Exception("The matrix is not compatible with the dimensions");
        }

    }

    /**
     *
     * @param num string which store the values of the matrixes dimensions
     */
    private void setDimention( String num )
    {
        String[] val;
        val = num.split(" ");
        // getting the matrixes dimmensions
        m1R = Integer.parseInt(val[0]);
        m1Cm2R = Integer.parseInt(val[1]);
        m2C = Integer.parseInt(val[2]);

        // initializing the matrixes
        matrix1 = new double[m1R][m1Cm2R];
        matrix2 = new double[m1Cm2R][m2C];
        result = new double[m1R][m2C];
    }

    /**
     *
     */
    public void multiply()
    {
        for ( int i = 0; i < m1R; i++ )
        {
            for ( int j = 0; j < m2C; j++ )
            {
                for ( int l = 0; l < m1Cm2R; l++ )
                {
                    result[i][j] += matrix1[i][l] * matrix2[l][j];
                }
            }
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        // printing the final matrix
        String mresult = "";
        for ( int i = 0; i < result.length; i++ )
        {

            for ( int j = 0; j < result[i].length; j++ )
            {

                mresult += result[i][j] + " ";

            }
            mresult += "\n";
        }
        return mresult;

    }

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main( String[] args ) throws Exception
    {

        Matrix max = new Matrix("matrix.txt");

        max.buildMatriX();
        max.multiply();
        System.out.println(max.toString());

    }

}

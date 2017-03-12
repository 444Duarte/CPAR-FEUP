import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.min;

public class MatrixProd{
	static void onMultLine(int m_ar, int m_br){
		long init, end, elapsedTime;
		int i,j,k;

		double[] pha = new double[m_ar*m_ar];
		double[] phb = new double[m_ar*m_ar];
		double[] phc = new double[m_ar*m_ar];

		for(i=0; i<m_ar; i++)
			for(j=0; j<m_ar; j++)
				pha[i*m_ar + j] = (double)1.0;



		for(i=0; i<m_br; i++)
			for(j=0; j<m_br; j++)
				phb[i*m_br + j] = (double)(i+1);


		init = System.nanoTime();

		for(i = 0; i < m_ar ; i++){
			for(k = 0; k < m_ar; k++){
				for(j = 0; j < m_br; j++){
					phc[i*m_br+j] += pha[i*m_ar+k] * phb[k*m_br+j];
				}
			}
		}

		end = System.nanoTime();
		elapsedTime = end-init;

		System.out.println("Time: "+((double)elapsedTime / 1000000000.0)+" seconds");

		System.out.println("Result matrix: ");
		for(i=0; i<1; i++)
		{	for(j=0; j<min(10,m_br); j++)
			System.out.print((long)phc[j]+" ");
		}
		System.out.println();
	}

	static void onMult(int m_ar, int m_br){

		double temp;
		long init, end, elapsedTime;
		int i,j,k;

		double[] pha = new double[m_ar*m_ar];
		double[] phb = new double[m_ar*m_ar];
		double[] phc = new double[m_ar*m_ar];

		for(i=0; i<m_ar; i++)
			for(j=0; j<m_ar; j++)
				pha[i*m_ar + j] = (double)1.0;



		for(i=0; i<m_br; i++)
			for(j=0; j<m_br; j++)
				phb[i*m_br + j] = (double)(i+1);


		init = System.nanoTime();

		for(i=0; i<m_ar; i++)
		{	for( j=0; j<m_br; j++)
			{	temp = 0;
				for( k=0; k<m_ar; k++)
				{
					temp += pha[i*m_ar+k] * phb[k*m_br+j];
				}
				phc[i*m_ar+j]=temp;
			}
		}

		end = System.nanoTime();
		elapsedTime = end-init;

		System.out.println("Time: "+((double)elapsedTime / 1000000000.0)+" seconds");

		System.out.println("Result matrix: ");
		for(i=0; i<1; i++)
		{	for(j=0; j<min(10,m_br); j++)
			System.out.print((long)phc[j]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args){
		
		System.out.println("1. Multiplication");
		System.out.println("2. Line Multiplication");
		System.out.print("Selection?: ");

		Scanner scanner = new Scanner(System.in);

		int opt = scanner.nextInt();
		System.out.print("Dimensions: lins cols ? ");
		int lines = scanner.nextInt();
		int cols = scanner.nextInt();



		switch (opt){
			case 1:
				onMult(lines, cols);
				break;
			case 2:
				onMultLine(lines,cols);
				break;
			default:
				System.out.println("Error");
		}


	}		
}





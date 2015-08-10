package edu.uva.libopt.csensing;

import edu.uva.libopt.csensing.imp.LASSOCompressor;
import edu.uva.libopt.numeric.Utils;

public class TestCSMain {

	public static void main(String[] args){
		Compressor cp=new LASSOCompressor(1);
		double[][] dic=Utils.getRandomMatrix(400, 2000);
		double[] vec=Utils.getSparseRandomMatrix(1, 2000,0.05)[0]; 
		double[] out=cp.compress(dic, vec);
		for(double o:out)
			System.out.print(o+"\t");
		System.out.println();
		double[] out2=new double[vec.length];
		System.out.println("error"+cp.decompress(dic, out, out2));
		for(double o:out2)
			System.out.print(o+"\t");
		System.out.println();
		double error=0;
		double sum=0;
		for(int i=0;i<out2.length;i++){
			error+=Math.abs(vec[i]-out2[i]);
			sum+=Math.abs(vec[i]);
		}
		for(double o:vec)
			System.out.print(o+"\t");
		System.out.println();
		System.out.println("recovery error\t"+(error/sum));

	}
	
}

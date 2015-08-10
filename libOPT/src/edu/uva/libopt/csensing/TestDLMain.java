package edu.uva.libopt.csensing;

import java.util.ArrayList;
import java.util.List;

import edu.uva.libopt.csensing.imp.LASSOCompressor;
import edu.uva.libopt.csensing.imp.LazyLassoLearner;
import edu.uva.libopt.numeric.Utils;

public class TestDLMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<double[]> list=new ArrayList<double[]>();
		for(int i=0;i<10;i++)
			list.add(Utils.getSparseRandomMatrix(1, 30,0.1)[0]);
		DictionaryLearner dl=new LazyLassoLearner(1);
		double[][] dict=dl.learn(list, 30, 100);
		Compressor cp=new LASSOCompressor(1);
		System.out.println("compression");
///////
		double[] vec=Utils.getSparseRandomMatrix(1, 100,0.1)[0]; 
		double[] out=cp.compress(dict, vec);
		for(double o:out)
			System.out.print(o+"\t");
		System.out.println();
		double[] out2=new double[vec.length];
		System.out.println("error"+cp.decompress(dict, out, out2));
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

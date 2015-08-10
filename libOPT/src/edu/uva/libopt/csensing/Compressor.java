package edu.uva.libopt.csensing;

public interface Compressor {
	
	public double[] compress(double[][] dic, double[] vector);
	
	public double decompress(double[][] dic, double[] vector, double[] output);


}

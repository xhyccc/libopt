package edu.uva.libopt.numeric;

public interface NumericOptimizer {

	public double getMinimum(double[] X, double epsilon, double delta, NumericFunction f);
	
}

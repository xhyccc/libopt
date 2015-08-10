package edu.uva.libopt.ml.density;

public interface ProbabilityDensityFunction {
	public double negativeLogLiklihood(double[] params, double[] data);
}

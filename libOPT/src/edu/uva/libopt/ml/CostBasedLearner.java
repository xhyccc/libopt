package edu.uva.libopt.ml;

public interface CostBasedLearner {
	public double costFunction(double[] params);
}

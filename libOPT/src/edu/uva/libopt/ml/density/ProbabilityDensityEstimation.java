package edu.uva.libopt.ml.density;

import edu.uva.libopt.ml.CostBasedLearner;

public interface ProbabilityDensityEstimation extends CostBasedLearner{
	public void statistics(double[][] datas);
	public double negativeLogLiklihood(double[] data);
}

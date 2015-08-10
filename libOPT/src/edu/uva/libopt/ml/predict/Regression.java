package edu.uva.libopt.ml.predict;

import java.util.List;

import edu.uva.libopt.ml.CostBasedLearner;

public interface Regression extends CostBasedLearner{
	public void learn(List<double[]> datas, List<Integer> labels);
	public double predict(double[] data);
}

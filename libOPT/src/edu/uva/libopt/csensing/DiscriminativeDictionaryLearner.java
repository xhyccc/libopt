package edu.uva.libopt.csensing;

import java.util.List;

public interface DiscriminativeDictionaryLearner {

	public double[][] leanr(List<double[]> vectors, List<Integer> labels, int row, int col);
	
}

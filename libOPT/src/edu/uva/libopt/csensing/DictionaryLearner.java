package edu.uva.libopt.csensing;

import java.util.List;

public interface DictionaryLearner {
	
	double[][] learn(List<double[]> vectors, int row, int col);
}

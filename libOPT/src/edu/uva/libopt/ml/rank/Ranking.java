package edu.uva.libopt.ml.rank;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.uva.libopt.ml.CostBasedLearner;

public interface Ranking<T> extends CostBasedLearner{
	public void learn(List<Map<T,Double>> datas);
	public Map<T,Double> rank(Map<T,Double> data);
}


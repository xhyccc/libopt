package edu.uva.libopt.combine;

import java.util.Set;

public interface CombineOptimizer<T> {

	public double getMaximum(Set<T> X, CombineFunction<T> f, CombineCriterion<T> e);
	
}

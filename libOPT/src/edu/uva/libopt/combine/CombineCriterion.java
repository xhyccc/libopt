package edu.uva.libopt.combine;

import java.util.Set;

public interface CombineCriterion<T> {

	public boolean stop(Set<T> X);
	
}

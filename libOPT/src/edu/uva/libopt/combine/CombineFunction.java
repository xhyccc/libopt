package edu.uva.libopt.combine;

import java.util.Set;

public interface CombineFunction<T> {

	public Set<T> overallSet();

	public double func(Set<T> X);
	
}

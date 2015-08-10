package edu.uva.libopt.combine;

import java.util.Set;

public interface NestCombineFunction<T> extends CombineFunction<T>{
	public NestCombineFunction<T> getNextCombineFunction(Set<T> _X);
}

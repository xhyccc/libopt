package edu.uva.libopt.combine.optimizer;

import java.util.HashSet;
import java.util.Set;

import edu.uva.libopt.combine.CombineCriterion;
import edu.uva.libopt.combine.CombineFunction;
import edu.uva.libopt.combine.CombineOptimizer;

public class GreedyDescentOptimizer<T> implements CombineOptimizer<T> {

	@Override
	public double getMaximum(Set<T> X, CombineFunction<T> f, CombineCriterion<T> e) {
		// TODO Auto-generated method stub
		Set<T> remain = new HashSet<T>(f.overallSet());
		while (!remain.isEmpty()) {
			double maxFunc = Double.NEGATIVE_INFINITY;
			T maxIns = null;
			for (T ins : remain) {
				X.addAll(remain);
				X.remove(ins);
				double func = f.func(X);
				if (func > maxFunc && !e.stop(X)) {
					maxFunc = func;
					maxIns = ins;
				}
				X.removeAll(remain);
			}
			if (maxIns == null) {
				X.addAll(remain);
				return f.func(X);
			} else {
				remain.remove(maxIns);
			}
		}
		X.addAll(remain);
		return f.func(X);
	}

}

package edu.uva.libopt.combine.optimizer;

import java.util.HashSet;
import java.util.Set;

import edu.uva.libopt.combine.CombineCriterion;
import edu.uva.libopt.combine.CombineFunction;
import edu.uva.libopt.combine.CombineOptimizer;

public class GreedyAscentOptimizer<T> implements CombineOptimizer<T>{

	@Override
	public double getMaximum(Set<T> X, CombineFunction<T> f, CombineCriterion<T> e) {
		// TODO Auto-generated method stub
		Set<T> notYetSelect=new HashSet<T>(f.overallSet());
		while(!notYetSelect.isEmpty()){
			double maxFunc = Double.NEGATIVE_INFINITY;
			T maxIns=null;
			for(T ins:notYetSelect){
				X.add(ins);
				double func=f.func(X);
				if(func>maxFunc&&!e.stop(X)){
					maxFunc=func;
					maxIns=ins;
				}
				X.remove(ins);
			}
			if(maxIns==null)
				return f.func(X);
			X.add(maxIns);
		}
		return f.func(X);
	}

}

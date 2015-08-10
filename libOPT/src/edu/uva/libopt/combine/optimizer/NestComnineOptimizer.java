package edu.uva.libopt.combine.optimizer;

import java.util.HashSet;
import java.util.Set;

import edu.uva.libopt.combine.CombineCriterion;
import edu.uva.libopt.combine.CombineFunction;
import edu.uva.libopt.combine.CombineOptimizer;
import edu.uva.libopt.combine.NestCombineFunction;

public class NestComnineOptimizer<T> implements CombineOptimizer<T> {
	
	private  CombineOptimizer<T> optimizer=null;
	
	public NestComnineOptimizer(CombineOptimizer<T> opt){
		this.optimizer=opt;
	}

	@Override
	public double getMaximum(Set<T> X, CombineFunction<T> f, CombineCriterion<T> e) {
		NestCombineFunction<T> nf=(NestCombineFunction<T>)f;
		Set<T> Xx=new HashSet<T>(X);
		double maximum=this.optimizer.getMaximum(Xx, nf, e);
		nf=nf.getNextCombineFunction(Xx);
		Set<T> Xxx=new HashSet<T>(X);
		double _maximum=this.optimizer.getMaximum(Xxx, nf, e);
		while(_maximum>maximum){
			nf=nf.getNextCombineFunction(Xxx);
			maximum=_maximum;
			Xx=Xxx;
			Xxx=new HashSet<T>(X);
			_maximum=this.optimizer.getMaximum(Xxx, nf, e);
		}
		X.removeAll(X);
		X.addAll(Xx);
		return maximum;
	}

}

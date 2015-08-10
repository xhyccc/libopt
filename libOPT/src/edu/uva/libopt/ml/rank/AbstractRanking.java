package edu.uva.libopt.ml.rank;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public abstract class AbstractRanking<T> implements Ranking<T>{
	
	public double rateAbsoluteError(Map<T,Double> lsa, Map<T, Double> lsb){
		double error=0;
		for(T a:lsa.keySet()){
			if(lsb.containsKey(a)){
				error+=Math.abs(lsa.get(a)-lsb.get(a));
			}
		}
		return error;
	}
	
	public int orderError(Map<T,Double> lsa, Map<T, Double> lsb){
		int error=0;
		Set<T> inter=this.getIntersection(lsa.keySet(), lsb.keySet());
		for(T a:inter){
			for(T b:inter){
				if(a!=b){
					double ga=lsa.get(a)-lsa.get(b);
					double gb=lsb.get(b)-lsb.get(b);
					if(ga*gb<0){
						error++;
					}else if(ga==0&&gb!=0){
						error++;
					}else if(ga!=0&&gb==0){
						error++;
					}
				}
			}
		}

		return error;
	}
	
	public Set<T> getIntersection(Set<T> a, Set<T> b){
		Set<T> inter=new HashSet<T>();
		for(T aa:a){
			if(b.contains(aa))
				inter.add(aa);
		}
		return inter;
	}
}

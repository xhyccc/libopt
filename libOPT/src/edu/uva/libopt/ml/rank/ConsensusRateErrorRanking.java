package edu.uva.libopt.ml.rank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.uva.libopt.ml.CostBasedLearner;
import edu.uva.libopt.ml.CostBasedTrainer;
import edu.uva.libopt.numeric.Utils;

public class ConsensusRateErrorRanking<T> extends AbstractRanking<T> implements CostBasedLearner{

	protected List<Map<T,Double>> _datas;
	protected Set<T> _overallSet=null;
	protected double[] _params;
	public double epsilon = 0.001;
	public double delta = 0.001;
	public double lambda = 0.5;
	
	@Override
	public void learn(List<Map<T,Double>> datas) {
		// TODO Auto-generated method stub
		this._datas=datas;
		this._overallSet=new HashSet<T>();
		for(Map<T,Double> data:_datas){
			this._overallSet.addAll(data.keySet());
		}
		this._params=new double[datas.size()];
		for(int i=0;i<this._params.length;i++)
			this._params[i]=1.0/datas.size();
		CostBasedTrainer cbt=new CostBasedTrainer(this);
		cbt.trainSparseParams(Utils.L1, lambda, this._params);
	}
	
	public Map<T,Double> weightedRank(double[] params) {
		// TODO Auto-generated method stub
		Map<T,Double> agg=new HashMap<T,Double>();
		for(T ins:_overallSet){
			agg.put(ins, 0.0);
			for(Map<T,Double> data:_datas){
				if(data.containsKey(ins)){
					agg.put(ins, agg.get(ins)+data.get(ins)
							*params[_datas.indexOf(data)]);
				}
			}
		}
		return agg;
	}

	@Override
	public Map<T,Double> rank(Map<T,Double> data) {
		// TODO Auto-generated method stub
		return this.weightedRank(_params);
	}

	@Override
	public double costFunction(double[] params) {
		// TODO Auto-generated method stub
		Map<T,Double> agg=this.weightedRank(params);
		double error=0;
		for(Map<T,Double> data:_datas)
			error+=super.rateAbsoluteError(agg, data);
		return error;
	}

}

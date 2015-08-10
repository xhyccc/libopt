package edu.uva.libopt.ml.density;

import edu.uva.libopt.ml.CostBasedTrainer;

public class MLPDEstimator implements ProbabilityDensityEstimation{

	private double[][] _rowDatas=null;
	private double[] _params=null;
	private ProbabilityDensityFunction _pdf=null;
	
	public MLPDEstimator(double[] params, ProbabilityDensityFunction pdf){
		this._params=params;
		this._pdf=pdf;
	}
	
	@Override
	public double costFunction(double[] params) {
		// TODO Auto-generated method stub
		double nll=0;
		for(double[] rowData:_rowDatas){
			nll+=this._pdf.negativeLogLiklihood(params, rowData);
		}
		return nll;
	}
	@Override
	public void statistics(double[][] datas) {
		// TODO Auto-generated method stub
		this._rowDatas=datas;
		CostBasedTrainer trainer=new CostBasedTrainer(this);
		trainer.trainDenseParams(this._params);
	}

	@Override
	public double negativeLogLiklihood(double[] data) {
		// TODO Auto-generated method stub
		return this._pdf.negativeLogLiklihood(_params, data);
	}

}

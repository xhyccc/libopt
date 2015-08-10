package edu.uva.libopt.ml.rank.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.uva.libopt.ml.rank.ConsensusOrderRanking;
import edu.uva.libopt.ml.rank.ConsensusRateErrorRanking;
import edu.uva.libopt.ml.rank.FeedbackRateErrorRanking;
import edu.uva.libopt.ml.rank.Ranking;

public class RankTest {

	public static void main(String[] args){
		List<Map<String,Double>> lss=new ArrayList<Map<String,Double>>();
		Map<String,Double> ls1=new HashMap<String,Double>();
		Map<String,Double> ls2=new HashMap<String,Double>();
		Map<String,Double> ls3=new HashMap<String,Double>();
		Map<String,Double> ls4=new HashMap<String,Double>();
		Map<String,Double> ls5=new HashMap<String,Double>();
		String a="A";
		String b="B";
		String c="C";
		String d="D";
		String e="E";
		String f="F";
		
		ls1.put(a, 1.0);
		ls1.put(b, 1.0);
		ls1.put(e, 1.0);
		
		ls2.put(c, 1.0);
		ls2.put(d, 1.0);
		ls2.put(b, 1.0);

		ls3.put(b, 1.0);
		ls3.put(c, 1.0);
		ls3.put(f, 1.0);
		
		ls4.put(a, 1.0);
		ls4.put(d, 1.0);
		ls4.put(b, 1.0);
		
	//	ls5.put(f, 1.0);
	//	ls5.put(d, 1.0);
		ls5.put(a, 1.0);
		
		
		
		lss.add(ls1);
		lss.add(ls2);
		lss.add(ls3);
		lss.add(ls4);
	//	lss.add(ls5);
		Ranking<String> rank=new FeedbackRateErrorRanking<String>();
		rank.learn(lss);
		Map<String,Double> lsr=rank.rank(ls5);
		System.out.println(lsr.toString());
	}
	
}

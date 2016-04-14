package edu.iis.mto.similarity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;


public class SimilarityFinderTest {
	private double delta = 0.001;
	
	private int[] seq1,seq2;
	private SimilarityFinder similarityFinder;
	private SequenceSearcherStub searcher;
	@Before
	public void setUp(){
	searcher = new SequenceSearcherStub();
	similarityFinder = new SimilarityFinder(searcher);
	}
	
	@Test
	public void sequencesLengthsAreEqualZeroAndCalculateJackardSimilarityMethodShouldReturn1() {
		seq1 = new int[0];
		seq2 = new int[0];
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2),closeTo(1,delta));
	}
	
	@Test
	public void sequencesAreTheSameAndMethodShouldReturn1(){
		seq1 = new int[] {1,2};
		seq2 = new int[] {1,2};
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2),closeTo(1,delta));
	}	
}

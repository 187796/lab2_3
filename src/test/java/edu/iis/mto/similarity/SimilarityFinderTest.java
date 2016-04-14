package edu.iis.mto.similarity;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import edu.iis.mto.search.SequenceSearcher;


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
	
	@Test
	public void sequencesAreDiffrentAndMethodShouldReturn0(){
		seq1 = new int[] {1,3,5};
		seq2 = new int[] {0,2,4};
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2),closeTo(0,delta));
	}
	
	@Test
	public void sequencesAreEmptyAndCalculateJackardSimilarityMethodShouldNotBeCalled(){
		SequenceSearcher searcher2 = mock(SequenceSearcher.class);
		similarityFinder = new SimilarityFinder(searcher2);
		seq1 = new int[0];
		seq2 = new int[0];
		
		similarityFinder.calculateJackardSimilarity(seq1, seq2);
		verify(searcher2, never()).search(0,seq1);
	}
	
}

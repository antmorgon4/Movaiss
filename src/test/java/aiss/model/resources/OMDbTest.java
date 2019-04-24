package aiss.model.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.omdb.MovieSearch;

public class OMDbTest {

	@Test
	public void getMoviesTest() throws UnsupportedEncodingException {
		String title = "Star Wars";
		omdbResource movie = new omdbResource();
		MovieSearch omdbResults = movie.getMovies(title);
		
		assertNotNull("The search returned null", omdbResults);
		assertNotNull("The search returned null", omdbResults.getSearch());
		assertFalse("The number of albums of " + title + " is zero", omdbResults.getSearch().size()==0);
		
		System.out.println("The search for " + title + "'s albums returned " + omdbResults.getSearch().size() + " movies.");
		
	
	}

}

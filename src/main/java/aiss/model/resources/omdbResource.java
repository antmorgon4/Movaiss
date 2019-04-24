package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.omdb.MovieSearch;
import aiss.model.resources.omdbResource;

public class omdbResource {

	private static final String OMDB_API_KEY = "f2ac4203"; // API KEY de Javi
	private static final Logger log = Logger.getLogger(omdbResource.class.getName());

	public MovieSearch getMovies(String query) throws UnsupportedEncodingException {
		
		String search = URLEncoder.encode(query, "UTF-8"); // Aseguramos el formato de la búsqueda

		String uri = "http://www.omdbapi.com/?" + "apikey=" + OMDB_API_KEY + "&s=" + search; // Creamos la uri de la petición
		
		MovieSearch movieSearch = null;
		
		ClientResource cr = null; 
		
		try {
			
			cr = new ClientResource(uri);
		
			movieSearch = cr.get(MovieSearch.class); // Hacemos la movida de Java to JSON y tal

			log.log(Level.FINE, "BUSQUEDA:" + search + "NUEVA URI" + uri); // Logs del URI
		}catch (ResourceException re) {
			log.log(Level.WARNING, "Oooooopss, la búsqueda no ha ido como se esperaba");
			throw re;
		}
		return movieSearch;
	}


	
}

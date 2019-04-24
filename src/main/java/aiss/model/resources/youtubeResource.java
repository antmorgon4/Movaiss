package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.restlet.resource.ClientResource;

import aiss.model.youtubeSearch.YoutubeSearchId;


public class youtubeResource {

	private static final String YOUTUBE_API_KEY = "AIzaSyBukdvWRG3riipGBvgQqvr5FMmbRZdc9EE"; // 
																								
	
	

	public YoutubeSearchId getYoutubeVideos(String query) throws UnsupportedEncodingException {
		
		String search = URLEncoder.encode(query, "UTF-8");

		String URA = "https://www.googleapis.com/youtube/v3/search?part=id&q=" + search + "+ trailer"
				+ "&key=" + YOUTUBE_API_KEY;

		ClientResource cr = new ClientResource(URA);
		YoutubeSearchId video = cr.get(YoutubeSearchId.class);

		return video;
	}
	
	
	//URI: https://www.googleapis.com/youtube/v3/search?part=id&q=Trainspotting+Trailer&key={YOUR_API_KEY}
}

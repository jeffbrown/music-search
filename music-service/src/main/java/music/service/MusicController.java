package music.service;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import music.service.search.ItunesClient;
import music.service.search.SearchResult;

import java.util.List;

@Controller("/music")
public class MusicController {

    private ItunesClient itunesClient;

    public MusicController(ItunesClient itunesClient) {
        this.itunesClient = itunesClient;
    }

    @Get("/search/{searchTerm}")
    public List<Album> search(String searchTerm) {
        SearchResult result = itunesClient.search(searchTerm);
        return result.getResults();
    }
}

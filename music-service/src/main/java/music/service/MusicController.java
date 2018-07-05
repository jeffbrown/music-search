package music.service;

import io.micronaut.core.util.StringUtils;
import io.micronaut.http.HttpParameters;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import music.service.search.ItunesClient;
import music.service.search.SearchResult;

import javax.annotation.Nullable;
import java.util.List;

@Controller("/music")
public class MusicController {

    private ItunesClient itunesClient;

    public MusicController(ItunesClient itunesClient) {
        this.itunesClient = itunesClient;
    }

    @Get("/search/{searchTerm}")
    public List<Album> search(String searchTerm, @Nullable @QueryValue String maxResults) {
        final int limit;
        if(StringUtils.isDigits(maxResults)) {
            limit = Math.min(25, Integer.parseInt(maxResults));
        } else {
            limit = 25;
        }

        SearchResult result = itunesClient.search(searchTerm, limit);
        return result.getResults();
    }
}

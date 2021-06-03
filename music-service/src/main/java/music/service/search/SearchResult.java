package music.service.search;

import io.micronaut.core.annotation.Introspected;
import music.service.Album;

import java.util.ArrayList;
import java.util.List;

@Introspected
public class SearchResult {

    private int resultCount;
    private List<Album> results = new ArrayList<Album>();

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<Album> getResults() {
        return results;
    }

    public void setResults(List<Album> results) {
        this.results = results;
    }
}
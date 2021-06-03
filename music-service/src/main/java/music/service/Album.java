package music.service;


import com.fasterxml.jackson.annotation.JsonSetter;
import io.micronaut.core.annotation.Introspected;

@Introspected
public class Album {
    private String collectionName;
    private String artistName;
    private String url;

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getUrl() {
        return url;
    }

    @JsonSetter("collectionViewUrl")
    public void setUrl(String url) {
        this.url = url;
    }
}

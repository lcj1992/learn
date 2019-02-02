package lamda.music;

import java.util.List;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/5/1
 * Time: 下午8:13
 */
public class Album {

    private String name;

    private List<Track> tracks;

    private List<Artist> musicians;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Artist> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Artist> musicians) {
        this.musicians = musicians;
    }
}

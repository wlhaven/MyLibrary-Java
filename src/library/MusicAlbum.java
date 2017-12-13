package library;

import java.util.Collections;
import java.util.TreeSet;
import java.util.Arrays;

class MusicAlbum extends Item {

    private final String band;
    private final int nbrSongs;
    private final TreeSet<String> bandMembers;

    public MusicAlbum(String itemTitle, String band, int nbrSongs, String... keywords) {

        super(itemTitle, keywords);
        this.band = band;
        this.nbrSongs = nbrSongs;
        bandMembers = new TreeSet<>();

    }

    public TreeSet<String> getBandMembers() {
        return bandMembers;
    }
    public String getBand() {
        return band;
    }
    public void setMembers(String... members) {
        Collections.addAll(bandMembers, members);
    }

    @Override
    public String toString() {
        return String.format("-Music Album-\nband:     %s\n# songs:  %d\nmembers:  %s\n%s", band, nbrSongs,
                Arrays.toString(bandMembers.toArray()).replace('[', ' ').replace(']',
                        ' ').trim(), super.toString());
    }
}

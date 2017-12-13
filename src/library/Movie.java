package library;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

class Movie extends Item {

    private final String director;
    private final int nbrScenes;
    private final TreeSet<String> castMembers;

    public Movie(String itemTitle, String director, int nbrScenes, String... keywords) {

        super(itemTitle, keywords);
        this.director = director;
        this.nbrScenes = nbrScenes;
        castMembers = new TreeSet<>();
    }

    public void setMembers(String... members) {
        Collections.addAll(castMembers, members);
    }

    public TreeSet<String> getCastMembers() {
        return castMembers;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return String.format("-Movie-\ndirector: %s\n# scenes: %d\ncast:     %s\n%s", director, nbrScenes,
                Arrays.toString(castMembers.toArray()).replace('[', ' ').replace(']',
                        ' ').trim(), super.toString());
    }
}

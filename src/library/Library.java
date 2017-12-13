package library;

import java.io.PrintStream;
import java.util.*;

public class Library {

    private final Map<String, Item> titleMap = new TreeMap<>();
    private final Map<String, Item> bandMap = new TreeMap<>();
    private final Map<String, Item> movieMap = new TreeMap<>();
    private final Map<String, Item> keyMap = new TreeMap<>();


    public Library() {
        System.out.print("CS261 - Assignment 3 - Wally Haven\n\n");
    }
    // general methods

    // Removes the maps
    private boolean removeItem(String title, Map<String, Item> map) {
        Boolean flag = false;

        if(keyMap.remove(title) != null && map.remove(title) != null)
            flag = true;

        return flag;
    }

    // returns all of the items which have the specified keyword
    public Collection<Item> itemsForKeyword(String keyword) {
        List<Item> tmpkeyWords = new ArrayList<>();

        for (Map.Entry<String, Item> entry : keyMap.entrySet()) {
            Item item = entry.getValue();
            TreeSet<String> tmpMember = item.getItemKeywords();
            if (tmpMember.contains(keyword))
                tmpkeyWords.add(item);
        }
        return tmpkeyWords;
    }

    // print an item from this library to the output stream provided
    public void printItem(PrintStream out, Item item) {
        out.print(item.toString());
        out.println();
    }

    // book-related methods

    // adds a book to the library
    public Item addBook(String title, String author, int nPages, String... keywords) {
        Book newBook = new Book(title, author, nPages, keywords);
        titleMap.put(title, newBook);
        keyMap.put(title, newBook);

        return newBook;
    }

    // removes a book from the library
    public boolean removeBook(String title) {
        return removeItem(title, titleMap);
    }

    // returns all of the books by the specified author
    public Collection<Item> booksByAuthor(String author) {
        List<Item> tmpAuthor = new ArrayList<>();

        for (Map.Entry<String, Item> entry : titleMap.entrySet()) {
            Book item = (Book) entry.getValue();
            if (item.getAuthor().equals(author)) {
                tmpAuthor.add(item);
            }
        }
        return tmpAuthor;
    }

    // returns all of the books in the library
    public Collection<Item> books() {
        return titleMap.values();
    }

    // music-related methods

    // adds a music album to the library
    public Item addMusicAlbum(String title, String band, int nSongs, String... keywords) {
        MusicAlbum newAlbum = new MusicAlbum(title, band, nSongs, keywords);
        bandMap.put(title, newAlbum);
        keyMap.put(title, newAlbum);

        return newAlbum;
    }

    // adds the specified band members to a music album
    public void addBandMembers(Item album, String... members) {
        album.setMembers(members);
    }

    // removes a music album from the library
    public boolean removeMusicAlbum(String title) {
        return removeItem(title, bandMap);
    }


    // returns all of the music albums by the specified band
    public Collection<Item> musicByBand(String band) {
        List<Item> tmpBand = new ArrayList<>();

        for (Map.Entry<String, Item> entry : bandMap.entrySet()) {
            MusicAlbum item = (MusicAlbum) entry.getValue();
            String tmpMember = item.getBand();
            if (tmpMember.equals(band)) {
                tmpBand.add(item);
            }
        }
        return tmpBand;
    }

    // returns all of the music albums by the specified musician
    public Collection<Item> musicByMusician(String musician) {
        List<Item> tmpBand = new ArrayList<>();

        for (Map.Entry<String, Item> entry : bandMap.entrySet()) {
            MusicAlbum item = (MusicAlbum) entry.getValue();
            TreeSet<String> tmpMember = item.getBandMembers();
            if (tmpMember.contains(musician)) {
                tmpBand.add(item);
            }
        }
        return tmpBand;
    }

    // returns all of the music albums in the library
    public Collection<Item> musicAlbums() {
        return bandMap.values();
    }

    // movie-related methods

    // adds a movie to the library
    public Item addMovie(String title, String director, int nScenes, String... keywords) {
        Movie newMovie = new Movie(title, director, nScenes, keywords);
        movieMap.put(title, newMovie);
        keyMap.put(title, newMovie);
        return newMovie;
    }

    // adds the specified actors to a movie
    public void addCast(Item movie, String... members) {
        movie.setMembers(members);
    }

    // removes a movie from the library
    public boolean removeMovie(String title) {
        return removeItem(title, movieMap);
    }

    // returns all of the movies by the specified director
    public Collection<Item> moviesByDirector(String director) {
        List<Item> tmpMovie = new ArrayList<>();

        for (Map.Entry<String, Item> entry : movieMap.entrySet()) {
            Movie item = (Movie) entry.getValue();
            String tmpMember = item.getDirector();
            if (tmpMember.equals(director)) {
                tmpMovie.add(item);
            }
        }
        return tmpMovie;
    }

    // returns all of the movies by the specified actor
    public Collection<Item> moviesByActor(String actor) {
        List<Item> tmpActor = new ArrayList<>();

        for (Map.Entry<String, Item> entry : movieMap.entrySet()) {
            Movie item = (Movie) entry.getValue();
            TreeSet<String> tmpMember = item.getCastMembers();
            if (tmpMember.contains(actor)) {
                tmpActor.add(item);
            }
        }
        return tmpActor;
    }

    // returns all of the movies in the library
    public Collection<Item> movies() {
        return movieMap.values();
    }
}

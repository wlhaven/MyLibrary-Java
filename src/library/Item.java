// Each book, music album, or movie will be an instance of a subclass of this class.
// Instances of this class should not be created. Specifying it as 'abstract' ensures
// that they cannot.

package library;

import java.util.Collections;
import java.util.TreeSet;
import java.util.Arrays;

public abstract class Item {

    private final String itemTitle;
    private final TreeSet<String> itemKeywords = new TreeSet<>();

    Item(String itemTitle, String[] itemkeywords) {

        this.itemTitle = itemTitle;
        Collections.addAll(itemKeywords, itemkeywords);
    }

    public void setMembers(String... members)
    {
    }

    public TreeSet<String> getItemKeywords() { return itemKeywords; }


    @Override
    public String toString() {
        return String.format("title:    %s\nkeywords: %s\n", itemTitle,
                Arrays.toString(itemKeywords.toArray()).replace('[', ' ').replace(']', ' ').trim());
    }
}

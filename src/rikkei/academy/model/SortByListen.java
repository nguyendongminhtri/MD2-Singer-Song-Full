package rikkei.academy.model;

import java.util.Comparator;

public class SortByListen implements Comparator<Song> {

    @Override
    public int compare(Song o1, Song o2) {
        return o2.getListen() - o1.getListen();
    }
}

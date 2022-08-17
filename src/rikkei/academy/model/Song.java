package rikkei.academy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Song implements Serializable, Comparable<Song> {
    private int id;
    private String name;
    private int listen;
    private int like;
    private List<Singer> singerList = new ArrayList<>();

    public Song() {
    }

    public Song(int id, String name, int listen, int like, List<Singer> singerList) {
        this.id = id;
        this.name = name;
        this.listen = listen;
        this.like = like;
        this.singerList = singerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getListen() {
        return listen;
    }

    public void setListen(int listen) {
        this.listen = listen;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public List<Singer> getSingerList() {
        return singerList;
    }

    public void setSingerList(List<Singer> singerList) {
        this.singerList = singerList;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listen=" + listen +
                ", like=" + like +
                ", singerList=" + singerList +
                '}';
    }

    @Override
    public int compareTo(Song o) {
        return o.getLike()-this.getLike();
    }

}

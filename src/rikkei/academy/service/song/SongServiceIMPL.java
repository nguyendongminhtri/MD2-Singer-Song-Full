package rikkei.academy.service.song;

import rikkei.academy.config.Config;
import rikkei.academy.model.Song;
import rikkei.academy.model.SortByListen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SongServiceIMPL implements ISongService {
    public static final String PATH_SONG = "C:\\Users\\Admin\\Desktop\\CLONE\\MD2-Singer-Song-master\\src\\rikkei\\academy\\database\\song.txt";
    public static List<Song> songList = new Config<Song>().readFile(PATH_SONG);
    @Override
    public List<Song> findAll() {
        new Config<Song>().writeFile(PATH_SONG, songList);
        return songList;
    }

    @Override
    public void save(Song song) {
        songList.add(song);
    }

    @Override
    public Song findByID(int id) {
        for (int i = 0; i < songList.size(); i++) {
            if(id==songList.get(i).getId()){
                return songList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Song> sortByLike() {
        List<Song> listLike = new ArrayList<>();
        for (int i = 0; i < songList.size(); i++) {
            listLike.add(songList.get(i));
        }
        Collections.sort(listLike);
        System.out.println();
        List<Song> topLike = new ArrayList<>();
        for (int i = 0;  i< 5; i++) {
            topLike.add(listLike.get(i));


        }
        System.out.println(topLike);
        return  topLike;
    }

    @Override
    public List<Song> sortByListen() {
        List<Song> listen= new ArrayList<>();
        for (int i = 0; i < songList.size(); i++) {
            listen.add(songList.get(i));
        }
        SortByListen sortByListen = new SortByListen();
        Collections.sort(listen,sortByListen);
        List<Song> topListen = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            topListen.add(listen.get(i));
        }
        return topListen;
    }

}

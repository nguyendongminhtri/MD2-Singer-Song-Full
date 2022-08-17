package rikkei.academy.view.singer;

import org.omg.CORBA.portable.ValueOutputStream;
import rikkei.academy.config.Config;
import rikkei.academy.controller.SingerController;
import rikkei.academy.controller.SongController;
import rikkei.academy.model.Singer;
import rikkei.academy.model.Song;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;

public class ViewSong {
    private SongController songController = new SongController();
    private List<Song> songList = songController.showListSong();
    private SingerController singerController = new SingerController();
    List<Singer> singerList = singerController.showListSinger();

    public ViewSong() {
        System.out.println("-----------SONG MANAGE------------");
        System.out.println("1. Create Song");
        System.out.println("2. Show List Song");
        System.out.println("3. Detail Song");
        System.out.println("4. Top like song");
        System.out.println("5. Top listen Song");
//        System.out.println("6. Sort Singer");
        int chooseSong = Config.scanner().nextInt();
        switch (chooseSong) {
            case 1:
                formCreateSong();
                break;
            case 2:
                formShowListSong();
                break;
            case 3:
                formDetailSong();
                break;
            case 4:
                formTopLikeSong();
                break;
            case 5:
                formTopListen();
                break;
//            case 6:
//                formShowListSingerAfterSort();
//                break;
        }
    }

    private void formCreateSong() {
        int idSong;
        if (songList.size() == 0) {
            idSong = 1;
        } else {
            idSong = songList.get(songList.size() - 1).getId() + 1;
        }
        System.out.println("Enter the name Song: ");
        String name = Config.scanner().nextLine();
        List<Singer> listSelect = new ArrayList<>();
        listSelect = selectSinger(listSelect);
        Song song = new Song(idSong, name, 0, 0, listSelect);
        songController.createSong(song);
        songController.showListSong();
        System.out.println("CREATE SONG SUCCESS!");
        showListSong();

    }

    private void formShowListSong() {
        showListSong();
        System.out.println("Enter any key to continue - Enter Quit to exit select Singer");
        String exitSelect = Config.scanner().nextLine();
        if (exitSelect.equalsIgnoreCase("quit")) {
            new ViewSong();
        }
    }

    private void showListSong() {
        System.out.println("====ID========NAME=======LISTEN======LIKE=====LIST SINGER");
        for (int i = 0; i < songList.size(); i++) {
            System.out.println("====" + songList.get(i).getId() + "====" + songList.get(i).getName() + "=====" + songList.get(i).getListen()
                    + "====" + songList.get(i).getLike() + "====" + songList.get(i).getSingerList());
        }
    }

    private List<Singer> selectSinger(List<Singer> listSelect) {

        System.out.println("=====ID=====NAME=====");
        for (int i = 0; i < singerList.size(); i++) {
            System.out.println("====" + singerList.get(i).getId() + "====" + singerList.get(i).getName());
        }
        System.out.println("Enter the id of Singer to select: ");
        int idSinger = Config.scanner().nextInt();
        Singer singer = singerController.detailSinger(idSinger);
        listSelect.add(singer);
        System.out.println("Enter any key to continue - Enter Quit to exit select Singer");
        String exitSelect = Config.scanner().nextLine();
        if (exitSelect.equalsIgnoreCase("quit")) {
            return listSelect;
        } else {
            selectSinger(listSelect);
        }
        return listSelect;
    }
    private void formDetailSong(){
        showListSong();
        System.out.println("Enter the id of Song");
        int idSong = Config.scanner().nextInt();
        if(songController.detailSong(idSong)==null){
            System.out.println("The song doesn't exist!");
        } else {
            Song song = songController.detailSong(idSong);
            song.setListen(song.getListen()+1);
            songController.showListSong();
            System.out.println("====ID========NAME=======LISTEN======LIKE=====LIST SINGER");
            System.out.println(song.getId()+"====="+song.getName()+"====="+song.getListen()+"====="+song.getLike()+"=======");
            for (int i = 0; i < song.getSingerList().size(); i++) {
                System.out.print(song.getSingerList().get(i).getName()+" , ");
            }
            System.out.println("Please LIKE ME? Enter LIKE");
            String like = Config.scanner().nextLine();
            if(like.equalsIgnoreCase("like")){
                song.setLike(song.getLike()+1);
                songController.showListSong();
            }
            System.out.println(" Enter Quit to come back Song Manage: ");
            String exitSelect = Config.scanner().nextLine();
            if (exitSelect.equalsIgnoreCase("quit")) {
                new ViewSong();
            }
        }
    }
    private void formTopLikeSong(){
        songController.topLike();

    }
    private  void formTopListen(){
        for (int i = 0; i < songController.topListen().size(); i++) {
            System.out.println(songController.topListen().get(i).getListen() );
        }
    }
}

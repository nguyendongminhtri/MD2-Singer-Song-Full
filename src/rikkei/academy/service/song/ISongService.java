package rikkei.academy.service.song;

import rikkei.academy.model.Song;
import rikkei.academy.service.IGenerateService;

import java.util.List;

public interface ISongService extends IGenerateService<Song> {
    List<Song> sortByLike();
    List<Song> sortByListen();
}

package rikkei.academy.service.singer;

import rikkei.academy.model.Singer;
import rikkei.academy.service.IGenerateService;

import java.util.List;

public interface ISingerService extends IGenerateService<Singer> {
    List<Singer> sortByNameAndByAge();

}

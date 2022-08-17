package rikkei.academy.controller;

import rikkei.academy.model.Singer;
import rikkei.academy.service.singer.ISingerService;
import rikkei.academy.service.singer.SingerServiceIMPL;

import java.util.List;

public class SingerController {
    ISingerService singerService = new SingerServiceIMPL();
    public List<Singer> showListSinger(){
        return singerService.findAll();
    }
    public void createSinger(Singer singer){
        singerService.save(singer);
    }
    public Singer detailSinger(int id){
        return singerService.findByID(id);
    }
    public void updateSinger(int id, Singer newSinger){
        Singer singer1 = singerService.findByID(id);
        singer1.setName(newSinger.getName());
        singer1.setAge(newSinger.getAge());
    }
    public void deleteSinger(int id){
        singerService.deleteById(id);
    }
    public List<Singer> sortByNameAndAge(){
       return singerService.sortByNameAndByAge();
    }
}

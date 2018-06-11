package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.objcetAdvices.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService{
    @Autowired
    private AlbumDao albumDao;

    @Override
    public List<Album> queryAllAlbum() {
        List<Album> albums = albumDao.queryAllAlbum();
        return albums;
    }

    @Override
    public List<Album> queryAlbumByTime() {
        List<Album> albums = albumDao.queryAlbumByTime();
        return albums;
    }

    @Override
    public Album queryAlbumById(String id) {
        Album album = albumDao.queryAlbumById(id);
        return album;
    }

    @Override
    @LogAnnotation(name="添加音频目录")
    public void insertAlbum(Album album) {
        albumDao.insertAlbum(album);
    }

    @Override
    @LogAnnotation(name="删除音频目录")
    public void deleteAlbum(String id) {
        albumDao.deleteAlbum(id);
    }

    @Override
    @LogAnnotation(name="修改音频目录")
    public void updateAlbum(Album album) {
        albumDao.updateAlbum(album);
    }

}

package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumDao {
    List<Album> queryAllAlbum();
    List<Album> queryAlbumByTime();
    Album queryAlbumById(String id);
    void insertAlbum(Album album);
    void deleteAlbum(String id);
    void updateAlbum(Album album);
}

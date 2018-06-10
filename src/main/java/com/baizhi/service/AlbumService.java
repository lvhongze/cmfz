package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> queryAllAlbum();
    List<Album> queryAlbumByTime();
    Album queryAlbumById(String id);
    void insertAlbum(Album album);
    void deleteAlbum(String id);
    void updateAlbum(Album album);
}

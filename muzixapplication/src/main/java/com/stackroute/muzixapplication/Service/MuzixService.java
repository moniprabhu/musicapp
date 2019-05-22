package com.stackroute.muzixapplication.Service;

import com.stackroute.muzixapplication.domain.Album;
//import com.stackroute.muzixapplication.exception.TrackAlreadyExistsException;

import java.util.List;

public interface MuzixService {

        public Album saveAlbum(Album album );

        public List<Album> getAllAlbums();
    }



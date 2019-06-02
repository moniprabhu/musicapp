package com.stackroute.muzixapplication.service;

import com.stackroute.muzixapplication.domain.Album;
import com.stackroute.muzixapplication.exception.IdNotFoundException;
import com.stackroute.muzixapplication.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapplication.exception.TrackNotFoundException;
//import com.stackroute.muzixapplication.exception.TrackAlreadyExistsException;

import java.util.List;

public interface MuzixService {

        public Album saveAlbum(Album album )throws TrackAlreadyExistsException;
        public Album putUpdateTrack(Album album) throws IdNotFoundException;
        public boolean deleteTrack(int trackid)throws TrackNotFoundException;


        public List<Album> getAllAlbums();

//   public List<Album> getByName(String trackname) throws TrackNotFoundException;
}



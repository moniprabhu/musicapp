package com.stackroute.muzixapplication.Service;

import com.stackroute.muzixapplication.Respository.MuzixRepository;
import com.stackroute.muzixapplication.domain.Album;
//import com.stackroute.muzixapplication.exception.TrackAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MuzixServiceImpl implements MuzixService {
     MuzixRepository muzixRepository;
    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository){

        this.muzixRepository=muzixRepository;
    }
    @Override
    public Album saveAlbum(Album album) {
        Album savedAlbum=muzixRepository.save(album);
//        if(muzixRepository.existsById(album.getTrackid()))
//        {
//            throw new TrackAlreadyExistsException("album Already Exists");
//        }
//        Album savedAlbum=muzixRepository.save(album);
//        if(savedAlbum == null)
//        {
//            throw new TrackAlreadyExistsException("album Already Exists");
//        }

        return savedAlbum;
    }

    @Override
    public List<Album> getAllAlbums() {
        return muzixRepository.findAll();
    }
}


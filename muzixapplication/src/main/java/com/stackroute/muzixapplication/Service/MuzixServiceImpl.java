package com.stackroute.muzixapplication.Service;

import com.stackroute.muzixapplication.Respository.MuzixRepository;
import com.stackroute.muzixapplication.domain.Album;
import com.stackroute.muzixapplication.exception.IdNotFoundException;
import com.stackroute.muzixapplication.exception.TrackAlreadyExistsException;
//import com.stackroute.muzixapplication.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapplication.exception.TrackNotFoundException;
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
    public Album saveAlbum(Album album) throws TrackAlreadyExistsException {

        if(muzixRepository.existsById(album.getTrackid()))
        {
            throw new TrackAlreadyExistsException("album Already Exists");
        }
        Album savedAlbum=muzixRepository.save(album);
        if(savedAlbum == null)
        {
            throw new TrackAlreadyExistsException("album Already Exists");
        }

        return savedAlbum;
    }
    @Override
    public List<Album> getAllAlbums() {
        return muzixRepository.findAll();
    }
    @Override
    public Album updateTrack(Album album) throws IdNotFoundException {
        if(muzixRepository.existsById(album.getTrackid()))
        {
            throw new IdNotFoundException("Track id already exist");
        }
        Album updateTrack=muzixRepository.save(album);
        return updateTrack;
    }
    @Override
    public boolean deleteTrack(int trackid) throws TrackNotFoundException {
    boolean status=false;
      if(muzixRepository.existsById(trackid))
    {
        muzixRepository.deleteById(trackid);
        status=true;
        return status;
    }
      else{
        throw new TrackNotFoundException("Track id not found");
    }


}
}

package com.stackroute.muzixapplication.service;

import com.stackroute.muzixapplication.respository.MuzixRepository;
import com.stackroute.muzixapplication.domain.Album;
import com.stackroute.muzixapplication.exception.TrackAlreadyExistsException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class MuzixServiceImplTest {
    private Album album;

    //Create a mock for UserRepository
    @Mock
    private MuzixRepository muzixRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private MuzixServiceImpl muzixService;
    List<Album> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        album = new Album();

        album.setTrackid(101);
        album.setTrackname("believer");
        album.setTrackartist("john");
        album.setGenre("rock");
        list = new ArrayList<>();
        list.add(album);


    }

    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistsException {

        when(muzixRepository.save((Album) any())).thenReturn(album);
        Album savedAlbum = muzixService.saveAlbum(album);
        Assert.assertEquals(album,savedAlbum);

        //verify here verifies that userRepository save method is only called once
        verify(muzixRepository,times(1)).save(album);

    }

    @Test(expected = TrackAlreadyExistsException.class)
    public void saveTrackTestFailure() throws TrackAlreadyExistsException {
        when(muzixRepository.save((Album) any())).thenReturn(null);
        Album savedAlbum = muzixService.saveAlbum(album);
        System.out.println("savedUser" + savedAlbum);
        Assert.assertEquals(album,savedAlbum);



    }

    @Test
    public void getAllUser(){

        muzixRepository.save(album);
        //stubbing the mock to return specific data
        when(muzixRepository.findAll()).thenReturn(list);
        List<Album> userlist = muzixService.getAllAlbums();
        Assert.assertEquals(list,userlist);
    }




}
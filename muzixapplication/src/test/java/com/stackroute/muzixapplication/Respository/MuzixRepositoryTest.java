package com.stackroute.muzixapplication.Respository;

import com.stackroute.muzixapplication.domain.Album;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MuzixRepositoryTest {

    @Autowired
    private MuzixRepository muzixRepository;
    private Album album;

    @Before
    public void setUp() {
        album = new Album();
        album.setTrackid(101);
        album.setTrackartist("John");
        album.setTrackname("believer");
        album.setGenre("rock");

    }

    @After
    public void tearDown() {

        muzixRepository.deleteAll();
    }


    @Test
    public void testSaveTrack() {
        muzixRepository.save(album);
        Album fetchAlbum = muzixRepository.findById(album.getTrackid()).get();
        Assert.assertEquals(101, fetchAlbum.getTrackid());

    }

    @Test
    public void testSaveTrackFailure() {
        Album testTrack = new Album(101, "believer", "john", "rock");
        muzixRepository.save(album);
        Album fetchTrack = muzixRepository.findById(album.getTrackid()).get();
        Assert.assertNotSame(testTrack, album);
    }

    @Test
    public void testGetAllTrack() {
        Album u = new Album(102, "kanne", "ravi", "rap");
        Album u1 = new Album(103, "orassadha",  "marvin", "rock");
        muzixRepository.save(u);
        muzixRepository.save(u1);

        List<Album> list = muzixRepository.findAll();
        Assert.assertEquals("John", list.get(0).getTrackname());


    }
}
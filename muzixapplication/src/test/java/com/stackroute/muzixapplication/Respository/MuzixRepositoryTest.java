package com.stackroute.muzixapplication.Respository;

import com.stackroute.muzixapplication.domain.Album;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataMongoTest

public class MuzixRepositoryTest {

    @Autowired
    private MuzixRepository muzixRepository;
    private Album album;

    @Before
    public void setUp()
    {
        album = new Album();
        album.setTrackid(101);
        album.setTrackname("cheaptrills");
        album.setTrackartist("sia");
        album.setGenre("rock");

    }

    @After
    public void tearDown(){

        muzixRepository.deleteAll();
    }


    @Test
    public void testSaveTrack(){
        muzixRepository.save(album);
        Album fetchAlbum = muzixRepository.findById(album.getTrackid()).get();
        Assert.assertEquals(101,fetchAlbum.getTrackid());

    }

    @Test
    public void testSaveTrackFailure(){
        Album testTrack = new Album(104,"cheaptrills","sia","rock");
        muzixRepository.save(album);
        Album fetchAlbum = muzixRepository.findById(album.getTrackid()).get();
        Assert.assertNotSame(testTrack,album);
    }

    @Test
    public void testGetAllTrack(){
        Album u = new Album(105,"cheaptrills","sia","rock");
        Album u1 = new Album(106,"neeyum nanum","nyan", "rock");
        muzixRepository.save(u);
        muzixRepository.save(u1);

        List<Album> list = muzixRepository.findAll();
        Assert.assertEquals("neeyum nanum",list.get(0).getTrackname());




    }
}
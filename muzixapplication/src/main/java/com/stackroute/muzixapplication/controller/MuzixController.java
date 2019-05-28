package com.stackroute.muzixapplication.controller;

import com.stackroute.muzixapplication.Service.MuzixService;
import com.stackroute.muzixapplication.domain.Album;
import com.stackroute.muzixapplication.exception.IdNotFoundException;
import com.stackroute.muzixapplication.exception.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v2")

public class MuzixController {

        MuzixService muzixService;
        public  MuzixController(MuzixService muzixService){

            this.muzixService=muzixService;
        }
        @PostMapping("album")
        public ResponseEntity<?>saveUser(@RequestBody Album album){
            ResponseEntity responseEntity;
            try{
                muzixService.saveAlbum(album);
                responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);

            }catch (Exception ex){
                responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);


            }
            return responseEntity;
        }




    @PutMapping("/album")
    public ResponseEntity<?> putUpdateAlbum(@RequestBody Album album) throws IdNotFoundException {
        ResponseEntity responseEntity;
        try{
            muzixService.putUpdateTrack(album);
            responseEntity=new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);
        }
        catch(IdNotFoundException exception){
            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @DeleteMapping("/album/{id}")   public ResponseEntity<?> deleteTrack(@PathVariable("id") int trackid) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;
        try {
            muzixService.deleteTrack(trackid);
            responseEntity = new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
        }
        catch(TrackNotFoundException exception){
            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
        }
        //catch global execption
        return responseEntity;
    }
        @GetMapping("album")
        public ResponseEntity<?>getAllAlbums(){
            return  new ResponseEntity<List<Album>>(muzixService.getAllAlbums(),HttpStatus.OK);
        }

//    @GetMapping("/album/{trackname}")
//    public ResponseEntity<List<Album>> getByName (@PathVariable String trackname) {
//        ResponseEntity responseEntity;
//        try {
//
//            return new ResponseEntity<List<Album>>( muzixService.getByName(trackname) , HttpStatus.OK);
//        } catch (Exception ex) {
//            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//        }
//        return responseEntity;
//    }



    }

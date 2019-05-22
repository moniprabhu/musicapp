package com.stackroute.muzixapplication.Controller;

import com.stackroute.muzixapplication.Service.MuzixService;
import com.stackroute.muzixapplication.domain.Album;
//import com.stackroute.muzixapplication.exception.TrackAlreadyExistsException;
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
        @GetMapping("album")
        public ResponseEntity<?>getAllAlbums(){
            return  new ResponseEntity<List<Album>>(muzixService.getAllAlbums(),HttpStatus.OK);
        }





    }

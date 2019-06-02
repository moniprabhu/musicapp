package com.stackroute.muzixapplication.seeder;

//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//@Component
//@PropertySource("classpath:application.properties")
//public class SeedData implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {
//
//    @Autowired
//    MuzixService muzixService;
//
//    public SeedData(MuzixService muzixService) {
//        this.muzixService = muzixService;
//    }
//
//    public MuzixService getMuzixService() {
//        return muzixService;
//    }
//
//    public void setMuzixService(MuzixService muzixService) {
//        this.muzixService = muzixService;
//    }
//    @Value("${trackid1}")
//    int trackid1;
//
//    @Value("${trackname1}")
//    String trackname1;
//
//    @Value("${trackartist1}")
//    String trackartist1;
//
//    @Value("${genre1}")
//    String genre1;
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        Album album = new Album(trackid1, trackname1, trackartist1, genre1);
//        try {
//            muzixService.saveAlbum(album);
//        } catch (TrackAlreadyExistsException e) {
//            e.printStackTrace();
//        }
//    }
//    @Value("${trackid}")
//    int trackid;
//    @Value("${trackname}")
//    String trackname;
//
//    @Value("${trackartist}")
//    String trackartist;
//
//    @Value("${genre}")
//    String genre;
//
//    @Override
//    public void run(String... args) throws Exception {
//        Album album = new Album(trackid, trackname, trackartist, genre);
//        try {
//            muzixService.saveAlbum(album);
//        } catch (TrackAlreadyExistsException e) {
//            e.printStackTrace();
//        }
//    }
//}
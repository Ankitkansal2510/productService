package com.example.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication /*implements CommandLineRunner*/ {
  /*  @Autowired
    @Qualifier("st_mr")
    private MentorRepository mentorRepository;

    @Autowired
    @Qualifier("st_user")
    private UserRepository userRepository;

    @Autowired
    @Qualifier("tpc_mr")
    private MentorRepositoryTPC mentorRepositoryTPC;

    @Autowired
    @Qualifier("tpc_user")
    private UserRepositoryTPC userRepositoryTPC;
    @Autowired
    private MentorRepositoryJoined mentorRepositoryJoined;
    @Autowired
    private UserRepositoryJoined userRepositoryJoined;*/

//    public ProductServiceApplication(@Qualifier("st_mr") MentorRepository mentorRepository,
//                                     @Qualifier("st_user") UserRepository userRepository
//                                     ) {
//        this.mentorRepository = mentorRepository;
//        this.userRepository = userRepository;
//    }
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

  /*  @Override
    public void run(String... args) throws Exception {

        Mentor mentor=new Mentor();
        mentor.setName("Mentor1");
        mentor.setEmail("mentor1@gmail.com");
        mentor.setAverageRating(12.2);
        mentorRepository.save(mentor);

        User user=new User();
        user.setName("user1");
        user.setEmail("user1@gmail.com");
        userRepository.save(user);

        List<User> users=userRepository.findAll();

        for(User user1:users){
            System.out.println(user1);
        }



        ////below is for table per class


        MentorTPC mentortpc= new MentorTPC();
        mentortpc.setName("Mentortpc");
        mentortpc.setEmail("mentortpc@gmail.com");
        mentorRepositoryTPC.save(mentortpc);

        UserTPC usertpc= new UserTPC();
        usertpc.setEmail("usertpc@gmail.com");
        usertpc.setName("usertpc");
        userRepositoryTPC.save(usertpc);

        List<UserTPC> userTPCList=userRepositoryTPC.findAll();
        for(UserTPC userTPC:userTPCList){
            System.out.println(userTPC);
        }


        //below is for the joined






        UserJoined userjoined= new UserJoined();
        userjoined.setName("UserJoined");
        userjoined.setEmail("userjoined@gmail.com");
        userRepositoryJoined.save(userjoined);

        MentorJoined mentorjoined= new MentorJoined();
        mentorjoined.setName("mentor");
        mentorjoined.setEmail("mentor@gmail.com");
        mentorjoined.setAverageRating(12.22);
        mentorRepositoryJoined.save(mentorjoined);

        List<UserJoined> userJoinedList=userRepositoryJoined.findAll();
        for(UserJoined userJoined:userJoinedList){
            System.out.println(userJoined);
        }
    }*/
}

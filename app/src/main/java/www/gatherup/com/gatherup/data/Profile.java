package www.gatherup.com.gatherup.data;

/**
 * Created by Matthew Luce on 4/12/2017.
 */

public class Profile {
    private int mAge;
    private String mGender;
    private String mLocation;
    private String mJob;
    private String mBirthday;
    private String mAboutMe;
    private int mRating;

    public Profile(){}
    public Profile(int age,String gender,String location,String job,String birthday,String aboutMe,int rating){
        this.mAge = age;
        this.mGender = gender;
        this.mLocation = location;
        this.mJob = job;
        this.mBirthday = birthday;
        this.mAboutMe = aboutMe;
        this.mRating = rating;
    }
}

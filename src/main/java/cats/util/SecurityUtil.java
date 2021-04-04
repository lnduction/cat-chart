package cats.util;

import cats.entity.Profile;

public class SecurityUtil {

    private static Profile profile = new Profile((long)-1);

    public static long getCurrentProfileId(){
        return profile.getId();
    }

    public static void setCurrentProfile(Profile profile) {
        SecurityUtil.profile = profile;
    }

    public static String getCurrentProfileName() {return profile.getName();}

    public static Profile getCurrentProfile() {return SecurityUtil.profile;}

}

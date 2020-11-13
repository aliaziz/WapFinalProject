package controller;

import dao.UserDataAccessObject;
import model.User;
import model.UserStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserDataAccessObjectTest {

    @Test
    void saveUser() {
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        userDataAccessObject.saveUser(UserDataAccessObjectTest.getUser());
        User tempUser = userDataAccessObject.getUser("aku");
        Assertions.assertEquals(tempUser.getZipCode(), UserDataAccessObjectTest.getUser().getZipCode());
    }

    /**
     * Test get user is a static method to be used in tests for testing a dummy user.
     * @return
     */
    public static User getUser() {
        return new User("ali@ali.com",
                "aku",
                "",
                "",
                "ug",
                "",
                "",
                "",
                UserStatus.ACTIVE,
                52557);
    }
}
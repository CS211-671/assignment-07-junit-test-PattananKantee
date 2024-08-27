package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user1", "1234");
        userList.addUser("user2", "5678");
        userList.addUser("user3", "7890");

        // TODO: find one of them
        User user = userList.findUserByUsername("user1");

        // TODO: assert that UserList found User
        String expected = "user1";
        String actual = user.getUsername();
        assertEquals(expected, actual);
        // String expected = "<one of username>";
        // String actual = user.getUsername();
        // assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user1", "1234");
        userList.addUser("user2", "5678");
        userList.addUser("user3", "7890");

        // TODO: change password of one user
        boolean actual = userList.changePassword("user1", "1234", "1111");

        // TODO: assert that user can change password
        assertTrue(actual);
        // assertTrue(actual);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        User expect_user = new User("user1", "1234");
        UserList userList = new UserList();
        userList.addUser("user1", "1234");
        userList.addUser("user2", "5678");
        userList.addUser("user3", "7890");

        // TODO: call login() with correct username and password
        User user = userList.login("user1", "1234");

        // TODO: assert that User object is found
        assertNotNull(user);
        // assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user1", "1234");
        userList.addUser("user2", "5678");
        userList.addUser("user3", "7890");


        // TODO: call login() with incorrect username or incorrect password
        User actual = userList.login("user1", "1234");

        // TODO: assert that the method return null
        assertNull(actual);
        // assertNull(actual);
    }

}
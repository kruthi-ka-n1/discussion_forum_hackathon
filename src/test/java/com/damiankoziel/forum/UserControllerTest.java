package com.damiankoziel.forum;

import com.damiankoziel.forum.controller.UserController;
import com.damiankoziel.forum.model.User;
import com.damiankoziel.forum.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private User user;

    @Mock
    private UserService userService;

    private UserController userController;

    @Test
    public void shouldCreateUserTest() {
        user = new User();
        userController = new UserController(userService);
        userController.signUpUser(user);

        verify(userService).signUp(user);
    }

    @Test
    public void shouldGetAllUsersTest() {
        user = new User();
        User user2 = new User();
        userController = new UserController(userService);
        userController.signUpUser(user);
        userController.signUpUser(user2);
        userController.getAllUsers();

        verify(userService).getAll();
    }

    @Test
    public void shouldGetUserByIdTest() {
        user = new User();
        userController = new UserController(userService);
        userController.signUpUser(user);

        userController.getUserById(1L);
        verify(userService).getById(1L);
    }
}

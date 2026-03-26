package com.example.e_RH.user.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.e_RH.user.entity.User;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldGetAllUsers() {
        List<User> users = userRepository.findAll();

        assertEquals(2, users.size());
    }
    
    @Test
    void testFindByEmail() {
        Optional<User> user = userRepository.findByEmail("rakotovao@yahoo.fr");

        assertTrue(user.isPresent());
        assertEquals("rakotovao@yahoo.fr", user.get().getEmail());
    }
}

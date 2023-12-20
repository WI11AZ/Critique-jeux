package be.heh.application.domain.service;

import be.heh.application.domain.model.User;
import be.heh.application.port.out.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    public void testCreateUser() {
        // Crée un utilisateur de test
        User newUser = new User(1, "testuser",  "password");

        // Configure le comportement du UserRepository mock
        when(userRepository.createUser(any(User.class))).thenReturn(newUser);

        // Appelle la méthode de service
        User createdUser = userService.createUser("testuser",  "password");

        // Vérifie que la méthode UserRepository.createUser a été appelée avec les bons paramètres
        verify(userRepository).createUser(any(User.class));

        // Verifie que l'utilisateur créé correspond à celui retourné par le mock
        assertEquals(newUser, createdUser);
    }

    @Test
    public void testGetUserById() {
        // Crée un utilisateur de test
        User testUser = new User(1, "testuser",  "password");

        // Configure le comportement du UserRepository mock
        when(userRepository.getUserById(1)).thenReturn(testUser);

        // Appelle la méthode de service
        User retrievedUser = userService.getUserById(1);

        // Vérifie que la méthode UserRepository.getUserById a été appelée avec le bon paramètre
        verify(userRepository).getUserById(1);

        // Verifie que l'utilisateur récupéré correspond à celui retourné par le mock
        assertEquals(testUser, retrievedUser);
    }

    @Test
    public void testGetUserByUsername() {
        // Crée un utilisateur de test
        User testUser = new User(1, "testuser",  "password");

        // Configure le comportement du UserRepository mock
        when(userRepository.getUserByUsername("testuser")).thenReturn(testUser);

        // Appelle la méthode de service
        User retrievedUser = userService.getUserByUsername("testuser");

        // Vérifie que la méthode UserRepository.getUserByUsername a été appelée avec le bon paramètre
        verify(userRepository).getUserByUsername("testuser");

        // Verifie que l'utilisateur récupéré correspond à celui retourné par le mock
        assertEquals(testUser, retrievedUser);
    }

    @Test
    public void testDeleteUser() {
        // Appelle la méthode de service pour supprimer un utilisateur
        userService.deleteUser(1);

        // Vérifie que la méthode UserRepository.deleteUser a été appelée avec le bon paramètre
        verify(userRepository).deleteUser(1);
    }

    @Test
    public void testAuthenticateUser() {
        // Crée un utilisateur de test
        User testUser = new User(1, "testuser",  "password");

        // Configure le comportement du UserRepository mock
        when(userRepository.getUserByUsername("testuser")).thenReturn(testUser);

        // Authentifie un utilisateur avec le bon nom d'utilisateur et mot de passe
        boolean authenticated = userService.authenticateUser("testuser", "password");

        // Vérifie que l'utilisateur est authentifié avec succès
        assertTrue(authenticated);
    }

    @Test
    public void testAuthenticateUserInvalidPassword() {
        // Crée un utilisateur de test
        User testUser = new User(1, "testuser",  "password");

        // Configure le comportement du UserRepository mock
        when(userRepository.getUserByUsername("testuser")).thenReturn(testUser);

        // Authentifie un utilisateur avec un mot de passe incorrect
        boolean authenticated = userService.authenticateUser("testuser", "wrongpassword");

        // Vérifie que l'utilisateur n'est pas authentifié
        assertFalse(authenticated);
    }

    @Test
    public void testAuthenticateUserInvalidUsername() {
        // Configure le comportement du UserRepository mock pour retourner null (utilisateur non trouvé)
        when(userRepository.getUserByUsername("nonexistentuser")).thenReturn(null);

        // Authentifie un utilisateur avec un nom d'utilisateur inexistant
        boolean authenticated = userService.authenticateUser("nonexistentuser", "password");

        // Vérifie que l'utilisateur n'est pas authentifié
        assertFalse(authenticated);
    }
}

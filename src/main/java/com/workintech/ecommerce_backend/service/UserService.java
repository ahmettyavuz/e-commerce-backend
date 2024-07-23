package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.entity.User;
import com.workintech.ecommerce_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    User findByEmail(String email){
        return  userRepository.findByEmail(email).orElseThrow(null);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByEmail(username);
    }


    public void banUser(Long userId, String reason) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Kullanıcıyı banlama işlemi
        user.setAccountLocked(true); // Kullanıcıyı kilitle
        user.setEnabled(false); // Kullanıcıyı devre dışı bırak
        // Ban sebebini kaydetmek için ek bir alan varsa, burada güncelleyebilirsiniz.

        userRepository.save(user); // Güncellenmiş kullanıcıyı kaydet
    }
}

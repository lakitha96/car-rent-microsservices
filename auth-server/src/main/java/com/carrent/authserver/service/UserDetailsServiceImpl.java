package com.carrent.authserver.service;

import com.carrent.authserver.model.AuthUserDetail;
import com.carrent.authserver.model.User;
import com.carrent.authserver.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Lakitha Prabudh on 7/7/20
 */
@Service("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> byUserName = userDetailRepository.findByUsername(userName);

        byUserName.orElseThrow(() -> new UsernameNotFoundException("username or password incorrect."));
        AuthUserDetail userDetail = new AuthUserDetail(byUserName.get());
        new AccountStatusUserDetailsChecker().check(userDetail);
        return userDetail;
    }
}

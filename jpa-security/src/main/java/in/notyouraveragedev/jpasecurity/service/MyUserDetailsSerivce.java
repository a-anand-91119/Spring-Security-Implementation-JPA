package in.notyouraveragedev.jpasecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.notyouraveragedev.jpasecurity.models.MyUserDetails;
import in.notyouraveragedev.jpasecurity.models.User;
import in.notyouraveragedev.jpasecurity.repository.MyRepository;

@Service
public class MyUserDetailsSerivce implements UserDetailsService{

	@Autowired
	private MyRepository myRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		User user = myRepository.findByUsername(username);
		return new MyUserDetails(user);
	}

}

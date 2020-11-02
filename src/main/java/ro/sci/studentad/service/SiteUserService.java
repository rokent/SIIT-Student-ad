package ro.sci.studentad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ro.sci.studentad.dao.SiteUserDAO;
import ro.sci.studentad.domain.SiteUser;

@Service
public class SiteUserService implements UserDetailsService {

	@Autowired
	private SiteUserDAO siteUserDAO;

	@Autowired
	PasswordEncoder passwordEncoder;

	public boolean saveUser(SiteUser siteUser) {
		if (siteUserDAO.findByEmail(siteUser.getEmail()) == null) {

			siteUser.setRole("ROLE_USER");
			siteUser.setPassword(passwordEncoder.encode(siteUser.getPassword()));
			siteUserDAO.save(siteUser);
			return true;
		}
		return false;
	}

	public SiteUser getUserById(Long id) {
		return siteUserDAO.findOne(id);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		SiteUser user = siteUserDAO.findByEmail(email);

		if (user == null) {
			return null;
		}

		List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());

		String password = user.getPassword();

		return new User(email, password, auth);
	}

	public Long numberOfRegistredUsers() {
		return siteUserDAO.count();
	}
}

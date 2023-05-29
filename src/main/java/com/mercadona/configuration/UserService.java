package com.mercadona.configuration;

public class UserService implements UserDetailsService {
    
        @Autowired
        private UserRepository userRepository;
    
        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            User user = userRepository.findByEmail(email);
    
            if(user == null){
                throw new UsernameNotFoundException("User not found");
            }
    
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities(user));
        }
    
        private static Collection<? extends GrantedAuthority> getAuthorities(User user){
            String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
            Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
            return authorities;
        }
}

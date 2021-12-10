package com.dew.mastertrick.security;


import com.dew.mastertrick.model.Users;
import com.dew.mastertrick.repositoires.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.persistence.EntityNotFoundException;
import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class JWTAuthorizationFilter extends OncePerRequestFilter {
    // OJO: NO @Autowired
    private UserRepository userRepository;

    /*******************************************************************************************
     * Se modifica el constructor para recibir el contexto porque por medidas de seguridad
     * los filtros se ejecutan en un contexto diferente a la aplicación principal
     * y se obtiene el repositorio de usuarios del contexto en vez de @Autowired
     */
    public JWTAuthorizationFilter(ApplicationContext applicationContext) {
        this.userRepository = applicationContext.getBean(UserRepository.class);
    }

    /******************************************************************************************/

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if(httpServletRequest.getHeader("Authorization")!=null) {
            if (!httpServletRequest.getHeader("Authorization").startsWith("Bearer ")) {
                SecurityContextHolder.clearContext();
            } else {
                String jwtToken = httpServletRequest.getHeader("Authorization").replace("Bearer ", "");
                try {
                    Claims claims = Jwts.parser().setSigningKey("chatarra".getBytes()).parseClaimsJws(jwtToken).getBody();
                    String username = claims.getSubject();
                    Users user = userRepository.findUserByNick(username).orElseThrow(EntityNotFoundException::new);
                    // Almacena el token en el usuario, no es obligatorio
                    if(user.getToken() == null || !user.getToken().equals(jwtToken)) throw new AuthenticationException();
                    //Hibernate.initialize(user.getRoles());
                    setUpSpringAuthentication(user);
                } catch (Exception e) {
                    SecurityContextHolder.clearContext();
                }
            }
        } else {
            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void setUpSpringAuthentication(Users user) {
        List<GrantedAuthority> authorities = new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(user, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(auth);
   }

}

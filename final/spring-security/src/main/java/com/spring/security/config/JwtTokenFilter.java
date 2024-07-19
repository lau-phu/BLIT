/*
 * package com.spring.security.config;
 * 
 * 
 * 
 * import java.io.IOException;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.web.authentication.
 * WebAuthenticationDetailsSource; import
 * org.springframework.stereotype.Component; import
 * org.springframework.web.filter.OncePerRequestFilter;
 * 
 * import com.spring.security.service.JwtServiceImpl; import
 * com.spring.security.service.UserServiceImpl;
 * 
 * import io.jsonwebtoken.ExpiredJwtException; import
 * jakarta.servlet.FilterChain; import jakarta.servlet.ServletException; import
 * jakarta.servlet.http.HttpServletRequest; import
 * jakarta.servlet.http.HttpServletResponse;
 * 
 * @Component public class JwtTokenFilter extends OncePerRequestFilter {
 * 
 * 
 * @Autowired private JwtServiceImpl jwtService;
 * 
 * @Autowired private UserServiceImpl userService;
 * 
 * private String userName = null; private String jwt = null;
 * 
 * @Override protected void doFilterInternal(HttpServletRequest request,
 * HttpServletResponse response, FilterChain filterChain) throws
 * ServletException, IOException { final String authorizationHeader =
 * request.getHeader("Authorization");
 * 
 * if(authorizationHeader != null && authorizationHeader.startsWith("Bearer "))
 * { jwt= authorizationHeader.substring(7); try{ userName =
 * jwtService.extractUserName(jwt); } catch (ExpiredJwtException e){
 * System.out.printf(e.getMessage());; }
 * 
 * }
 * 
 * if(userName != null && SecurityContextHolder.getContext().getAuthentication()
 * == null) { UserDetails userDetails =
 * userService.loadUserByUsername(userName); if(jwtService.validateToken(jwt,
 * userDetails)){
 * 
 * UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
 * UsernamePasswordAuthenticationToken(userDetails, null,
 * userDetails.getAuthorities() );
 * usernamePasswordAuthenticationToken.setDetails( new
 * WebAuthenticationDetailsSource().buildDetails(request) );
 * 
 * SecurityContextHolder.getContext().setAuthentication(
 * usernamePasswordAuthenticationToken); } }
 * 
 * filterChain.doFilter(request, response); } }
 */
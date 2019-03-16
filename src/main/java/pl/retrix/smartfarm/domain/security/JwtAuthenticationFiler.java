package pl.retrix.smartfarm.domain.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import pl.retrix.smartfarm.domain.accounts.User;
import pl.retrix.smartfarm.services.CustomUserDetailsService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

import static pl.retrix.smartfarm.domain.security.SecurityConstants.HEADER_STRING;
import static pl.retrix.smartfarm.domain.security.SecurityConstants.TOKEN_PREFIX;

//TODO: Przerobic to na nowo! QUITE HARD
public class JwtAuthenticationFiler extends OncePerRequestFilter {

    @Autowired
    private JWTTokenProvider tokenProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        try{
            String jwt = getJWTFromRequest(httpServletRequest);

            if(StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)){
                Long userId = tokenProvider.getUserIdFromJWT(jwt);
                User userDetails = customUserDetailsService.loadUserById(userId);

                Object object;
                Object object2;
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, Collections.emptyList());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }

        }catch (Exception e){
            logger.error("Could not set user authentication in security context");
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse); //IMPORTANT!!!
    }

    //Method which extract clear token
    private String getJWTFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader(HEADER_STRING); //wskazujemy skad ma pobrac token z odpowiedzi od JSON (uzytkownika); W postman dodajemy 'Authorization'

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(TOKEN_PREFIX)){ //Jesli pobrany token z JSON Request nie jest pusty i zaczyna sie od TOKEN_PREFIX...
            return bearerToken.substring(7,bearerToken.length());
        }
        return null;
    }
}

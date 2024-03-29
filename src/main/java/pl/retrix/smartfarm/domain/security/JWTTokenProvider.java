package pl.retrix.smartfarm.domain.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import pl.retrix.smartfarm.domain.accounts.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static pl.retrix.smartfarm.domain.security.SecurityConstants.EXPIRATION_TIME;
import static pl.retrix.smartfarm.domain.security.SecurityConstants.SECRET;

@Component //pozwala na dostep innym sekcjom aplikacji
public class JWTTokenProvider {

    //Generate the token
    public String generateToken(Authentication authentication){
        User user = (User)authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());

        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        String userId = Long.toString(user.getId());

        //Wskazujemy jakie informacje chcemy zawrzeć w tokenie
        Map<String,Object> claims = new HashMap<>();
        claims.put("id", (Long.toString(user.getId())));
        claims.put("username", user.getUsername());
        claims.put("fullName", user.getFullName());

        //Metoda generujaca token kiedy username i password zgadzaja sie, potrzebne do utworzenia sesji dla usera
        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET) //Podczas logowania bląd 500, podana zla zmienna 'ES512' zamiast 'HS512'
                .compact();
    }

    //Validate the token
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true; //IMPORTANT!
        }catch(SignatureException ex){
            System.out.println("Invalid JWT Signature");
        }catch(MalformedJwtException ex){
            System.out.println("Invalid JWT Token");
        }catch(ExpiredJwtException ex){
            System.out.println("Expired JWT Token");
        }catch (UnsupportedJwtException ex){
            System.out.println("Unsupported JWT Token");
        }catch(IllegalArgumentException ex){
            System.out.println("JWT claims string is empty");
        }
        return false;
    }

    //Get user Id from token
    public Long getUserIdFromJWT(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        String id = (String)claims.get("id");

        return Long.parseLong(id);
    }
}

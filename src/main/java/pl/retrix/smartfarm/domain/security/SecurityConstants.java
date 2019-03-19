package pl.retrix.smartfarm.domain.security;

public class SecurityConstants {

    public static final String SIGN_UP_URLS = "/api/users/**";
    public static final String H2_URL = "h2-console/**";
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String H2_CONSOLE_PATCH = "/h2-console/**";
    public static final long EXPIRATION_TIME = 300_000; //30_000 <- 30 sekund
}

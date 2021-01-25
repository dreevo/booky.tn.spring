package booky.tn.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest Request, HttpServletResponse Response,
                                    FilterChain filterChain) throws ServletException, IOException {

        Response.addHeader("Access-Control-Allow-Origin", "*");
        Response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, authorization");
        Response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");
        Response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,PATCH");
        if (Request.getMethod().equals("OPTIONS")) {
            Response.setStatus(HttpServletResponse.SC_OK);
        } else if (Request.getRequestURI().equals("/login")) {
            filterChain.doFilter(Request, Response);
            System.out.println("1 mcheee");
            return;

        } else {

            String jwt = Request.getHeader(SecureParam.HEADER_NAME);
            if (jwt == null || !jwt.startsWith(SecureParam.HEADER_PREFIX)) {
                filterChain.doFilter(Request, Response);
                System.out.println("2 mcheee" +jwt);
                return;
            }
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecureParam.SECRET)).build();
            DecodedJWT decodedJWT = verifier.verify(jwt.substring(SecureParam.HEADER_PREFIX.length()));
            System.out.println("3 mcheee");
            String email = decodedJWT.getSubject();
            List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            roles.forEach(r -> {
                (authorities).add(new SimpleGrantedAuthority(r));
            });

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(email, null, authorities);

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            filterChain.doFilter(Request, Response);

        }
    }
}

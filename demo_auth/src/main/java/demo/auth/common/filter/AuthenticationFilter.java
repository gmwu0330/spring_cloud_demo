package demo.auth.common.filter;

import demo.auth.common.property.InMemoryService;
import demo.auth.common.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    private static final String HEADER_AUTH = "Authorization";

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        // 已有Authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!Objects.isNull(authentication)) {
            filterChain.doFilter(request, response);
            return;
        }

        final String authHeader = request.getHeader(HEADER_AUTH);
        if (StringUtils.isBlank(authHeader) || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String accessToken = authHeader.replace("Bearer ", "");
        if (StringUtils.isBlank(accessToken)) {
            filterChain.doFilter(request, response);
            return;
        }

        final String username = JwtUtils.extractUsername(accessToken);
        if (StringUtils.isBlank(username)) {
            filterChain.doFilter(request, response);
            return;
        }

        // TODO 從Redis取
        UserDetails userDetails = InMemoryService.getUser(username);
        if (Objects.isNull(userDetails)) {
            filterChain.doFilter(request, response);
            return;
        }

        if (JwtUtils.validateToken(accessToken, userDetails)) {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
            );
            authToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        filterChain.doFilter(request, response);
    }
}

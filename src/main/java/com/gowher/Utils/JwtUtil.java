// package com.gowher.Utils;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;

// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;

// import javax.crypto.SecretKey;

// public class JwtUtil {
//     //private String secretKey = "GowherAhanger's_Secret_Key";
//     private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

//     // Generate JWT Token
//     public String generateToken(String username) {
//         Map<String, Object> claims = new HashMap<>();
//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(username)
//                 .setIssuedAt(new Date(System.currentTimeMillis()))
//                 .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
//                 .signWith(secretKey)
//                 .compact();
//     }

//     // // Validate Token
//     // public Boolean validateToken(String token, String username) {
//     //     final String extractedUsername = extractUsername(token);
//     //     return (extractedUsername.equals(username) && !isTokenExpired(token));
//     // }

//     public String extractUsername(String token) {
//         return extractClaim(token, Claims::getSubject);
//     }

//     public <T> T extractClaim(String token, java.util.function.Function<Claims, T> claimsResolver) {
//         final Claims claims = extractAllClaims(token);
//         return claimsResolver.apply(claims);
//     }

//     private Claims extractAllClaims(String token) {
//         return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//     }

//     // private Boolean isTokenExpired(String token) {
//     //     return extractExpiration(token).before(new Date());
//     // }

    // public Date extractExpiration(String token) {
    //     return extractClaim(token, Claims::getExpiration);
    // }
//}

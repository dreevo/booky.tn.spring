package tn.booky.corp.security;

public interface SecureParam {
	public static final String HEADER_NAME = "Authorization";
	public static final String SECRET = "jmaroua";
	public static final long EXPIRATION = 14400000;
	public static final String HEADER_PREFIX = "Bearer ";
}

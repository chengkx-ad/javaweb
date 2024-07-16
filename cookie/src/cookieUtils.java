import javax.servlet.http.Cookie;

public class cookieUtils {
    public static Cookie readCookieByName(String name, Cookie[] cookies){

        if (name == null || name.equals(" ") || cookies == null) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)){
                return cookie;
            }
        }
        return null;
    }
}

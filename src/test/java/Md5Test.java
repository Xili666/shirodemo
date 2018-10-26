import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class Md5Test {
    @Test
    public void test() {
        String s = new Md5Hash("123", "admin", 3).toString();
        System.out.println(s);
    }
}

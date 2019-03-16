import com.github.sys.dao.SecUserMapper;
import com.github.sys.model.SecUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by renhongqiang on 2019-03-16 20:52
 */
public class TestDao extends BasicTest {

    @Autowired
    private SecUserMapper secUserMapper;

    @Test
    public void testInsert() {
        SecUser user = new SecUser();
        user.setName("renrenren");
        user.setAge(27);
        user.setAddress("武汉市江夏区未来科技城");
        user.setSex(1);
        user.setBirth(LocalDateTime.parse("1992-07-24 11:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        user.setMail("renhongqiang1397@gmail.com");
        user.setPassword("1qaz");
        secUserMapper.insertSelective(user);

        System.out.println(user.getId());
    }
}

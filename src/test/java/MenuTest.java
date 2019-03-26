import com.alibaba.fastjson.JSON;
import com.github.sys.domain.menu.MenuTree;
import com.github.sys.service.SecMenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by renhongqiang on 2019-03-25 21:07
 */
public class MenuTest extends BasicTest {
    @Autowired
    private SecMenuService menuService;


    @Test
    public void testTree() {
        List<MenuTree> menuTrees = menuService.selectMenuTree(0);
        System.out.println(JSON.toJSONString(menuTrees));

    }
}

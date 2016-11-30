package myeh;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@Rollback
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
// 用于WebApp测试
@ContextConfiguration({
	"classpath*:config/context/applicationContext-AppConfig.xml",
	"classpath*:config/context/applicationContext-SpringSecurityConfig.xml",
	"classpath*:config/context/applicationContext-MvcConfig.xml" })
public class JUnit4ClassRunner {

}

package myeh;

import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.cyxd.myeh.web.controller.HelloMockAction;

// @TransactionConfiguration(defaultRollback = true)
/**
 * <p>
 * <li>ClassFullName: myeh.TestController
 * <li>ClassName: TestController
 * <li>CreateDateTime: 2016年11月29日 下午5:04:51
 *
 * <p>
 * Description: SpringTest 支持所有对SpringBean的直接注入并测试
 * <p>
 * 本类使用前提：mvc接口统一使用形参方式，而非全局变量方式
 * </p>
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see
 * @see
 *
 */
public class JUnitMock extends JUnit4ClassRunner {

    private final static Logger logger = LoggerFactory
	    .getLogger(JUnitMock.class);

    @Autowired
    private WebApplicationContext webAppContext;
    private ServletContext servletContext;
    // 模拟httprequest,httpresponse,httpsession
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private MockHttpSession session;

    // @Autowired
    // public RequestMappingHandlerAdapter handlerAdapter;

    // private MockMvc mockMvc;

    // 执行测试方法之前初始化模拟request,response
    @Before
    public void setUp() {
	servletContext = webAppContext.getServletContext();
	request = new MockHttpServletRequest(servletContext);
	request.setCharacterEncoding("UTF-8");
	// response = new MockHttpServletResponse();
	session = new MockHttpSession(servletContext, UUID.randomUUID()
		.toString());
	// this.mockMvc = webAppContextSetup(this.webAppContext).build();
    }

    @Autowired
    private HelloMockAction helloMockAction;

    /**
     * 测试用户登录
     */
    @Test
    public void testLogin() {
	try {
	    // request.setParameter("userName", "admin");
	    // request.setParameter("password", "m2tgqWhk");
	    // String userName = "test03";
	    // String password = "123456";

	    // String userName = "admin";
	    // String password = "m2tgqWhk";

	    // ModelAndView mav = handlerAdapter.handle(request, response,
	    // new HandlerMethod(homeController, "login"));
	    // logger.debug("mav --->" + mav);

	    // request.addPart(new part);

	    // session.setAttribute("users", new HelloMock(
	    // "421E46B184C2441AE050740A3F9D77B1", "王2"));
	    // 绑定session
	    // request.setSession(session);
	    // servletContext.setAttribute("leafMenu",
	    // ImmutableList.of(new Privilege("abc")));
	    // session.setAttribute("leafMenu", ImmutableList.of(new
	    // Privilege("abc")));

	    // String username = "王bb";

	    // assertEquals("login",
	    // helloMockAction.loginView("fail", new ModelMap()));

	    String sayReturns = helloMockAction.say();
	    // System.out.println("sayReturns->" + sayReturns);
	    logger.info(sayReturns);

	    List<String> say2Returns = helloMockAction.say("say2Returns");
	    // System.out.println("say2Returns->" + say2Returns);
	    logger.info("say2Returns" + say2Returns);

	    ModelAndView say3Returns = helloMockAction.mavDemo();
	    // System.out.println("say3Returns->" + say3Returns);
	    logger.info("say3Returns" + say3Returns);

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}

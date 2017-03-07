package application.iteration;

import android.test.ActivityInstrumentationTestCase2;

import com.heyniu.auto.Solo;

import org.junit.After;
import org.junit.Before;


@SuppressWarnings({"rawtypes", "deprecation"})
public class Iteration extends ActivityInstrumentationTestCase2 {

    /**
     * 被测应用Activity入口
     */
    private static final String LAUNCHER_ACTIVITY = "com.tuotuo.solo.view.welcome.SplashActivity";

    @SuppressWarnings("unchecked")
    public Iteration() throws ClassNotFoundException {
        super(Class.forName(LAUNCHER_ACTIVITY));
    }

    private Solo solo;

    @Before
    public void setUp() throws Exception {
        Solo.Config config = new Solo.Config();
        // 遍历模式
        config.mode = Solo.Config.Mode.NORMAL;
        config.commandLogging = true;
        config.isWebForHomeActivity = false;
        config.homeActivity = "com.tuotuo.solo.view.IndexPage2Activity";
        config.loginActivity = "com.tuotuo.solo.view.welcome.MobileLoginActivity";
        config.loginAccount = "15906626987";
        config.loginPassword = "123456";
        config.loginId = "next_step";
        config.ignoreActivities = new String[]{};
        config.ignoreViews = new String[]{};

        solo = new Solo(getInstrumentation(), config, getActivity());
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    /**
     * 登录操作
     * @throws Exception 抛出异常
     */
    public void test_00_login() throws Exception {
        solo.login();
    }

    /**
     * 自动遍历入口
     * @throws Exception 抛出异常
     */
    public void test_01_iteration() throws Exception {
        solo.startIteration();
    }

}
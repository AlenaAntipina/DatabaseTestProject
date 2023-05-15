package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import data.DataForTables;
import database.dao.AuthorDAOImpl;
import database.dao.ProjectDAOImpl;
import database.dao.SessionDAOImpl;
import database.dao.TestDAOImpl;
import database.table.models.Author;
import database.table.models.Project;
import database.table.models.Session;
import database.table.models.TestModel;
import internet.InternetPage;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.TimeUtils;

import java.sql.Timestamp;

public abstract class BaseTest {
    protected static Browser browser;

    SoftAssert softAssert = new SoftAssert();

    TestDAOImpl testDAO = new TestDAOImpl();
    AuthorDAOImpl authorDAO = new AuthorDAOImpl();
    ProjectDAOImpl projectDAO = new ProjectDAOImpl();
    SessionDAOImpl sessionDAO = new SessionDAOImpl();

    @BeforeClass
    public void setUp() {
        browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(InternetPage.getMainUrl());
        browser.waitForPageToLoad();
    }

    @AfterClass
    public void tearDown() {
        browser.quit();
    }

    @AfterMethod
    public void testResults(ITestResult result) {
        System.out.println("tests");
        Project project = new Project(DataForTables.getNameForProject());
        projectDAO.create(project);

        Session session = new Session(DataForTables.getSessionKeyForSession(),
                new Timestamp(TimeUtils.cutMilliseconds(System.currentTimeMillis())),
                DataForTables.getBuildNumberForSession());
        sessionDAO.create(session);

        Author author = new Author(DataForTables.getNameForAuthor(),
                DataForTables.getLoginForAuthor(), DataForTables.getEmailForAuthor());
        authorDAO.create(author);

        TestModel test = new TestModel(DataForTables.getNameTestForTest(),
                result.getStatus(), result.getName(), project.getId(), session.getId(),
                new Timestamp(TimeUtils.cutMilliseconds(result.getStartMillis())),
                new Timestamp(TimeUtils.cutMilliseconds(result.getEndMillis())),
                author.getName(), browser.getBrowserName().name());
        testDAO.create(test);

        softAssert = new SoftAssert();
        TestModel getTest = testDAO.get(test.getId());
        softAssert.assertEquals(getTest, test, "test was not added in the table TestModel or it is not equivalent");

        Author getAuthor = authorDAO.get(author.getId());
        softAssert.assertEquals(getAuthor, author, "author was not added in the table Author or it is not equivalent");

        Project getProject = projectDAO.get(project.getId());
        softAssert.assertEquals(getProject, project, "project was not added in the table Project or it is not equivalent");

        Session getSession = sessionDAO.get(session.getId());
        softAssert.assertEquals(getSession, session, "session was not added in the table Session or it is not equivalent");
        softAssert.assertAll();
    }
}

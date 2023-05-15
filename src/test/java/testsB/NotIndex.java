package testsB;

import data.DataForTables;
import database.dao.AuthorDAOImpl;
import database.dao.ProjectDAOImpl;
import database.dao.SessionDAOImpl;
import database.dao.TestDAOImpl;
import database.table.models.Author;
import database.table.models.Project;
import database.table.models.Session;
import database.table.models.TestModel;
import utils.TimeUtils;

import java.sql.Timestamp;

public class NotIndex {
    public static void main(String[] args) {
        TestDAOImpl testDAO = new TestDAOImpl();
        ProjectDAOImpl projectDAO = new ProjectDAOImpl();
        SessionDAOImpl sessionDAO = new SessionDAOImpl();
        AuthorDAOImpl authorDAO = new AuthorDAOImpl();

        Project project = new Project(DataForTables.getNameForProject());
        projectDAO.create(project);
        System.out.println(project.getId() + " " + project.getName());

        Session session = new Session(DataForTables.getSessionKeyForSession(),
                new Timestamp(TimeUtils.cutMilliseconds(System.currentTimeMillis())),
                DataForTables.getBuildNumberForSession());
        sessionDAO.create(session);
        System.out.println(session.getId() + " " + session.getBuildNumber());

        Author author = new Author(DataForTables.getNameForAuthor(),
                DataForTables.getLoginForAuthor(), DataForTables.getEmailForAuthor());
        authorDAO.create(author);
        System.out.println(author.getId() + " " + author.getName());

        TestModel test = new TestModel(DataForTables.getNameTestForTest(),
                1, DataForTables.getNameTestForTest(), project.getId(), session.getId(),
                new Timestamp(TimeUtils.cutMilliseconds(System.currentTimeMillis())),
                new Timestamp(TimeUtils.cutMilliseconds(System.currentTimeMillis())),
                author.getName(), "chrome");
        testDAO.create(test);
        System.out.println(test.getId() + " " + test.getName());
    }
}

package testsB;

import data.DataForTables;
import database.dao.TestDAOImpl;
import database.table.models.TestModel;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.stream.Collectors;

public abstract class  BaseTestB {
    TestDAOImpl testDAO = new TestDAOImpl();

    List<TestModel> testsForUpdate;

    @BeforeClass
    public void setUp() {
        testsForUpdate = testDAO
                .getAll()
                .stream()
                .filter(o -> String.valueOf(o.getId()).contains(DataForTables.getRandomDoubleNumber()))
                .limit(10)
                .collect(Collectors.toList());

        testsForUpdate.forEach(test -> System.out.println(test.getId()));
    }
}

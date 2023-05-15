package testsB;

import database.table.models.TestModel;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import steps.Steps;
import steps.StepsAsserts;


public class TestCookiesB extends BaseTestB {
    Steps steps = new Steps();
    StepsAsserts asserts = new StepsAsserts();

    @Test
    public void TestA() {
        steps.updateTestsInTestTable(testsForUpdate);
        asserts.isTestInTestTableUpdated(testsForUpdate);
    }

    @AfterMethod
    public void testResult(ITestResult result) {
        for (TestModel test : testsForUpdate) {
            testDAO.delete(test.getId());
        }
    }
}

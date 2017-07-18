package suits;

import advertising.TestAdvertising;
import cities.TestCities;
import companies.TestCompanies;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.TestPages;

/**
 *
 * @author Dejan
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({TestCompanies.class, 
                     TestAdvertising.class, 
                     TestPages.class, 
                     TestCities.class})
public class TestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}

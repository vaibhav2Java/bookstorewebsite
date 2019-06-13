import static org.junit.Assert.*;

import org.bookstore.dao.ReviewDao;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReviewDaotest {
	
	private static ReviewDao reviewDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reviewDao = new ReviewDao();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		reviewDao.close();
	}

	@Test
	public void testReview() {
		fail("Not yet implemented");
	}

}

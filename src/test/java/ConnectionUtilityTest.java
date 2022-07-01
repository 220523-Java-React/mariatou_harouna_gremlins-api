import com.revature.Util.ConnectionUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtilityTest {

    @Test
    public void whenGivenValidCredentialsGetConnectionReturnsValidConnection() throws SQLException{
        Connection connection = ConnectionUtility.getMyConnection();

        Assertions.assertNotNull(connection);
    }
}

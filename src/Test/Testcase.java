package Test;

import static org.junit.Assert.*;
import org.junit.Test.None;

import net.RestaurantManager.DAO.SQLiteDBExcute;
import org.junit.Test;

import java.sql.SQLException;

public class Testcase {
    @Test
    public void testConnection(){
        assertNotNull(SQLiteDBExcute.connect());
    }
}

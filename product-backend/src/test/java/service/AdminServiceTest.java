package service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.client.FailedToCreateBandException;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.kainos.ea.db.AdminDao;
import org.kainos.ea.api.AdminService;
import org.kainos.ea.cli.Admin;
import org.kainos.ea.db.DatabaseConnector;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

public class AdminServiceTest {
    AdminDao adminDao = Mockito.mock(AdminDao.class);
    DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);
    Connection conn = Mockito.mock(Connection.class);

    AdminService adminService = new AdminService(adminDao, databaseConnector);

    Admin admin = new Admin(
            "tomekk",
            2,
            "Bloggs"
    );

    @Test
    void createBand_shouldReturnId_whenDaoReturnsId() throws SQLException, FailedToCreateBandException {
        int expectedResult = 1;
        Mockito.when(adminDao.createBand(admin)).thenReturn((expectedResult));

        int result = adminService.createBand(admin);

        assertEquals(result, expectedResult);
    }

    @Test
    void createBand_shouldReturnError_whenDaoReturnsFail() throws SQLException, FailedToCreateBandException {
        int expectedResult = -1;
        Mockito.when(adminDao.createBand(admin)).thenReturn((expectedResult));

        assertThrows(FailedToCreateBandException.class,
                () -> adminService.createBand(admin));
    }
    @Test
    void createBand_shouldThrowSqlException_whenDaoThrowsSqlException() throws SQLException {
        Mockito.when(adminDao.createBand(admin)).thenThrow(SQLException.class);

        assertThrows(SQLException.class, () -> adminService.createBand(admin));
    }
}





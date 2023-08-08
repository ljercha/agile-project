package service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.client.FailedToCreateBandException;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.kainos.ea.db.BandDao;
import org.kainos.ea.api.AdminService;
import org.kainos.ea.cli.Admin;
import org.kainos.ea.db.DatabaseConnector;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

public class AdminServiceTest {
    BandDao bandDao = Mockito.mock(BandDao.class);
    DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);
    Connection conn = Mockito.mock(Connection.class);

    AdminService adminService = new AdminService(bandDao);

    Admin admin = new Admin(
            "tomekk",
            2,
            "Bloggs"
    );

    @Test
    void createBand_shouldReturnId_whenDaoReturnsId() throws SQLException, FailedToCreateBandException {
        int expectedResult = 1;
        Mockito.when(bandDao.createBand(admin)).thenReturn((expectedResult));

        int result = adminService.createBand(admin);

        assertEquals(result, expectedResult);
    }

    @Test
    void createBand_shouldReturnError_whenDaoReturnsFail() throws SQLException, FailedToCreateBandException {
        int expectedResult = -1;
        Mockito.when(bandDao.createBand(admin)).thenReturn((expectedResult));

        assertThrows(FailedToCreateBandException.class,
                () -> adminService.createBand(admin));
    }
    @Test
    void createBand_shouldThrowSqlException_whenDaoThrowsSqlException() throws SQLException {
        Mockito.when(bandDao.createBand(admin)).thenThrow(SQLException.class);

        assertThrows(SQLException.class, () -> adminService.createBand(admin));
    }
}





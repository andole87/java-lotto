package lotto.dao;

import lotto.domain.Ticket;
import lotto.domain.UserTickets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class UserTicketDao {
    private final UserTickets tickets;

    public UserTicketDao(UserTickets tickets) {
        this.tickets = tickets;
    }


    public Connection getConnection() throws SQLException {
        Connection conn = null;
        String server = "localhost"; // MySQL 서버 주소
        String database = "woowa"; // MySQL DATABASE 이름
        String userName = "andole"; //  MySQL 서버 아이디
        String password = "vkfkdto"; // MySQL 서버 비밀번호

        // 드라이버 로딩
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" !! JDBC Driver load 오류: " + e.getMessage());
            e.printStackTrace();
        }

        // 드라이버 연결
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?useSSL=false&serverTimezone=UTC", userName, password);
            System.out.println("정상적으로 연결되었습니다.");
        } catch (SQLException e) {
            System.err.println("연결 오류:" + e.getMessage());
            e.printStackTrace();
        }

        return conn;
    }

    public void insert() throws SQLException {
        for (Ticket ticket : tickets.tickets()) {
            insert(ticket);
        }
    }

    private void insert(Ticket ticket) throws SQLException {
        Connection conn = getConnection();
        String sql = "INSERT INTO user_lotto (
    }
}

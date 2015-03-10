package com.daveda.repository.dao.impl;

import com.daveda.repository.dao.UserInfoDAO;
import com.daweda.model.UserInfo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by elena on 04.03.15.
 */
public class UserInfoDAOImpl implements UserInfoDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(UserInfo userInfo, int userCredentialsID) {
        String sql = "INSERT INTO USERINFOTABLE " +
                "( userCredentialsID, host, cacheControl, accept, userAgent, acceptEncoding, " +
                "acceptLanguage, ISO3Countru, ISO3Language, protocol, remoteAddr," +
                "requestURI, geoIP)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,  userCredentialsID);
            ps.setString(2, userInfo.getHost());
            ps.setString(3, userInfo.getCacheControl());
            ps.setString(4, userInfo.getAccept());
            ps.setString(5, userInfo.getUserAgent());
            ps.setString(6, userInfo.getAcceptEncoding());
            ps.setString(7, userInfo.getAcceptLanguage());
            ps.setString(8, userInfo.getISO3Countru());
            ps.setString(9, userInfo.getISO3Language());
            ps.setString(10, userInfo.getProtocol());
            ps.setString(11, userInfo.getRemoteAddr());
            ps.setString(12, userInfo.getRequestURI());
            ps.setString(13, userInfo.getGeoIP());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }

    public UserInfo findById(int id) {

        String sql = "SELECT * FROM USERINFOTABLE WHERE userCredentialsID = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            UserInfo userInfo = null;
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                userInfo = new UserInfo(
                        rs.getInt("userCredentialsID"),
                        rs.getString("host"),
                        rs.getString("cacheControl"),
                        rs.getString("accept"),
                        rs.getString("userAgent"),
                        rs.getString("acceptEncoding"),
                        rs.getString("acceptLanguage"),
                        rs.getString("ISO3Countru"),
                        rs.getString("ISO3Language"),
                        rs.getString("protocol"),
                        rs.getString("remoteAddr"),
                        rs.getString("requestURI"),
                        rs.getString("geoIP")
                );
            }


            rs.close();
            ps.close();
            return userInfo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

}

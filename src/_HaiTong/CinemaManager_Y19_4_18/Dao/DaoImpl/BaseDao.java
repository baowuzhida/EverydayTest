package _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl;

import org.json.JSONArray;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BaseDao {
    private static final String url = "jdbc:mysql://localhost:3306/dvdsystem";
    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, "root", "xiaohu123");
            return connection;
        } catch (SQLException e) {
            //e.printStackTrace();
        }
        return null;
    }

    private static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }


    public static boolean excuteUpdate(String sql, List<Object> params) {
        int res = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(i + 1, params.get(i));
                }
            }
            res = pstmt.executeUpdate();

        } catch (SQLException e) {
            //e.printStackTrace();
        } finally {
            closeAll(rs, pstmt, conn);
        }
        return res > 0;
    }

    public static <T> List<T> executeQuery(String sql, List<Object> params, Class<T> cls) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<T> data = new ArrayList<T>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(i + 1, params.get(i));
                }
            }
            rs = pstmt.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            System.out.println(rsd.getColumnCount());
            while (rs.next()) {
                T m = cls.newInstance();
                for (int i = 0; i < rsd.getColumnCount(); i++) {
                    String col_name = rsd.getColumnName(i + 1);
                    Object value = rs.getObject(col_name);
                    System.out.println(value);
                    Field field = cls.getDeclaredField(col_name);//映射
                    field.setAccessible(true);//关闭安全检查提高速度
                    field.set(m, value);
                }
                data.add(m);
            }

        } catch (SQLException e) {
            //e.printStackTrace();
        } catch (IllegalAccessException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, pstmt, conn);
        }
        return data;
    }

    public static <T> List<Map<Object, Object>> executeQueryNocls(String sql, List<Object> params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Map<Object, Object>> data = new ArrayList<>();

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(i + 1, params.get(i));
                }
            }
            rs = pstmt.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();

            while (rs.next()) {
                Map<Object, Object> map = new HashMap<>();
                for (int i = 0; i < rsd.getColumnCount(); i++) {
                    String col_name = rsd.getColumnName(i + 1);
                    Object value = rs.getObject(col_name);
                    map.put(col_name,value);
                }
                data.add(map);
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        } finally {
            closeAll(rs, pstmt, conn);
        }
        return data;
    }

}

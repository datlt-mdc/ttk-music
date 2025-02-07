/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.utils;

import datlt.account.AccountDAO;
import datlt.account.AccountDTO;
import java.sql.SQLException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author doixu
 */
public class MyUtils {
    public static AccountDTO getCookieAccount(HttpServletRequest request) throws SQLException {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String username = cookie.getName();
                String password = cookie.getValue();

                AccountDAO dao = new AccountDAO();
                boolean isLogin = dao.checkLogin(username, password);

                if (isLogin) {
                    return dao.getAccount();
                }

            }
        }
        
        return null;
    }
}

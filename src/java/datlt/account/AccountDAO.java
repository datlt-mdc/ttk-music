/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.account;

import datlt.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author doixu
 */
public class AccountDAO implements Serializable {

    private List<AccountDTO> listAccount;

    private AccountDTO account;

    public AccountDTO getAccount() {
        return account;
    }

    public List<AccountDTO> getListAccount() {
        return listAccount;
    }

    public boolean checkLogin(String username, String password) throws SQLException {
        try (Connection con = DBUtils.makeConnection()) {
            String sql = "Select * from Account "
                    + "Where username = ? and password = ?";

            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setNString(1, username);
                stm.setNString(2, password);

                try (ResultSet rs = stm.executeQuery()) {

                    while (rs.next()) {
                        int ID = rs.getInt("ID");
                        username = rs.getNString("username");
                        password = rs.getNString("password");
                        String name = rs.getNString("name");
                        String phone = rs.getNString("phone");
                        String email = rs.getNString("email");
                        String address = rs.getNString("address");
                        String role = rs.getNString("role");
                        String status = rs.getNString("status");

                        account = new AccountDTO(ID, username, password, name, phone, email, address, role, status);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void searchByID(int searchID) throws SQLException {
        try (Connection con = DBUtils.makeConnection()) {
            String sql = "Select * from Account "
                    + "Where id = ?";

            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setInt(1, searchID);

                try (ResultSet rs = stm.executeQuery()) {

                    while (rs.next()) {
                        int ID = rs.getInt("ID");
                        String username = rs.getNString("username");
                        String password = rs.getNString("password");
                        String name = rs.getNString("name");
                        String phone = rs.getNString("phone");
                        String email = rs.getNString("email");
                        String address = rs.getNString("address");
                        String role = rs.getNString("role");
                        String status = rs.getNString("status");

                        account = new AccountDTO(ID, username, password, name, phone, email, address, role, status);
                    }
                }
            }
        }
    }

    public void searchLastName(String searchValue) throws SQLException {
        try (Connection con = DBUtils.makeConnection()) {
            String sql = "Select * from Account "
                    + "Where lastname like ?";
            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setNString(1, "%" + searchValue + "%");

                try (ResultSet rs = stm.executeQuery()) {
                    while (rs.next()) {
                        int ID = rs.getInt("ID");
                        String username = rs.getString("username");
                        String password = rs.getString("password");
                        String name = rs.getNString("name");
                        String phone = rs.getNString("phone");
                        String email = rs.getNString("email");
                        String address = rs.getNString("address");
                        String role = rs.getNString("role");
                        String status = rs.getNString("status");

                        AccountDTO dto = new AccountDTO(ID, username, password, name, phone, email, address, role, status);
                        if (listAccount == null) {
                            listAccount = new ArrayList<>();
                        }
                        listAccount.add(dto);
                    }
                }
            }
        }
    }

    public boolean deleteByPrimaryKey(String primaryKey) throws SQLException {
        try (Connection con = DBUtils.makeConnection()) {
            if (con != null) {
                String sql = "Delete from Account "
                        + "Where username = ?";

                try (PreparedStatement stm = con.prepareStatement(sql)) {

                    stm.setNString(1, primaryKey);

                    int row = stm.executeUpdate();
                    if (row > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean update(AccountDTO dto) throws SQLException {
        try (Connection con = DBUtils.makeConnection()) {
            if (con != null) {
                String sql = "Update Account "
                        + "Set password = ?, name = ?, phone = ?, email = ?, address = ?, role = ?, status = ?"
                        + "Where username = ?";

                try (PreparedStatement stm = con.prepareStatement(sql)) {

                    stm.setNString(1, dto.getPassword());
                    stm.setNString(2, dto.getName());
                    stm.setNString(3, dto.getPhone());
                    stm.setNString(4, dto.getEmail());
                    stm.setNString(5, dto.getRole());
                    stm.setNString(6, dto.getStatus());

                    int row = stm.executeUpdate();
                    if (row > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean insert(AccountDTO dto) throws SQLException {
        try (Connection con = DBUtils.makeConnection()) {
            String sql = "Insert into Account"
                    + "(username, password, name, phone, email, address, role, status) "
                    + "Values(?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setNString(1, dto.getUsername());
                stm.setNString(2, dto.getPassword());
                stm.setNString(3, dto.getName());
                stm.setNString(4, dto.getPhone());
                stm.setNString(5, dto.getEmail());
                stm.setNString(6, dto.getAddress());
                stm.setNString(7, dto.getRole());
                stm.setNString(8, dto.getStatus());

                return stm.execute();
            }
        } finally {
            return false;
        }
    }
}

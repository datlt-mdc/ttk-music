/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.course;

import datlt.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author doixu
 */
public class CourseDAO implements Serializable {

    private CourseDTO course;
    private List<CourseDTO> listCourse;
    private List<CourseDTO> listActiveCourse;

    public List<CourseDTO> getListCourse() {
        return listCourse;
    }
    
    public CourseDTO getCourse() {
        return course;
    }

    public List<CourseDTO> getAvailiableListCourse() {
        listActiveCourse = new ArrayList<>();
        if (listCourse == null) return null;
        for (CourseDTO courseDTO : listCourse) {
            if (courseDTO.getStatus().equals("Active") && courseDTO.getQuantity() > 0) {
                listActiveCourse.add(courseDTO);
            }
        }
        return listActiveCourse;
    }

    public void searchByName(String searchValue) {

        try (Connection con = DBUtils.makeConnection()) {
            String sql = "Select * from Course "
                    + "Where name like ?";

            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setString(1, "%" + searchValue + "%");

                try (ResultSet rs = stm.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getNString("name");
                        String imagePath = rs.getNString("imagePath");
                        String description = rs.getNString("description");
                        int tuitionFee = rs.getInt("tuitionFee");
                        Date startDate = rs.getDate("startCourseDate");
                        Date endDate = rs.getDate("endCourseDate");
                        String category = rs.getNString("category");
                        int quantity = rs.getInt("quantity");
                        Date lastUpdateDate = rs.getDate("lastUpdateDate");
                        String lastUpdateUsername = rs.getNString("lastUpdateUsername");
                        String status = rs.getNString("status");

                        CourseDTO dto = new CourseDTO(id, name, imagePath, description, tuitionFee, startDate, endDate, category, quantity, lastUpdateDate, lastUpdateUsername, status);

                        if (listCourse == null) {
                            listCourse = new ArrayList<>();
                        }

                        listCourse.add(dto);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void searchByNameAndCategory(String nameSearchValue, String categorySearchValue) {

        try (Connection con = DBUtils.makeConnection()) {
            String sql = "Select * from Course "
                    + "Where name like ? and category like ?";

            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setString(1, "%" + nameSearchValue + "%");
                stm.setString(2, "%" + categorySearchValue + "%");

                try (ResultSet rs = stm.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getNString("name");
                        String imagePath = rs.getNString("imagePath");
                        String description = rs.getNString("description");
                        int tuitionFee = rs.getInt("tuitionFee");
                        Date startDate = rs.getDate("startCourseDate");
                        Date endDate = rs.getDate("endCourseDate");
                        String category = rs.getNString("category");
                        int quantity = rs.getInt("quantity");
                        Date lastUpdateDate = rs.getDate("lastUpdateDate");
                        String lastUpdateUsername = rs.getNString("lastUpdateUsername");
                        String status = rs.getNString("status");

                        CourseDTO dto = new CourseDTO(id, name, imagePath, description, tuitionFee, startDate, endDate, category, quantity, lastUpdateDate, lastUpdateUsername, status);

                        if (listCourse == null) {
                            listCourse = new ArrayList<>();
                        }

                        listCourse.add(dto);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void searchByCategory(String searchValue) {

        try (Connection con = DBUtils.makeConnection()) {
            String sql = "Select * from Course "
                    + "Where category like ?";

            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setString(1, "%" + searchValue + "%");

                try (ResultSet rs = stm.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getNString("name");
                        String imagePath = rs.getNString("imagePath");
                        String description = rs.getNString("description");
                        int tuitionFee = rs.getInt("tuitionFee");
                        Date startDate = rs.getDate("startCourseDate");
                        Date endDate = rs.getDate("endCourseDate");
                        String category = rs.getNString("category");
                        int quantity = rs.getInt("quantity");
                        Date lastUpdateDate = rs.getDate("lastUpdateDate");
                        String lastUpdateUsername = rs.getNString("lastUpdateUsername");
                        String status = rs.getNString("status");

                        CourseDTO dto = new CourseDTO(id, name, imagePath, description, tuitionFee, startDate, endDate, category, quantity, lastUpdateDate, lastUpdateUsername, status);

                        if (listCourse == null) {
                            listCourse = new ArrayList<>();
                        }

                        listCourse.add(dto);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void searchByID(int id) {

        try (Connection con = DBUtils.makeConnection()) {
            String sql = "Select * from Course "
                    + "Where ID = ?";

            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setInt(1, id);

                try (ResultSet rs = stm.executeQuery()) {
                    while (rs.next()) {
                        id = rs.getInt("id");
                        String name = rs.getNString("name");
                        String imagePath = rs.getNString("imagePath");
                        String description = rs.getNString("description");
                        int tuitionFee = rs.getInt("tuitionFee");
                        Date startDate = rs.getDate("startCourseDate");
                        Date endDate = rs.getDate("endCourseDate");
                        String category = rs.getNString("category");
                        int quantity = rs.getInt("quantity");
                        Date lastUpdateDate = rs.getDate("lastUpdateDate");
                        String lastUpdateUsername = rs.getNString("lastUpdateUsername");
                        String status = rs.getNString("status");

                        CourseDTO dto = new CourseDTO(id, name, imagePath, description, tuitionFee, startDate, endDate, category, quantity, lastUpdateDate, lastUpdateUsername, status);

                        course = dto;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getAllCourse() {
        try (Connection con = DBUtils.makeConnection()) {
            String sql = "Select * from Course";

            try (PreparedStatement stm = con.prepareStatement(sql)) {
                try (ResultSet rs = stm.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getNString("name");
                        String imagePath = rs.getNString("imagePath");
                        String description = rs.getNString("description");
                        int tuitionFee = rs.getInt("tuitionFee");
                        Date startDate = rs.getDate("startCourseDate");
                        Date endDate = rs.getDate("endCourseDate");
                        String category = rs.getNString("category");
                        int quantity = rs.getInt("quantity");
                        Date lastUpdateDate = rs.getDate("lastUpdateDate");
                        String lastUpdateUsername = rs.getNString("lastUpdateUsername");
                        String status = rs.getNString("status");

                        CourseDTO dto = new CourseDTO(id, name, imagePath, description, tuitionFee, startDate, endDate, category, quantity, lastUpdateDate, lastUpdateUsername, status);

                        if (listCourse == null) {
                            listCourse = new ArrayList<>();
                        }

                        listCourse.add(dto);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getAllActiveCourse() {
        try (Connection con = DBUtils.makeConnection()) {
            String sql = "Select * from Course "
                    + "where status = ?";

            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setString(1, "Active");
                try (ResultSet rs = stm.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getNString("name");
                        String imagePath = rs.getNString("imagePath");
                        String description = rs.getNString("description");
                        int tuitionFee = rs.getInt("tuitionFee");
                        Date startDate = rs.getDate("startCourseDate");
                        Date endDate = rs.getDate("endCourseDate");
                        String category = rs.getNString("category");
                        int quantity = rs.getInt("quantity");
                        Date lastUpdateDate = rs.getDate("lastUpdateDate");
                        String lastUpdateUsername = rs.getNString("lastUpdateUsername");
                        String status = rs.getNString("status");

                        CourseDTO dto = new CourseDTO(id, name, imagePath, description, tuitionFee, startDate, endDate, category, quantity, lastUpdateDate, lastUpdateUsername, status);

                        if (listCourse == null) {
                            listCourse = new ArrayList<>();
                        }

                        listCourse.add(dto);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean update(CourseDTO dto) throws SQLException {
        try (Connection con = new DBUtils().makeConnection()) {
            String sql = "Update Course "
                    + "Set name = ?, imagePath = ?, description = ?, "
                    + "tuitionFee = ?, startCourseDate = ?, endCourseDate = ?, "
                    + "category = ?, quantity = ?, lastUpdateDate = ?, "
                    + "lastUpdateUsername = ?, status = ? "
                    + "Where id = ?";
            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setString(1, dto.getName());
                stm.setString(2, dto.getImagePath());
                stm.setString(3, dto.getDescription());
                stm.setInt(4, dto.getTuitionFee());
                if (dto.getStartDate() != null) {
                    stm.setDate(5, new java.sql.Date(dto.getStartDate().getTime()));
                } else {
                    stm.setNull(5, Types.DATE);
                }

                if (dto.getEndDate() != null) {
                    stm.setDate(6, new java.sql.Date(dto.getEndDate().getTime()));
                } else {
                    stm.setNull(6, Types.DATE);
                }
                stm.setString(7, dto.getCategory());
                stm.setInt(8, dto.getQuantity());
                stm.setDate(9, new java.sql.Date(dto.getLastUpdateDate().getTime()));
                stm.setString(10, dto.getLastUpdateUsername());
                stm.setString(11, dto.getStatus());
                stm.setInt(12, dto.getID());
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteByPrimaryKey(int primaryKey) throws SQLException {
        try (Connection con = DBUtils.makeConnection()) {
            if (con != null) {
                String sql = "Delete from Course "
                        + "Where ID = ?";

                try (PreparedStatement stm = con.prepareStatement(sql)) {

                    stm.setInt(1, primaryKey);

                    int row = stm.executeUpdate();
                    if (row > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean insert(CourseDTO dto) throws SQLException {
        try (Connection con = DBUtils.makeConnection()) {
            String sql = "Insert into Course(name, imagePath, description, "
                    + "tuitionFee, startCourseDate, endCourseDate, category, quantity, "
                    + "lastUpdateDate, lastUpdateUsername, status) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setString(1, dto.getName());
                stm.setString(2, dto.getImagePath());
                stm.setString(3, dto.getDescription());
                stm.setInt(4, dto.getTuitionFee());
                if (dto.getStartDate() != null) {
                    stm.setDate(5, new java.sql.Date(dto.getStartDate().getTime()));
                } else {
                    stm.setNull(5, Types.DATE);
                }

                if (dto.getEndDate() != null) {
                    stm.setDate(6, new java.sql.Date(dto.getEndDate().getTime()));
                } else {
                    stm.setNull(6, Types.DATE);
                }
                stm.setString(7, dto.getCategory());
                stm.setInt(8, dto.getQuantity());
                stm.setDate(9, new java.sql.Date(dto.getLastUpdateDate().getTime()));
                stm.setString(10, dto.getLastUpdateUsername());
                stm.setString(11, dto.getStatus());
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.course;

import java.util.Date;

/**
 *
 * @author doixu
 */
public class CourseDTO {

    private int ID;
    private String name;
    private String imagePath;
    private String description;
    private int tuitionFee;
    private Date startDate;
    private Date endDate;
    private String category;
    private int quantity;
    private int bookedQuantity;

    public int getBookedQuantity() {
        return bookedQuantity;
    }

    public void setBookedQuantity(int bookedQuantity) {
        this.bookedQuantity = bookedQuantity;
    }
    private Date lastUpdateDate;
    private String lastUpdateUsername;
    private String status;

    public CourseDTO() {
    }

    public CourseDTO(int ID, String name, String imagePath, String description,
            int tuitionFee, Date startDate, Date endDate, String category,
            int quantity, Date lastUpdateDate, String lastUpdateUsername, String status) {
        this.ID = ID;
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;
        this.tuitionFee = tuitionFee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.quantity = quantity;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateUsername = lastUpdateUsername;
        this.status = status;
    }

    public CourseDTO(String name, String imagePath, String description,
            int tuitionFee, Date startDate, Date endDate, String category,
            int quantity, Date lastUpdateDate, String lastUpdateUsername, String status) {
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;
        this.tuitionFee = tuitionFee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.quantity = quantity;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateUsername = lastUpdateUsername;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(int tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLastUpdateUsername() {
        return lastUpdateUsername;
    }

    public void setLastUpdateUsername(String lastUpdateUsername) {
        this.lastUpdateUsername = lastUpdateUsername;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}

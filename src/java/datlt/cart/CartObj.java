/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.cart;

import datlt.course.CourseDTO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author doixu
 */
public class CartObj implements Serializable {
    private String customerId;
    private Map<Integer, Integer> items;

    public CartObj() {
    }

    public CartObj(String customerId, Map<Integer, Integer> items) {
        this.customerId = customerId;
        this.items = items;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Map<Integer, Integer> getItems() {
        return items;
    }
    
    public void addItemToCart(int courseID, int quantity) {
        if (this.items == null) {
            this.items = new HashMap<Integer, Integer>();
        }
                
        if (this.items.containsKey(courseID)) {
            quantity = this.items.get(courseID) + quantity;
        }
        
        this.items.put(courseID, quantity);
    }
    
    public void updateItemQuantity(int courseID, int quantity) {
        if (this.items == null) {
            this.items = new HashMap<Integer, Integer>();
        }               
        
        this.items.put(courseID, quantity);
    }
    
    public void removeItemFromCart(Integer courseID) {
        if (this.items == null) {
            return;
        }
        
        if (this.items.containsKey(courseID)) {
            this.items.remove(courseID);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
    
    
}

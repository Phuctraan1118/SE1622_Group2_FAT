/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

/**
 *
 * @author hungp
 */
public class NotificationCreateForm {
    private int id;
    private String name;
    private String detail;
    private String username;

    public NotificationCreateForm() {
    }

    public NotificationCreateForm( String name, String detail, String username) {
        this.name = name;
        this.detail = detail;
        this.username = username;
    }

    public NotificationCreateForm(int id, String name, String detail, String username) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}

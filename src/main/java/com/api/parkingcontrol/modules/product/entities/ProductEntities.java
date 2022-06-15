package com.api.parkingcontrol.modules.product.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCT")
public class ProductEntities implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String jobTitle;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String imageUrl;
    @Column()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID employeeCode;

    public UUID getId() 
    {
        return id;
    }

    public void setId(UUID id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getJobTitle() 
    {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) 
    {
        this.jobTitle = jobTitle;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public UUID getEmployeeCode() 
    {
        return employeeCode;
    }
    
    public void setEmployeeCode(UUID employeeCode) 
    {
        this.employeeCode = employeeCode;
    }
}

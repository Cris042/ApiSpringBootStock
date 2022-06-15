package com.api.parkingcontrol.modules.product.dtos;

import javax.validation.constraints.NotBlank;

public class ProductDto 
{
    
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String jobTitle;
    @NotBlank
    private String phone;
    @NotBlank
    private String imageUrl;
   
   
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

    
}

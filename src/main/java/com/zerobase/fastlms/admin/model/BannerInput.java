package com.zerobase.fastlms.admin.model;


import lombok.Data;

@Data
public class BannerInput {
    
    long id;
    String bannerName;
    int sortValue;
    boolean usingYn;
    
}

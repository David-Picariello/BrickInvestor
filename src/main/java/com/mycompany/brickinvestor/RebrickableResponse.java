/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.brickinvestor;
import com.google.gson.annotations.SerializedName;
/**
 *
 * @author davidpicariello
 */
//{
//  "count": 1,
//  "next": null,
//  "previous": null,
//  "results": [
//    {
//      "set_num": "75342-1",
//      "name": "Republic Fighter Tank",
//      "year": 2022,
//      "theme_id": 158,
//      "num_parts": 262,
//      "set_img_url": "https://cdn.rebrickable.com/media/sets/75342-1/100360.jpg",
//      "set_url": "https://rebrickable.com/sets/75342-1/republic-fighter-tank/",
//      "last_modified_dt": "2022-03-31T20:35:45.622484Z"
//    }
//  ]
//}
public class RebrickableResponse {
    
    String name;
    @SerializedName("set_img_url")
    String setImgUrl;
    @SerializedName("num_parts")
    float numParts;
    String year;
    
    
}

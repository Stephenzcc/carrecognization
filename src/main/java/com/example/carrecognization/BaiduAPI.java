package com.example.carrecognization;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

public class BaiduAPI {
    //填入自己申请的AAP_ID APP_KEY SECRET_KEY
    public static final String APP_ID = "16685701";
    public static final String API_KEY = "dSjxQHSPiSVQ2eoehxCTnrzc";
    public static final String SECRET_KEY = "7KH3NmjCgmLEr5jukQfNF5mxRMTq0GsU";
    public static String start(String file){
        AipOcr aipOcr = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        return sample(aipOcr, file);                        //调用识别方法
    }
    private static String sample(AipOcr client, String file) {
        HashMap<String, String> options = new HashMap<String, String>();  // 传入可选参数调用接口

        String image = "C:\\Users\\DELL\\Desktop\\CarNumberPhoto\\"+file;
        JSONObject res = client.plateLicense(image, options);
        Object carNumObj = res.getJSONObject("words_result").get("number");
        String carNum = carNumObj.toString();
        return carNum;
    }
}

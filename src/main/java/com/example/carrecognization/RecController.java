package com.example.carrecognization;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/rec")
public class RecController {
    @RequestMapping("/ini")
    public String initLogin(){
        return "Recognize";
    }

    @RequestMapping("/submit")
    @ResponseBody
    public void submit(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        String result = sendPostRequest(BaiduAPI.start(request.getParameter("imgForm")), Integer.valueOf(request.getParameter("parkingId")));
        response.getWriter().print("<html><body><script type='text/javascript'>alert('"+result+"');</script></body></html>");
        response.getWriter().close();
    }

    /**
     * 向目的URL发送post请求
     * @param carNum    发送的参数
     * @return  AdToutiaoJsonTokenData
     */


    public String sendPostRequest(String carNum, Integer parkingId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("https://personalstudy.mynatapp.cc/coolparking/uservice/ucreateorder?carNum={carNum}&parkingId={parkingId}", null, String.class, carNum, parkingId);
    }



}

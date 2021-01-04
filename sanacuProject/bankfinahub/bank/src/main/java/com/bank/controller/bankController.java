package com.bank.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.service.bankService;
import com.google.gson.Gson;



@RestController
public class bankController {
	private Log log = LogFactory.getLog(this.getClass());

	@Autowired
	private bankService bankService;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String home(@RequestBody String json)
            throws JSONException {


    	   JSONObject object = new JSONObject(json);
    	   String bank  = object.getString("bank");
    	   double crebitCardCount = object.getDouble("crebitCardCount");
    	   double debitCardCount = object.getDouble("debitCardCount");
        String msg = null;
  
        JSONArray jsonArrayToSave = new JSONArray();
                JSONObject obj = new JSONObject();	 
                    obj.put("bank", bank);
                    obj.put("crebitCardCount", crebitCardCount);
                    obj.put("debitCardCount", debitCardCount);
                    jsonArrayToSave.put(obj);                       
        
       
        String bankDetails;
        if (jsonArrayToSave.length() != 0) {
        	bankDetails = jsonArrayToSave.toString();
        	bankDetails = bankDetails.replaceAll("\\\\", "");
            msg= bankService.savebankDetails(bankDetails);
        }
   
        Gson gson = new Gson();
        return gson.toJson(msg);
    }
	@RequestMapping(value = "/loadbankDeatils", method = RequestMethod.GET)
    @ResponseBody
    public String loadbankDeatils( HttpServletResponse response)
            throws JSONException {

		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        JSONArray jsonArray = new JSONArray();
        String bankDetails = null;
        List<Object[]> termDetailsList = bankService
                .findBankInfo();
        if (termDetailsList != null) {
            for (Object[] jsonValue : termDetailsList) {
                JSONObject obj = new JSONObject();
                obj.put("id", jsonValue[0]);
                obj.put("bank", jsonValue[1]);
                obj.put("creditCardCount", jsonValue[2]);
                obj.put("debitCardCount", jsonValue[3]);
                jsonArray.put(obj);
                bankDetails = jsonArray.toString();
            }
        }
    	
    	bankDetails = bankDetails.replaceAll("\\\\", "");
        Gson gson = new Gson();
        return gson.toJson(bankDetails);
	}
	
	
	
}

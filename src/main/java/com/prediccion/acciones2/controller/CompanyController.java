package com.prediccion.acciones2.controller;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.prediccion.acciones2.domain.Company;

@RequestMapping("/companys")
@Controller
@RooWebScaffold(path = "companys", formBackingObject = Company.class)
@RooWebJson(jsonObject = Company.class)
public class CompanyController {
	
    @RequestMapping(value = "/json/list",headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        //headers.add("Content-Type", "application/json; charset=utf-8");
        headers.add("Content-Type", "application/javascript");
        //List<Company> result = companyService.findAllCompanys();
        List<Company> result = Company.findCompanyEntries(1, 10, "recomendacionAverage", "DESC");
        Gson gson = new Gson();
        String companies = gson.toJson(result);
        
        
        /*
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, HEAD, PUT");
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Allow-Headers", "x-requested-with"); 
        headers.add("Access-Control-Max-Age", "3600");
        
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        headers.add("Access-Control-Max-Age", "3600");
        headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");        
         */
        //headers.setContentType(MediaType.APPLICATION_JSON);
        //String string_result = Company.toJsonArray(result);
        return new ResponseEntity<String>(companies, headers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/json/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        Company company = companyService.findCompany(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (company == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        Gson gson = new Gson();
        
        String s = gson.toJson(company);
        return new ResponseEntity<String>(s, headers, HttpStatus.OK);
    }
    
}

// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.prediccion.acciones2.controller;

import com.prediccion.acciones2.controller.CompanyController;
import com.prediccion.acciones2.domain.Company;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

privileged aspect CompanyController_Roo_Controller_Json {
    
    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> CompanyController.createFromJson(@RequestBody String json) {
        Company company = Company.fromJsonToCompany(json);
        companyService.saveCompany(company);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> CompanyController.createFromJsonArray(@RequestBody String json) {
        for (Company company: Company.fromJsonArrayToCompanys(json)) {
            companyService.saveCompany(company);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> CompanyController.updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Company company = Company.fromJsonToCompany(json);
        if (companyService.updateCompany(company) == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> CompanyController.deleteFromJson(@PathVariable("id") Long id) {
        Company company = companyService.findCompany(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (company == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        companyService.deleteCompany(company);
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
    
}

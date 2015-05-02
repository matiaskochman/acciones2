package com.prediccion.acciones2;
import com.prediccion.acciones2.domain.CompanyHistoric;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebJson(jsonObject = CompanyHistoric.class)
@Controller
@RequestMapping("/companyhistorics")
public class CompanyHistoricController {
}

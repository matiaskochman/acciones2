package com.prediccion.acciones2;
import com.prediccion.acciones2.domain.QueryLog;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebJson(jsonObject = QueryLog.class)
@Controller
@RequestMapping("/querylogs")
public class QueryLogController {
}

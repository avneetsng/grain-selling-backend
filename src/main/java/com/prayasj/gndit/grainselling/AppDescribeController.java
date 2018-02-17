package com.prayasj.gndit.grainselling;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppDescribeController {

  @RequestMapping("/desc")
  @ResponseBody
  String describe() {
    return "Kisan grain selling app by Prayas Jain";
  }
}

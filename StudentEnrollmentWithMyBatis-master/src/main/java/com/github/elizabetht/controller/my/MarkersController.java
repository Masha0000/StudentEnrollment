package com.github.elizabetht.controller.my;

import com.github.elizabetht.model.my.*;
import com.github.elizabetht.service.my.ServiceFigure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
public class MarkersController {
    @Autowired
    private ServiceFigure figureService;
    //Проще говоря, аннотация используется для сопоставления веб-запросов
    //с методами Spring Controller.


    @RequestMapping(value ={"/modify"},method = RequestMethod.POST)
    public String saveFigure(@RequestBody FeatureJs marker)//{ throws NotFoundException {
    {
        Figure markerController = new Figure(marker);
        figureService.insertFigure(markerController);
       // model.addAttribute("message", "Saved figures");
        return "marker";//???
    }

    @RequestMapping(value = "/index")
    public String openIndex(Model model) {
        model.addAttribute("message", "Open");
        return "index";//???
    }

    @RequestMapping(value = "/marker")
    public String openMap(Model model) {
        model.addAttribute("message", "Open");
        return "marker";//???
    }
}
    //        @RequestMapping(value="/delete", method=RequestMethod.POST)
//        public String delete(@ModelAttribute("markers") Integer id, Model model) {
//
//            figureService.deleteFigure(id);
//            model.addAttribute("message", "Saved figures");
//            return "markerspage";//???
//        }
//
//
/*
        @RequestMapping(value="/read", method=RequestMethod.GET)
        public String login(Model model) {
            StudentLogin studentLogin = new StudentLogin();
            model.addAttribute("studentLogin", studentLogin);
            return "login";
        }
    *//*
        @RequestMapping(value="/read", method=RequestMethod.GET)
        public String read(Model model)
            //??доставать мы каждую доллжны или все сразу
        {//list figure
            Figure found = figureService.ReadModel();
           model.addAttribute("figures",found) ;
            return "tmp3";
        }
    }*/



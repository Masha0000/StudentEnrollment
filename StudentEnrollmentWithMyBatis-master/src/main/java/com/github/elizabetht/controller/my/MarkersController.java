package com.github.elizabetht.controller.my;

import com.github.elizabetht.DTO.CoordinateDTO;
import com.github.elizabetht.model.my.*;
import com.github.elizabetht.service.my.FigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MarkersController {
    @Autowired
    private FigureService figureService;

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String saveFigure( FeatureJs marker)//{ throws NotFoundException {@RequestBody
    {
         System.out.print(marker.getName()+"Name");

      //= new Figure(marker);
        ArrayList<Point> a=new ArrayList<Point>();
        a.add(new Point(2.0, 4.0));
        a.add(new Point(4.0, 8.0));
        Figure markerController=new Figure("Poligon",a);
        figureService.insertFigure(markerController);
                return "marker";//???
    }

    @RequestMapping(value = "/")
    public String openIndex(Model model) {
        model.addAttribute("message", "Open");
        return "index";//???
    }

    @RequestMapping(value = "/marker", method = RequestMethod.GET)
    public String openMap(Model model) {
        model.addAttribute("message", "Open");
        return "marker";//???
    }

    @RequestMapping(value = "/getfeature", method = RequestMethod.GET)
    public @ResponseBody List<Figure> getFeature(Model model) {
        List<Figure> figureList=figureService.ReadModel();
       // model.addAttribute(figureList);
       // model.addAttribute("message", "Open");
        return figureList ;//???
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



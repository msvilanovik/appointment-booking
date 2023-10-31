package com.nativecreativa.appointment_booking.Controllers;

import com.nativecreativa.appointment_booking.Model.FitnessCenter;
import com.nativecreativa.appointment_booking.Service.FitnessCenter_Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fitness-centers")
public class FitnessCenterController {
    private final FitnessCenter_Service fitnessCenterService;

    public FitnessCenterController(FitnessCenter_Service fitnessCenterService) {
        this.fitnessCenterService = fitnessCenterService;
    }
    @GetMapping
    public String getFitenssCenters(Model model){
        List<FitnessCenter> fitnessCenterList = fitnessCenterService.listAll();
        model.addAttribute("fitnesscenters",fitnessCenterList);
        return "fitness_centers";
    }
    @GetMapping("/manage")
    public String show_add_new_fitnessCenter(){return "add_new_fitnessCenter";}
    @GetMapping("/manage/{id}")
    public String show_edit_fitnessCenter(@PathVariable Long id, Model model){
        model.addAttribute("fitnessCenter",this.fitnessCenterService.findById(id));
        return "add_new_fitnessCenter";
    }
    @PostMapping("/manage")
    public String add_new_fitnessCenter(@RequestParam String name,
                                        @RequestParam String description,
                                        @RequestParam String location,
                                        @RequestParam String address,
                                        @RequestParam String telephone){
        this.fitnessCenterService.addNew(new FitnessCenter(name,description,location,address,telephone));
        return "redirect:/fitness-centers";
    }
    @PostMapping("/manage/{id}")
    public String edit_fitnessCenter(@PathVariable Long id,
                                        @RequestParam String name,
                                        @RequestParam String description,
                                        @RequestParam String location,
                                        @RequestParam String address,
                                        @RequestParam String telephone){
        this.fitnessCenterService.update(id,name,description,location,address,telephone);
        return "redirect:/fitness-centers";
    }
    @PostMapping("/delete/{id}")
    public String delete_fitnessCenter(@PathVariable Long id){
        this.fitnessCenterService.delete(id);
        return "redirect:/fitness-centers";
    }

}

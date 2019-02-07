package org.project.web;

import org.project.dto.ScheduleDTO;
import org.project.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

//    @RequestMapping(path = "/schedule/{id}", method = RequestMethod.GET)
//    public ScheduleDTO getSchedule(@PathVariable("id") {
//        return scheduleService.getScheduleByDate();
//    }


//    @RequestMapping(path = "/schedule", method = RequestMethod.POST)
//    public void saveRunnedGame(@RequestBody ScheduleDTO scheduleDTO) {
//        scheduleService.save (scheduleDTO);
//    }


//    @RequestMapping(path = "/schedule/{id}", method = RequestMethod.PUT)
//    public ScheduleDTO updateSchedule(@PathVariable long id, @RequestBody ScheduleDTO dto) {
//        return scheduleService.updateSchedule(id, dto);
//    }
//
//    @RequestMapping(path = "/schedule/{id}", method = RequestMethod.DELETE)
//    public void deleteSchedule(@PathVariable("id") long id) {
//        ScheduleService.deleteScheduleById(id);
//    }
}
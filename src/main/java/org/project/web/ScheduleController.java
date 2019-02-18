package org.project.web;

import org.project.dto.ScheduleDTO;
import org.project.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(path = "/schedule/{id}", method = RequestMethod.GET)
    public ScheduleDTO getSchedule(@PathVariable("id") long id) {
        return scheduleService.getScheduleById(id);
    }

    @RequestMapping(path = "/schedule", method =RequestMethod.GET)
    public List<ScheduleDTO> getSchedules(){
        return scheduleService.getSchedules();
    }


    @RequestMapping(path = "/schedule", method = RequestMethod.POST)
    public ScheduleDTO saveSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        scheduleService.saveSchedule(scheduleDTO);
        return scheduleDTO;
    }

    @RequestMapping(path = "/schedule/{id}", method = RequestMethod.PUT)
    public ScheduleDTO updateSchedule(@PathVariable long id, @RequestBody ScheduleDTO dto) {
        return scheduleService.updateSchedule(id, dto);
    }

    @RequestMapping(path = "/schedule/{id}", method = RequestMethod.DELETE)
    public void deleteSchedule(@PathVariable("id") long id) {
        scheduleService.deleteScheduleById(id);
    }
}
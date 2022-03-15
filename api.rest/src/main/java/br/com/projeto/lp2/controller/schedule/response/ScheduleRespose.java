package br.com.projeto.lp2.controller.schedule.response;

import br.com.projeto.lp2.controller.service.response.ServiceResponse;
import br.com.projeto.lp2.controller.user.response.UserResponse;
import br.com.projeto.lp2.core.domain.Schedule;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class ScheduleRespose {

    private String id;
    private ServiceResponse service;
    private UserResponse user;
    private LocalDate date;
    private LocalTime hours;

        public ScheduleRespose fromSchedule(Schedule schedule, ServiceResponse service, UserResponse user) {
        this.id = schedule.getId();
        this.service = service;
        this.user = user;
        this.date = schedule.getTime().toLocalDate();
        this.hours = schedule.getTime().toLocalTime();
        return this;
    }
}

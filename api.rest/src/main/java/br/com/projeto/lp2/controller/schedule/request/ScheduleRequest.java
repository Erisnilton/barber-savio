package br.com.projeto.lp2.controller.schedule.request;

import br.com.projeto.lp2.core.domain.Schedule;
import br.com.projeto.lp2.core.domain.Service;
import br.com.projeto.lp2.core.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
public class ScheduleRequest {
    @NotNull
    private ObjectId serviceId;
    @NotNull
    private LocalDateTime time;
    @NotNull
    private ObjectId userId;

    public Schedule toSchedule() {
        Schedule schedule = new Schedule();
        schedule.setService(serviceId);
        schedule.setTime(time);
        schedule.setUser(userId);
        return  schedule;
    }
}

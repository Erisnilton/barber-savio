package br.com.projeto.lp2.core.ports.driver.schedule;

import br.com.projeto.lp2.core.domain.Schedule;
import org.bson.types.ObjectId;

import java.util.List;

public interface CreateSchedulePort {
    Schedule apply(Schedule schedule);
}

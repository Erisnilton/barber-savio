package br.com.projeto.lp2.core.ports.driver.schedule;

import br.com.projeto.lp2.core.domain.Schedule;

public interface UpdateSchedulePort {
    Schedule apply(String id, Schedule schedule);
}

package br.com.projeto.lp2.core.ports.driver.schedule;

import br.com.projeto.lp2.core.domain.Schedule;

public interface GetScheduleByIdPort {
    Schedule apply(String id);
}

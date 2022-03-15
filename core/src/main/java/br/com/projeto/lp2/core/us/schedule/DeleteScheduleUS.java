package br.com.projeto.lp2.core.us.schedule;

import br.com.projeto.lp2.core.ports.driven.repository.schedule.ScheduleRepositoryPort;
import br.com.projeto.lp2.core.ports.driver.schedule.DeleteSchedulePort;
import org.springframework.stereotype.Service;

@Service
public record DeleteScheduleUS(ScheduleRepositoryPort repository) implements DeleteSchedulePort {
    @Override
    public void apply(String id) {
        repository.deleteScheduleById(id);
    }
}

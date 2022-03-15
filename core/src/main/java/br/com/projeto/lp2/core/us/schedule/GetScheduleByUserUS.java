package br.com.projeto.lp2.core.us.schedule;

import br.com.projeto.lp2.core.domain.Schedule;
import br.com.projeto.lp2.core.ports.driven.repository.schedule.ScheduleRepositoryPort;
import br.com.projeto.lp2.core.ports.driver.schedule.GetScheduleByUserPort;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public record GetScheduleByUserUS(ScheduleRepositoryPort repository) implements GetScheduleByUserPort {
    @Override
    public List<Schedule> aplly(ObjectId userId) {

        return repository.findAll()
                .stream()
                .filter(schedule -> schedule.getUser().equals(userId))
                .collect(Collectors.toList());
        }
}

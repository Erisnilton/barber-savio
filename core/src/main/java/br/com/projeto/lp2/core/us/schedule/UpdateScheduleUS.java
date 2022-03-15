package br.com.projeto.lp2.core.us.schedule;

import br.com.projeto.lp2.core.domain.Schedule;
import br.com.projeto.lp2.core.ports.driven.repository.schedule.ScheduleRepositoryPort;
import br.com.projeto.lp2.core.ports.driver.schedule.UpdateSchedulePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record UpdateScheduleUS(ScheduleRepositoryPort repository) implements UpdateSchedulePort {
    @Override
    public Schedule apply(String id, Schedule schedule) {
        Optional<Schedule> scheduleOptional = repository.findById(id);
      return scheduleOptional.map(scheduleForUpdating -> {
            scheduleForUpdating.setTime(schedule.getTime());
            return repository.save(scheduleForUpdating);
        }).orElseThrow(() -> new IllegalArgumentException("Não foi possivel atualizar o agendamento"));
    }
}

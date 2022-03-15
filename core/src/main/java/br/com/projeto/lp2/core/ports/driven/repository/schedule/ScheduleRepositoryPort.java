package br.com.projeto.lp2.core.ports.driven.repository.schedule;

import br.com.projeto.lp2.core.domain.Schedule;
import br.com.projeto.lp2.core.domain.User;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepositoryPort {
    Schedule save(Schedule schedule);

    List<Schedule> findAll();

    Optional<Schedule> findById(String id);

    void deleteScheduleById(String id);
}

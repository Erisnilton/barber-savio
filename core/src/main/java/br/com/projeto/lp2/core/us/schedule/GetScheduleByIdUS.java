package br.com.projeto.lp2.core.us.schedule;

import br.com.projeto.lp2.core.domain.Schedule;
import br.com.projeto.lp2.core.ports.driven.repository.schedule.ScheduleRepositoryPort;
import br.com.projeto.lp2.core.ports.driver.schedule.GetScheduleByIdPort;
import org.springframework.stereotype.Service;

@Service
public record GetScheduleByIdUS(ScheduleRepositoryPort repository)  implements GetScheduleByIdPort {
    @Override
    public Schedule apply(String id) {
       return repository
               .findById(id)
               .orElseThrow(() ->
                       new IllegalArgumentException("Não foi possivel encontrar o agendamento."));
    }
}

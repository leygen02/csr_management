package io.impacthub.impacthub.repos;

import io.impacthub.impacthub.domain.Events;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventsRepository extends JpaRepository<Events, Integer> {
}

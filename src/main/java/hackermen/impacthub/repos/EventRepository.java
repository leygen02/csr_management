package hackermen.impacthub.repos;

import hackermen.impacthub.domain.Event;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<Event, UUID> {
}

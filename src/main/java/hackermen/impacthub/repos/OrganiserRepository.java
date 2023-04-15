package hackermen.impacthub.repos;

import hackermen.impacthub.domain.Organiser;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrganiserRepository extends JpaRepository<Organiser, UUID> {
}

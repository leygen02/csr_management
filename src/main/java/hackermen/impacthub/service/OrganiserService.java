package hackermen.impacthub.service;

import hackermen.impacthub.domain.Organiser;
import hackermen.impacthub.model.OrganiserDTO;
import hackermen.impacthub.repos.OrganiserRepository;
import hackermen.impacthub.util.NotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class OrganiserService {

    private final OrganiserRepository organiserRepository;

    public OrganiserService(final OrganiserRepository organiserRepository) {
        this.organiserRepository = organiserRepository;
    }

    public List<OrganiserDTO> findAll() {
        final List<Organiser> organisers = organiserRepository.findAll(Sort.by("organiserID"));
        return organisers.stream()
                .map((organiser) -> mapToDTO(organiser, new OrganiserDTO()))
                .toList();
    }

    public OrganiserDTO get(final UUID organiserID) {
        return organiserRepository.findById(organiserID)
                .map(organiser -> mapToDTO(organiser, new OrganiserDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public UUID create(final OrganiserDTO organiserDTO) {
        final Organiser organiser = new Organiser();
        mapToEntity(organiserDTO, organiser);
        return organiserRepository.save(organiser).getOrganiserID();
    }

    public void update(final UUID organiserID, final OrganiserDTO organiserDTO) {
        final Organiser organiser = organiserRepository.findById(organiserID)
                .orElseThrow(NotFoundException::new);
        mapToEntity(organiserDTO, organiser);
        organiserRepository.save(organiser);
    }

    public void delete(final UUID organiserID) {
        organiserRepository.deleteById(organiserID);
    }

    private OrganiserDTO mapToDTO(final Organiser organiser, final OrganiserDTO organiserDTO) {
        organiserDTO.setOrganiserID(organiser.getOrganiserID());
        organiserDTO.setFirstName(organiser.getFirstName());
        organiserDTO.setLastName(organiser.getLastName());
        organiserDTO.setEmailID(organiser.getEmailID());
        organiserDTO.setDesignation(organiser.getDesignation());
        return organiserDTO;
    }

    private Organiser mapToEntity(final OrganiserDTO organiserDTO, final Organiser organiser) {
        organiser.setFirstName(organiserDTO.getFirstName());
        organiser.setLastName(organiserDTO.getLastName());
        organiser.setEmailID(organiserDTO.getEmailID());
        organiser.setDesignation(organiserDTO.getDesignation());
        return organiser;
    }

}

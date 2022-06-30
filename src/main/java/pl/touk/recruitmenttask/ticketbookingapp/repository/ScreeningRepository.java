package pl.touk.recruitmenttask.ticketbookingapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.touk.recruitmenttask.ticketbookingapp.model.Screening;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
    List<Screening> findAllByStartTimeIsAfter(LocalDateTime startTime, Pageable pageable);
    List<Screening> findByStartTimeBetween(LocalDateTime start, LocalDateTime end, Sort sortMethod);
}

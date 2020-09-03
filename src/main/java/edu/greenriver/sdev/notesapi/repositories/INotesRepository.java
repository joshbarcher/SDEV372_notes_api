package edu.greenriver.sdev.notesapi.repositories;

import edu.greenriver.sdev.notesapi.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotesRepository extends JpaRepository<Note, Integer> {
}


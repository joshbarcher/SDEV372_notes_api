package edu.greenriver.sdev.notesapi.services;

import edu.greenriver.sdev.notesapi.entities.Note;
import edu.greenriver.sdev.notesapi.repositories.INotesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private INotesRepository repo;

    public NoteService(INotesRepository repo) {
        this.repo = repo;
    }

    //GET
    public List<Note> getNotes() {
        //get all Note objects from the database
        return repo.findAll();
    }

    public Note getNote(int id) {
        //get all Note objects from the database
        return repo.findById(id).get();
    }

    public boolean noteExists(int id) {
        return repo.findById(id).isPresent();
    }

    //POST
    public Note addNote(Note note) {
        return repo.save(note);
    }

    //PUT
    public Note editNote(int id, Note changes) {
        Note toEdit = repo.findById(id).get();

        //copy fields over
        toEdit.setCategory(changes.getCategory());
        toEdit.setContents(changes.getContents());

        //save changes
        return repo.save(toEdit);
    }

    //DELETE
    public void deleteNote(int id) {
        repo.deleteById(id);
    }
}


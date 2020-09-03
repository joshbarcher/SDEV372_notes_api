package edu.greenriver.sdev.notesapi.bootstrap;

import edu.greenriver.sdev.notesapi.entities.Note;
import edu.greenriver.sdev.notesapi.repositories.INotesRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements
    ApplicationListener<ContextRefreshedEvent> {
    private INotesRepository repo;

    public DataLoader(INotesRepository repo) {
        this.repo = repo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        String[] categories = {"todo", "todo", "urgent", "learning"};
        String[] notes = {"wash dishes", "walk dog", "get oil change",
                "watch Spring video"};

        for (int i = 0; i < categories.length; i++) {
            repo.save(new Note(categories[i], notes[i]));
        }
    }
}


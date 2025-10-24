package ma.youcode.service.impl;

import ma.youcode.model.Director;
import ma.youcode.repository.DirectorRepository;
import ma.youcode.service.DirectorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DirectorServiceImpl implements DirectorService {

    DirectorRepository directorRepository;

    public DirectorServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public Director create(Director director) {
        directorRepository.save(director);
        return director;
    }

    @Override
    public Director update(Long id, Director director) {
        Optional<Director> byId = directorRepository.findById(id);
        if (byId.isPresent()) {
            Director existingDirector = byId.get();
            existingDirector.setFirstName(director.getFirstName());
            existingDirector.setLastName(director.getLastName());
            existingDirector.setBirthDate(director.getBirthDate());
            existingDirector.setNationality(director.getNationality());
            existingDirector.setBiography(director.getBiography());
            directorRepository.save(existingDirector);
            return existingDirector;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        directorRepository.deleteById(id);
    }

    @Override
    public Director findById(Long id) {
        return directorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Director> findAll() {
        return directorRepository.findAll();
    }
}

package com.bucketdev.betapppoolsvc.service.impl;

import com.bucketdev.betapppoolsvc.domain.PoolSettings;
import com.bucketdev.betapppoolsvc.dto.PoolSettingsDTO;
import com.bucketdev.betapppoolsvc.repository.PoolSettingsRepository;
import com.bucketdev.betapppoolsvc.service.PoolSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author rodrigo.loyola
 */
@Service
public class PoolSettingsServiceImpl implements PoolSettingsService {

    @Autowired
    private PoolSettingsRepository repository;

    /*@Autowired
    private TournamentRepository tournamentRepository;*/

    @Override
    public PoolSettingsDTO upsert(PoolSettingsDTO dto) {
        PoolSettings poolSettings = new PoolSettings();
        Optional<PoolSettings> optionalPoolSettings = repository.findByTournamentId(dto.getTournamentId());
        if(optionalPoolSettings.isPresent())
            poolSettings = optionalPoolSettings.get();
        else {
            /*Optional<Tournament> optionalTournament = tournamentRepository.findById(dto.getTournamentId());
            if(!optionalTournament.isPresent())
                throw new TournamentNotFoundException("id: " + dto.getTournamentId());
            poolSettings.setTournament(optionalTournament.get());*/
        }
        poolSettings.setValuesFromDTO(dto);

        return repository.save(poolSettings).toDTO();
    }

}

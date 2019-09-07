package com.bucketdev.betapppoolsvc.service;

import com.bucketdev.betapppoolsvc.dto.PoolSettingsDTO;

/**
 * @author rodrigo.loyola
 */
public interface PoolSettingsService {

    PoolSettingsDTO upsert(PoolSettingsDTO dto);

}

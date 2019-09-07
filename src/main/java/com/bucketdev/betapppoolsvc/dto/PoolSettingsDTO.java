package com.bucketdev.betapppoolsvc.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author rodrigo.loyola
 */
@Data
public class PoolSettingsDTO implements Serializable {

    private long id;
    private long tournamentId;
    private float balance;
    private String description;
    private float amount;
    private float goal;
    @JsonFormat(timezone = "GMT-06:00")
    private Calendar limitDate;

}

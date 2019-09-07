package com.bucketdev.betapppoolsvc.domain;

import com.bucketdev.betapppoolsvc.dto.PoolSettingsDTO;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * @author rodrigo.loyola
 */
@Entity
@Table(name = "pool_settings")
@Data
public class PoolSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    private long tournamentId;

    @Column
    private float balance;

    @Column
    private String description;

    @Column
    private float amount;

    @Column
    private float goal;

    @Column
    @Temporal(TemporalType.DATE)
    private Calendar limitDate;

    public PoolSettingsDTO toDTO() {
        PoolSettingsDTO dto = new PoolSettingsDTO();

        dto.setId(id);
        dto.setTournamentId(tournamentId);
        dto.setBalance(balance);
        dto.setDescription(description);
        dto.setAmount(amount);
        dto.setGoal(goal);
        dto.setLimitDate(limitDate);

        return dto;
    }

    public void setValuesFromDTO(PoolSettingsDTO dto) {
        balance = dto.getBalance();
        description = dto.getDescription();
        amount = dto.getAmount();
        goal = dto.getGoal();
        limitDate = dto.getLimitDate();
    }

}

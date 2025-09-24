package com.uis.project.persistences.models;

import com.uis.project.persistences.models.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(indexes = {
        @Index(name = "rfid_code", columnList = "rfid_code", unique = true)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rfid_code")
    private String RFIDCode;
    @Column(name = "issued_at")
    private LocalDateTime IssuedAt;

    @Enumerated(EnumType.STRING)
    private CardStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    /**
     * <p>
     *     Porteger la mutabilidad del campo con reglas de negocio,
     *     evitando problemas con la serialización y deseralización
     *     al utilizar Jackson
     * </p>
     * @param RFIDCode Código único de tarjeta
     */
    public void setRFIDCode(String RFIDCode) {
        if(this.RFIDCode != null) {
            throw new IllegalStateException("RFIDCode cannot be changed once set");
        }

        this.RFIDCode = RFIDCode;
    }

}

package com.sedef.notes.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity()
@Table(name = "activity")
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String header;

    private String description;

    private LocalDateTime startTime; // Başlangıç zamanı
    private LocalDateTime endTime;   // Bitiş zamanı
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


}

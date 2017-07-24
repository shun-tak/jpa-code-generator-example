package com.github.shuntak.generator.example.hello.entity.ext.master;

import com.github.shuntak.generator.example.hello.entity.AbstractCard;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@NoArgsConstructor
@Entity
@Table(name = "card")
public class Card extends AbstractCard {
    @Builder
    public Card(Integer id, String name, Integer rarity, boolean isAvailable) {
        super(id, name, rarity, isAvailable);
    }
}

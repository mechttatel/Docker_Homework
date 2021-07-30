package com.drink.drink.dto.tag;

import com.drink.drink.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

/**
 * Класс который отвечает за переопределение инфы из бд в инфу java
 *
 * @author Алексей Моисейчев
 * @author Иван Вязовкин
 */
@Log4j2
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Class TagDto
 */
public class TagDto {

    private String name;

    /**
     * Tag of TagDto
     * @param tag
     * @return TagDto
     */
    public static TagDto of(Tag tag) {
        TagDto tagDto = new TagDto();
        tagDto.setName(tag.getName());
        log.info("Tag to TagDto.  Class TagDto, method of");
        return tagDto;
    }
}

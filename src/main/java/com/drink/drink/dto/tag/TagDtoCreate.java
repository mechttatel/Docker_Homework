package com.drink.drink.dto.tag;

import com.drink.drink.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Log4j2
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Class TagDtoCreate
 */
public class TagDtoCreate {

    @NotEmpty(message = "Name should be empty")
    @Size(min = 2, max = 64, message = "Name value 2-64 characters")
    private String name;
    //private List<Integer> cocktailList;

    /**
     * TagDtoCreate to Tag
     * @param tagDtoCreate
     * @return Tag
     */
    public static Tag of(TagDtoCreate tagDtoCreate) {
        Tag tag = new Tag();
        tag.setName(tagDtoCreate.getName());
        log.info("TagDtoCreate to Tag.  Class TagDtoCreate, method of");
        return tag;
    }
}

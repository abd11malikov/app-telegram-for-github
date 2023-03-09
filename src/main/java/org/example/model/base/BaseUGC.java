package org.example.model.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseUGC extends BaseModel{
    private String photo;
    private String bio;
    private String name;
    private String link;
}

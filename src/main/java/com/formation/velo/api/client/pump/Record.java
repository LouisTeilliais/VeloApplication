package com.formation.velo.api.client.pump;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Record {
    @SerializedName("recordid")
    private String recordId;
    @SerializedName("fields")
    private Field field;
}

package com.formation.velo.api.client.pump;

import com.formation.velo.api.client.Record;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenData {
    private Record[] records;
}
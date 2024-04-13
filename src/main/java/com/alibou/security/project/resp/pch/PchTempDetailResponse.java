package com.alibou.security.project.resp.pch;

import com.alibou.security.project.entity.pch.PchTempDetail;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PchTempDetailResponse {
        @JsonProperty("templst")
    private List<PchTempDetail> list;
}

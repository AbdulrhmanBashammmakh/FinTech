package com.alibou.security.project.request;

import com.alibou.security.project.entity.pch.PchTempDetail;
import com.alibou.security.project.entity.pch.PchTempHead;
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
public class TempRequest {

    @JsonProperty("temp")
    PchTempHead invoicePurch;
    @JsonProperty("items")
    List<PchTempDetail> tempPurchDetails;




}

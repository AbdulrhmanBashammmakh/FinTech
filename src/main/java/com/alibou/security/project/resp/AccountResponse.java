package com.alibou.security.project.resp;

import com.alibou.security.project.entity.Accounts;
import com.alibou.security.project.entity.Unit;
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
public class AccountResponse {
    @JsonProperty("acclst")
    private List<Accounts> list;
}